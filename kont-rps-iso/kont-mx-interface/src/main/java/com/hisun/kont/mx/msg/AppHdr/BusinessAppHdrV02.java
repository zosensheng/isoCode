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
package com.hisun.kont.mx.msg.AppHdr;

import com.hisun.kont.mx.msg.AppHdr.BusinessApplicationHeaderV02Impl;
import com.hisun.kont.mx.msg.javabean.head00100102.Party44Choice;
import com.hisun.kont.mx.msg.model.AppHdr;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.transform.dom.DOMResult;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ISO 20022 business application header version 2 usually known by its namespace head.001.001.02
 *
 * @since 9.0.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppHdr")
@XmlRootElement(name = "AppHdr",  namespace = "urn:iso:std:iso:20022:tech:xsd:head.001.001.02")
public class BusinessAppHdrV02 extends BusinessApplicationHeaderV02Impl implements AppHdr {
    public static final transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:head.001.001.02";
    final static transient Class[] _classes;
    private static final transient Logger log = Logger.getLogger(BusinessAppHdrV02.class.getName());

    static {
        _classes = Arrays.copyOf(BusinessApplicationHeaderV02Impl._classes, BusinessApplicationHeaderV02Impl._classes.length + 1);
        _classes[_classes.length - 1] = BusinessAppHdrV02.class;
    }

    /**
     * Get the classes associated with this message
     */
    @SuppressWarnings("rawtypes")
    Class[] getClasses() {
        return _classes;
    }

    /**
     * Gets the sender BIC code from these elements in the following order:
     * <ol>
     * 	<li>BusinessApplicationHeaderV01/Fr/FIId/FinInstnId/BICFI</li>
     *  <li>BusinessApplicationHeaderV01/Fr/OrgId/Id/OrgId/Id/AnyBIC</li>
     * </ol>
     *
     * @return found BIC or null if not present or cannot be parsed
     */
    @Override
    public String from() {
        return getBIC(this.getFr());
    }

    /**
     * Gets the receiver BIC code from these elements in the following order:
     * <ol>
     * 	<li>BusinessApplicationHeaderV02/To/FIId/FinInstnId/BICFI</li>
     *  <li>BusinessApplicationHeaderV02/To/OrgId/Id/OrgId/Id/AnyBIC</li>
     * </ol>
     *
     * @return found BIC or null if not present or cannot be parsed
     */
    @Override
    public String to() {
        return getBIC(this.getTo());
    }

    private String getBIC(final Party44Choice p) {
        try {
            final String found = p.getFIId().getFinInstnId().getBICFI();
            if (!StringUtils.isEmpty(found)) {
                return found;
            }
        } catch (NullPointerException e) {
            try {
                final String found = p.getOrgId().getId().getOrgId().getAnyBIC();
                if (!StringUtils.isEmpty(found)) {
                    return found;
                }
            } catch (NullPointerException e2) {
                return null;
            }
        }
        return null;
    }

    /**
     * Get the message reference.
     *
     * @see #getBizMsgIdr()
     */
    @Override
    public String reference() {
        return this.getBizMsgIdr();
    }

    /**
     * Gets the message name.
     *
     * @see #getMsgDefIdr()
     */
    @Override
    public String messageName() {
        return this.getMsgDefIdr();
    }

    /**
     * Gets the service name.
     *
     * @see #getBizSvc()
     */
    @Override
    public String serviceName() {
        return this.getBizSvc();
    }

    /**
     * @return true if the CpyDplct element is present, false otherwise
     * @see #getCpyDplct()
     */
    @Override
    public boolean duplicate() {
        return (this.isPssblDplct() != null && this.isPssblDplct()) || this.getCpyDplct() != null;
    }

    /**
     * Gets the creation date
     *
     * @see #getCreDt()
     */
    @Override
    public XMLGregorianCalendar creationDate() {
        return this.getCreDt();
    }

    @Override
    public void setCreationDate(boolean overwrite) {

    }

    public String xml(String prefix, boolean includeXMLDeclaration) {
        return null;
    }

    @Override
    public Element element() {
        return null;
    }


    /**
     * @return NAMESPACE
     * @since 9.1.7
     */
    @Override
    public String namespace() {
        return NAMESPACE;
    }

    @Override
    public String checkAll() {
        return null;
    }
}
