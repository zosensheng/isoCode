/*
 * Copyright 2006-2021 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hisun.kont.mx.msg.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;
import com.hisun.kont.mx.msg.pacs.Pacs00800110;
import com.hisun.kont.mx.util.MxWriteImpl;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Base class for specific MX messages.<br>
 * <p>
 * IMPORTANT: An MX message is conformed by a set of optional headers and a message payload or document with the actual
 * specific MX message. The name of the envelope element that binds a Header to the message to which it applies is
 * <b>implementation/network specific</b> and not part of the scope of this model.
 *
 * <p>This class provides the base container model for MX messages including an attribute for the header. Further it
 * supports both versions for the header; the SWIFT Application Header (legacy) and the ISO Business Application Header.
 *
 * <p>Serialization of this model into XML text can be done for the with or without the header portion. When the header
 * is set and included into the serialization, the container root element must be provided.
 *
 * @see AbstractMT
 * @since 7.6
 */
public abstract class AbstractMX extends AbstractMessage implements JsonSerializable {
    private static final transient Logger log = Logger.getLogger(AbstractMX.class.getName());

    BusinessApplicationHeaderV02 businessApplicationHeaderV02;

    public static final String DOCUMENT_LOCALNAME = "Document";

    /**
     * Default root element when an MX is serialized as XML including both AppHdr and Document
     *
     * @since 8.0.2
     */
    public static String DEFAULT_ROOT_ELEMENT = "RequestPayload";

    /**
     * Header portion of the message payload, common to all specific MX subclasses.
     * This information is required before opening the actual message to process the content properly.
     *
     * @since 7.7 original field using BusinessHeader class
     * @since 9.0.1 changed to interface AppHdr
     */


    protected AbstractMX() {
        super(MessageStandardType.MX);
        // prevent construction
    }

    protected AbstractMX(final BusinessApplicationHeaderV02 businessApplicationHeaderV02) {
        super(MessageStandardType.MX);
//        this.businessApplicationHeaderV02 = businessApplicationHeaderV02;
    }

    protected static <T> T fromJson(String json, Class<T> classOfT) {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(AbstractMX.class, new AbstractMXAdapter())
                .registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarAdapter())
                .registerTypeAdapter(AppHdr.class, new AppHdrAdapter())
                .create();
        return gson.fromJson(json, classOfT);
    }

    public BusinessApplicationHeaderV02 getBusinessApplicationHeaderV02() {
        return businessApplicationHeaderV02;
    }

    public void setBusinessApplicationHeaderV02(BusinessApplicationHeaderV02 businessApplicationHeaderV02) {
        this.businessApplicationHeaderV02 = businessApplicationHeaderV02;
    }

    @Override
    public String toJson() {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(AbstractMX.class, new AbstractMXAdapter())
                .registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarAdapter())
                .registerTypeAdapter(AppHdr.class, new AppHdrAdapter())
                .setPrettyPrinting()
                .create();
        // we use AbstractMX and not this.getClass() in order to force usage of the adapter
        return gson.toJson(this, AbstractMX.class);
    }

    public static AbstractMX fromJson(String json) {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(AbstractMX.class, new AbstractMXAdapter())
                .registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarAdapter())
                .registerTypeAdapter(AppHdr.class, new AppHdrAdapter())
                .create();
        return gson.fromJson(json, AbstractMX.class);
    }


    public abstract String getNamespace();

    /**
     * get the Alphabetic code in four positions (fixed length) identifying the Business Process
     *
     * @return the business process of the implementing class
     * @since 7.7
     */
    public abstract String getBusinessProcess();

    /**
     * Get the code identifying the Message Functionality
     *
     * @return the set functionality or null if not set
     * @since 7.7
     */
    public abstract int getFunctionality();

    /**
     * Get the Message variant
     *
     * @return the set variant or null if not set
     * @since 7.7
     */
    public abstract int getVariant();

    /**
     * Get the message version
     *
     * @return the set vesion or null if not set
     * @since 7.7
     */
    public abstract int getVersion();

    @Override
    public String message() {
        return message((MxWriteConfiguration) null);
    }
    /**
    *头部组装
    *
     */
    public String header(final String prefix, boolean includeXMLDeclaration, EscapeHandler escapeHandler) {
        if (this.businessApplicationHeaderV02 != null) {
            return this.businessApplicationHeaderV02.xml(prefix, includeXMLDeclaration, escapeHandler);
        } else {
            return null;
        }
    }

    public String message(MxWriteConfiguration conf) {
        MxWriteConfiguration usableConf = conf != null? conf : new MxWriteConfiguration();
        String root = usableConf.rootElement;
        StringBuilder xml = new StringBuilder();
        if (usableConf.includeXMLDeclaration) {
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        }
        final String header = header(usableConf.headerPrefix, false, usableConf.escapeHandler);
        if (header != null) {
            xml.append("<").append(root).append(">\n");
            xml.append(header).append("\n");
        }
        xml.append(document(usableConf.documentPrefix, false, usableConf.escapeHandler)).append("\n");
        if (header != null) {
            xml.append("</").append(root).append(">");
        }
        return xml.toString();
    }

    protected static String message(final String namespace, final Object obj, @SuppressWarnings("rawtypes") final Class[] classes, final String prefix, boolean includeXMLDeclaration, EscapeHandler escapeHandler) {
        return MxWriteImpl.write(namespace, obj, classes, prefix, includeXMLDeclaration, escapeHandler);
    }



    public String document(final String prefix, boolean includeXMLDeclaration, EscapeHandler escapeHandler) {
        return message(getNamespace(), this.getDocumentObj(), this.getClasses(), prefix, includeXMLDeclaration, escapeHandler);
    }


    @SuppressWarnings("rawtypes")
    public abstract Class[] getClasses();


    @SuppressWarnings("rawtypes")
    public abstract Object getDocumentObj();
}
