//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.hisun.kont.mx.util;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil {

    public static void close(Closeable... closes) throws IOException {
        IOException ioException = null;
        Closeable[] var2 = closes;
        int var3 = closes.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Closeable close = var2[var4];

            try {
                if (close != null) {
                    close.close();
                }
            } catch (IOException var7) {
                if (ioException != null) {
                    ioException.initCause(var7);
                }

                ioException = var7;
            }
        }

        if (ioException != null) {
            throw ioException;
        }
    }



    public static void validteXsd(InputStream xsdStream, InputStream xmlStream) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Source xsdSource = new StreamSource(xsdStream);
        Schema schema = schemaFactory.newSchema(xsdSource);
        Source xmlSource = new StreamSource(xmlStream);
        Validator validator = schema.newValidator();
        validator.validate(xmlSource);
    }
}
