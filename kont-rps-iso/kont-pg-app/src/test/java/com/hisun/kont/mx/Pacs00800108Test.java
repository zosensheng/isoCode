package com.hisun.kont.mx;

import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.MXPacs00800108;
import com.hisun.kont.mx.msg.pacs.MXPacs00900110;
import com.hisun.kont.mx.msg.pacs.Pacs00800108;
import com.hisun.kont.mx.msg.pacs.Pacs00900110;
import com.hisun.kont.mx.util.MxParseUtils;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.Optional;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/8/9 14:44
 */
public class Pacs00800108Test {

    @Test
    public void checkC1Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C1报文检查测试========================>>>>" + pacs00800108.checkC1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC1Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C1报文检查测试========================>>>>" + pacs00800108.checkC1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC2Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C2报文检查测试========================>>>>" + pacs00800108.checkC2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC2Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C报文检查测试========================>>>>" + pacs00800108.checkC2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC3Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C3报文检查测试========================>>>>" + pacs00800108.checkC3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC3Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C3报文检查测试========================>>>>" + pacs00800108.checkC3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC4Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C4报文检查测试========================>>>>" + pacs00800108.checkC4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC4Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C4报文检查测试========================>>>>" + pacs00800108.checkC4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC5Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C5报文检查测试========================>>>>" + pacs00800108.checkC5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC5Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C5报文检查测试========================>>>>" + pacs00800108.checkC5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC7Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C7报文检查测试========================>>>>" + pacs00800108.checkC7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC7Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C7报文检查测试========================>>>>" + pacs00800108.checkC7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC9Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C9报文检查测试========================>>>>" + pacs00800108.checkC9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC9Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C9报文检查测试========================>>>>" + pacs00800108.checkC9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC10Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C10报文检查测试========================>>>>" + pacs00800108.checkC10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC10Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C10报文检查测试========================>>>>" + pacs00800108.checkC10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC11Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C11报文检查测试========================>>>>" + pacs00800108.checkC11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC11Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C11报文检查测试========================>>>>" + pacs00800108.checkC11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC12Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C12报文检查测试========================>>>>" + pacs00800108.checkC12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC12Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C12报文检查测试========================>>>>" + pacs00800108.checkC12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC13Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C13报文检查测试========================>>>>" + pacs00800108.checkC13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC13Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C13报文检查测试========================>>>>" + pacs00800108.checkC13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC14Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C14报文检查测试========================>>>>" + pacs00800108.checkC14());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC14Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C14报文检查测试========================>>>>" + pacs00800108.checkC14());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC15Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C15报文检查测试========================>>>>" + pacs00800108.checkC15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC15Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C15报文检查测试========================>>>>" + pacs00800108.checkC15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC16Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C16报文检查测试========================>>>>" + pacs00800108.checkC16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC16Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C16报文检查测试========================>>>>" + pacs00800108.checkC16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC17Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C17报文检查测试========================>>>>" + pacs00800108.checkC17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC17Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C17报文检查测试========================>>>>" + pacs00800108.checkC17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC18Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C18报文检查测试========================>>>>" + pacs00800108.checkC18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC18Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C18报文检查测试========================>>>>" + pacs00800108.checkC18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC19Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C19报文检查测试========================>>>>" + pacs00800108.checkC19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC19Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C19报文检查测试========================>>>>" + pacs00800108.checkC19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC20Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C20报文检查测试========================>>>>" + pacs00800108.checkC20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC20Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C20报文检查测试========================>>>>" + pacs00800108.checkC20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC21Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C21报文检查测试========================>>>>" + pacs00800108.checkC21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC21Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C21报文检查测试========================>>>>" + pacs00800108.checkC21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC22Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C22报文检查测试========================>>>>" + pacs00800108.checkC22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC22Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C22报文检查测试========================>>>>" + pacs00800108.checkC22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC23Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C23报文检查测试========================>>>>" + pacs00800108.checkC23());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC23Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C23报文检查测试========================>>>>" + pacs00800108.checkC23());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC24Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C24报文检查测试========================>>>>" + pacs00800108.checkC24());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC24Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C24报文检查测试========================>>>>" + pacs00800108.checkC24());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC25Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C25报文检查测试========================>>>>" + pacs00800108.checkC25());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC25Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C25报文检查测试========================>>>>" + pacs00800108.checkC25());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC26Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C26报文检查测试========================>>>>" + pacs00800108.checkC26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC26Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C26报文检查测试========================>>>>" + pacs00800108.checkC26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC27Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C报文检查测试========================>>>>" + pacs00800108.checkC());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC27Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C27报文检查测试========================>>>>" + pacs00800108.checkC27());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC28Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C28报文检查测试========================>>>>" + pacs00800108.checkC28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC28Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C28报文检查测试========================>>>>" + pacs00800108.checkC28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC29Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C29报文检查测试========================>>>>" + pacs00800108.checkC29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC29Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C29报文检查测试========================>>>>" + pacs00800108.checkC29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC31Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C31报文检查测试========================>>>>" + pacs00800108.checkC31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC31Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C31报文检查测试========================>>>>" + pacs00800108.checkC31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC32Success() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C32报文检查测试========================>>>>" + pacs00800108.checkC32());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC32Error() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C报文检查测试========================>>>>" + pacs00800108.checkC());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkCSuccess() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C报文检查测试========================>>>>" + pacs00800108.checkC());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkCError() {
        String reqXml = "";

        //报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800108.class, MXPacs00800108._classes);
        Pacs00800108 pacs00800108 = (Pacs00800108) mx.get();

        long begin = System.currentTimeMillis();
        System.out.println("C报文检查测试========================>>>>" + pacs00800108.checkC());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx = MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }
}
