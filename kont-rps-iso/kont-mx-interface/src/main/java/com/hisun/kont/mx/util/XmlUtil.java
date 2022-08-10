//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.hisun.kont.mx.util;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

public class XmlUtil {


    public static void validteXsd(InputStream xsdStream, InputStream xmlStream) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Source xsdSource = new StreamSource(xsdStream);
        Schema schema = schemaFactory.newSchema(xsdSource);
        Source xmlSource = new StreamSource(xmlStream);
        Validator validator = schema.newValidator();
        validator.validate(xmlSource);
    }

    public static void validteXsd(String xml, String xsd) throws SAXException, IOException {
//        InputStream xsdStream = null;
//        FileInputStream xmlStream = null;
        InputStream  xsdStream =null;
        InputStream   xmlStream = null;
        try {
              xsdStream = IOUtils.toInputStream(
                    new String(xml));
               xmlStream = IOUtils.toInputStream(
                    new String(xml));

//            xsdStream = new FileInputStream(xsd);
//            xmlStream = new FileInputStream(xml);
            validteXsd((InputStream)xsdStream, (InputStream)xmlStream);
        } finally {
            IOUtil.close(new Closeable[]{xsdStream, xmlStream});
        }

    }

    public static void main(String[] args) throws IOException, SAXException {
        String xml = Lib.readResource("pacs.008.001.07.xml");
        String xsd = Lib.readResource("pacs.008.001.10.xsd");

//        FileInputStream fileInputStream = new FileInputStream(xml);

        validteXsd(xml, xsd);
        System.out.println("complete.");
    }
}
