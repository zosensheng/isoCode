package com.hisun.kont.mx.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * @author lyz
 *
 */
public class XmlValidate {

    /**
     * @param isXml
     * @param isXsd
     * @return
     * @throws SAXException
     * @throws IOException
     */
    public static boolean validate(InputStream isXml, InputStream isXsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Source xsd = new StreamSource(isXsd);
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(isXml));
            flag = true;

        } catch (SAXException e) {
            flag = false;
            throw new SAXException(e.getMessage());

        } catch (IOException e) {
            flag = false;
            throw new IOException(e.getMessage());
        } finally {
            if (isXml != null) {
                isXml.close();
                isXml = null;
            }
            if (isXsd != null) {
                isXsd.close();
                isXsd = null;
            }
        }
        return flag;
    }

    /**
     * @param isXml
     * @param isXsd
     * @return
     * @throws SAXException
     * @throws IOException
     */
    public static boolean validate(InputStream isXml, File isXsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Source xsd = new StreamSource(isXsd);
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(isXml));
            flag = true;

        } catch (SAXException e) {
            e.printStackTrace();
            flag = false;
            throw new SAXException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            throw new IOException(e.getMessage());
        } finally {
            if (isXml != null) {
                isXml.close();
                isXml = null;
            }
        }
        return flag;
    }

    /**
     * @param isXml
     * @param xsd
     * @return
     * @throws SAXException
     * @throws IOException
     */
    public static boolean validate(InputStream isXml, URL xsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(isXml));
            flag = true;

        } catch (SAXException e) {
            e.printStackTrace();
            flag = false;
            throw new SAXException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            throw new IOException(e.getMessage());
        } finally {
            if (isXml != null) {
                isXml.close();
                isXml = null;
            }
        }
        return flag;
    }

    /**
     * @param xml
     * @param xsd
     * @return
     * @throws SAXException
     * @throws IOException
     */
    public static boolean validate(File xml, File xsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            flag = true;
        } catch (SAXException e) {
            e.printStackTrace();
            flag = false;
            throw new SAXException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            throw new IOException(e.getMessage());
        }
        return flag;
    }


//	public static void main(String[] args)
//			throws JAXBException, DocumentException, UnsupportedEncodingException, IOException {
//		boolean isPassed = false;
//		FileInputStream xml = new FileInputStream("C:\\Users\\14435\\Desktop\\ccms.903.001.02.xml");
//		FileInputStream xsd = new FileInputStream("C:\\Users\\14435\\Desktop\\ccms.903.001.02.xsd");
//		try {
//			isPassed = validate(xml, xsd);
//		} catch (SAXException e) {
//
//		}
//		if (isPassed) {
//			System.out.println("通过");
//		} else {
//			System.out.println("没有通过");
//		}
//	}

}