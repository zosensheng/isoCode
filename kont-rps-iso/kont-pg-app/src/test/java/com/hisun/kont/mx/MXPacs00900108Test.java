package com.hisun.kont.mx;

import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.pacs.MXPacs00900110;
import com.hisun.kont.mx.msg.pacs.Pacs00900110;
import com.hisun.kont.mx.util.AppHdrParser;
import com.hisun.kont.mx.util.MxParseUtils;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.Optional;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/28 15:23
 */
public class MXPacs00900108Test {

    @Test
    public void checkR1Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr02</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:23:41.960+00:00</CreDt>\n" +
                "        <Prty>NORM</Prty>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <PmtTpInf></PmtTpInf>\n" +
                "                <MsgId>BBBB/150928-FICT/JPY/430</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgtAcct></InstgRmbrsmntAgtAcct>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CCCCJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>DDDDLULL</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <DbtrAgtAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>24538877443</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAgtAcct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-FICT/JPY/430/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <UndrlygCstmrCdtTrf>\n" +
                "                    <IntrmyAgt1></IntrmyAgt1>\n" +
                "                    <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                    <IntrmyAgt2></IntrmyAgt2>\n" +
                "                    <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                    <IntrmyAgt3></IntrmyAgt3>\n" +
                "                    <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                    <InitgPty>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </InitgPty>\n" +
                "                    <Dbtr>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </Dbtr>\n" +
                "                    <DbtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </DbtrAgt>\n" +
                "                    <CdtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAGB2L</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </CdtrAgt>\n" +
                "                    <Cdtr>\n" +
                "                        <Nm>DEF Electronics</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Mark Lane</StrtNm>\n" +
                "                            <BldgNb>55</BldgNb>\n" +
                "                            <PstCd>EC3RZNE</PstCd>\n" +
                "                            <TwnNm>London</TwnNm>\n" +
                "                            <Ctry>GB</Ctry>\n" +
                "                            <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                    </Cdtr>\n" +
                "                    <CdtrAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29683707994815</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </CdtrAcct>\n" +
                "                    <RmtInf>\n" +
                "                        <Strd>\n" +
                "                            <RfrdDocInf>\n" +
                "                                <Tp>\n" +
                "                                    <CdOrPrtry>\n" +
                "                                        <Cd>CINV</Cd>\n" +
                "                                    </CdOrPrtry>\n" +
                "                                </Tp>\n" +
                "                                <Nb>4562</Nb>\n" +
                "                                <RltdDt>2015-09-08</RltdDt>\n" +
                "                            </RfrdDocInf>\n" +
                "                        </Strd>\n" +
                "                    </RmtInf>\n" +
                "                </UndrlygCstmrCdtTrf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R1报文检查测试========================>>>>" + mxPacs00900110.checkR1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR1Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr02</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:23:41.960+00:00</CreDt>\n" +
                "        <Prty>NORM</Prty>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <PmtTpInf></PmtTpInf>\n" +
                "                <MsgId>BBBB/150928-FICT/JPY/430</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgtAcct></InstgRmbrsmntAgtAcct>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CCCCJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>HIGH</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>DDDDLULL</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <DbtrAgtAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>24538877443</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAgtAcct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-FICT/JPY/430/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <UndrlygCstmrCdtTrf>\n" +
                "                    <IntrmyAgt1></IntrmyAgt1>\n" +
                "                    <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                    <IntrmyAgt2></IntrmyAgt2>\n" +
                "                    <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                    <IntrmyAgt3></IntrmyAgt3>\n" +
                "                    <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                    <InitgPty>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </InitgPty>\n" +
                "                    <Dbtr>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </Dbtr>\n" +
                "                    <DbtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </DbtrAgt>\n" +
                "                    <CdtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAGB2L</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </CdtrAgt>\n" +
                "                    <Cdtr>\n" +
                "                        <Nm>DEF Electronics</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Mark Lane</StrtNm>\n" +
                "                            <BldgNb>55</BldgNb>\n" +
                "                            <PstCd>EC3RZNE</PstCd>\n" +
                "                            <TwnNm>London</TwnNm>\n" +
                "                            <Ctry>GB</Ctry>\n" +
                "                            <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                    </Cdtr>\n" +
                "                    <CdtrAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29683707994815</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </CdtrAcct>\n" +
                "                    <RmtInf>\n" +
                "                        <Strd>\n" +
                "                            <RfrdDocInf>\n" +
                "                                <Tp>\n" +
                "                                    <CdOrPrtry>\n" +
                "                                        <Cd>CINV</Cd>\n" +
                "                                    </CdOrPrtry>\n" +
                "                                </Tp>\n" +
                "                                <Nb>4562</Nb>\n" +
                "                                <RltdDt>2015-09-08</RltdDt>\n" +
                "                            </RfrdDocInf>\n" +
                "                        </Strd>\n" +
                "                    </RmtInf>\n" +
                "                </UndrlygCstmrCdtTrf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R1报文检查测试========================>>>>" + mxPacs00900110.checkR1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR2Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BBBBUS33</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CCCCJPJT</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr02</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:23:41.960+00:00</CreDt>\n" +
                "        <Prty>NORM</Prty>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <PmtTpInf></PmtTpInf>\n" +
                "                <MsgId>BBBB/150928-FICT/JPY/430</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgtAcct></InstgRmbrsmntAgtAcct>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CCCCJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtTpInf>\n" +
                "                    <Prty>NORM</Prty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>DDDDLULL</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <DbtrAgtAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>24538877443</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAgtAcct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-FICT/JPY/430/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <UndrlygCstmrCdtTrf>\n" +
                "                    <IntrmyAgt1></IntrmyAgt1>\n" +
                "                    <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                    <IntrmyAgt2></IntrmyAgt2>\n" +
                "                    <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                    <IntrmyAgt3></IntrmyAgt3>\n" +
                "                    <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                    <InitgPty>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </InitgPty>\n" +
                "                    <Dbtr>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </Dbtr>\n" +
                "                    <DbtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </DbtrAgt>\n" +
                "                    <CdtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAGB2L</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </CdtrAgt>\n" +
                "                    <Cdtr>\n" +
                "                        <Nm>DEF Electronics</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Mark Lane</StrtNm>\n" +
                "                            <BldgNb>55</BldgNb>\n" +
                "                            <PstCd>EC3RZNE</PstCd>\n" +
                "                            <TwnNm>London</TwnNm>\n" +
                "                            <Ctry>GB</Ctry>\n" +
                "                            <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                    </Cdtr>\n" +
                "                    <CdtrAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29683707994815</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </CdtrAcct>\n" +
                "                    <RmtInf>\n" +
                "                        <Strd>\n" +
                "                            <RfrdDocInf>\n" +
                "                                <Tp>\n" +
                "                                    <CdOrPrtry>\n" +
                "                                        <Cd>CINV</Cd>\n" +
                "                                    </CdOrPrtry>\n" +
                "                                </Tp>\n" +
                "                                <Nb>4562</Nb>\n" +
                "                                <RltdDt>2015-09-08</RltdDt>\n" +
                "                            </RfrdDocInf>\n" +
                "                        </Strd>\n" +
                "                    </RmtInf>\n" +
                "                </UndrlygCstmrCdtTrf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R2报文检查测试========================>>>>" + mxPacs00900110.checkR2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR2Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BBBBUS32</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CCCCJPJT</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr02</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:23:41.960+00:00</CreDt>\n" +
                "        <Prty>NORM</Prty>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <PmtTpInf></PmtTpInf>\n" +
                "                <MsgId>BBBB/150928-FICT/JPY/430</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgtAcct></InstgRmbrsmntAgtAcct>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CCCCJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <PmtTpInf>\n" +
                "                    <Prty>NORM</Prty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>DDDDLULL</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <DbtrAgtAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>24538877443</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAgtAcct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-FICT/JPY/430/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <UndrlygCstmrCdtTrf>\n" +
                "                    <IntrmyAgt1></IntrmyAgt1>\n" +
                "                    <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                    <IntrmyAgt2></IntrmyAgt2>\n" +
                "                    <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                    <IntrmyAgt3></IntrmyAgt3>\n" +
                "                    <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                    <InitgPty>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </InitgPty>\n" +
                "                    <Dbtr>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </Dbtr>\n" +
                "                    <DbtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </DbtrAgt>\n" +
                "                    <CdtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAGB2L</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </CdtrAgt>\n" +
                "                    <Cdtr>\n" +
                "                        <Nm>DEF Electronics</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Mark Lane</StrtNm>\n" +
                "                            <BldgNb>55</BldgNb>\n" +
                "                            <PstCd>EC3RZNE</PstCd>\n" +
                "                            <TwnNm>London</TwnNm>\n" +
                "                            <Ctry>GB</Ctry>\n" +
                "                            <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                    </Cdtr>\n" +
                "                    <CdtrAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29683707994815</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </CdtrAcct>\n" +
                "                    <RmtInf>\n" +
                "                        <Strd>\n" +
                "                            <RfrdDocInf>\n" +
                "                                <Tp>\n" +
                "                                    <CdOrPrtry>\n" +
                "                                        <Cd>CINV</Cd>\n" +
                "                                    </CdOrPrtry>\n" +
                "                                </Tp>\n" +
                "                                <Nb>4562</Nb>\n" +
                "                                <RltdDt>2015-09-08</RltdDt>\n" +
                "                            </RfrdDocInf>\n" +
                "                        </Strd>\n" +
                "                    </RmtInf>\n" +
                "                </UndrlygCstmrCdtTrf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R2报文检查测试========================>>>>" + mxPacs00900110.checkR2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR3Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BBBBUS33</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CCCCJPJT</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr02</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:23:41.960+00:00</CreDt>\n" +
                "        <Prty>NORM</Prty>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <PmtTpInf></PmtTpInf>\n" +
                "                <MsgId>BBBB/150928-FICT/JPY/430</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgtAcct></InstgRmbrsmntAgtAcct>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CCCCJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <PmtTpInf>\n" +
                "                    <Prty>NORM</Prty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>DDDDLULL</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <DbtrAgtAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>24538877443</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAgtAcct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-FICT/JPY/430/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <UndrlygCstmrCdtTrf>\n" +
                "                    <IntrmyAgt1></IntrmyAgt1>\n" +
                "                    <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                    <IntrmyAgt2></IntrmyAgt2>\n" +
                "                    <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                    <IntrmyAgt3></IntrmyAgt3>\n" +
                "                    <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                    <InitgPty>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </InitgPty>\n" +
                "                    <Dbtr>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </Dbtr>\n" +
                "                    <DbtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </DbtrAgt>\n" +
                "                    <CdtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAGB2L</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </CdtrAgt>\n" +
                "                    <Cdtr>\n" +
                "                        <Nm>DEF Electronics</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Mark Lane</StrtNm>\n" +
                "                            <BldgNb>55</BldgNb>\n" +
                "                            <PstCd>EC3RZNE</PstCd>\n" +
                "                            <TwnNm>London</TwnNm>\n" +
                "                            <Ctry>GB</Ctry>\n" +
                "                            <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                    </Cdtr>\n" +
                "                    <CdtrAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29683707994815</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </CdtrAcct>\n" +
                "                    <RmtInf>\n" +
                "                        <Strd>\n" +
                "                            <RfrdDocInf>\n" +
                "                                <Tp>\n" +
                "                                    <CdOrPrtry>\n" +
                "                                        <Cd>CINV</Cd>\n" +
                "                                    </CdOrPrtry>\n" +
                "                                </Tp>\n" +
                "                                <Nb>4562</Nb>\n" +
                "                                <RltdDt>2015-09-08</RltdDt>\n" +
                "                            </RfrdDocInf>\n" +
                "                        </Strd>\n" +
                "                    </RmtInf>\n" +
                "                </UndrlygCstmrCdtTrf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R3报文检查测试========================>>>>" + mxPacs00900110.checkR3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR3Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BBBBUS32</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CCCCJPJT</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr02</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:23:41.960+00:00</CreDt>\n" +
                "        <Prty>NORM</Prty>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <PmtTpInf></PmtTpInf>\n" +
                "                <MsgId>BBBB/150928-FICT/JPY/430</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgtAcct></InstgRmbrsmntAgtAcct>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CCCCJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <PmtTpInf>\n" +
                "                    <Prty>NORM</Prty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>DDDDLULL</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <DbtrAgtAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>24538877443</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAgtAcct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-FICT/JPY/430/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAJPJT</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <UndrlygCstmrCdtTrf>\n" +
                "                    <IntrmyAgt1></IntrmyAgt1>\n" +
                "                    <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                    <IntrmyAgt2></IntrmyAgt2>\n" +
                "                    <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                    <IntrmyAgt3></IntrmyAgt3>\n" +
                "                    <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                    <InitgPty>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </InitgPty>\n" +
                "                    <Dbtr>\n" +
                "                        <Nm>ABC Corporation</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Times Square</StrtNm>\n" +
                "                            <BldgNb>7</BldgNb>\n" +
                "                            <PstCd>NY 10036</PstCd>\n" +
                "                            <TwnNm>New York</TwnNm>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                    </Dbtr>\n" +
                "                    <DbtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </DbtrAgt>\n" +
                "                    <CdtrAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAGB2L</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </CdtrAgt>\n" +
                "                    <Cdtr>\n" +
                "                        <Nm>DEF Electronics</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <StrtNm>Mark Lane</StrtNm>\n" +
                "                            <BldgNb>55</BldgNb>\n" +
                "                            <PstCd>EC3RZNE</PstCd>\n" +
                "                            <TwnNm>London</TwnNm>\n" +
                "                            <Ctry>GB</Ctry>\n" +
                "                            <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                    </Cdtr>\n" +
                "                    <CdtrAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29683707994815</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </CdtrAcct>\n" +
                "                    <RmtInf>\n" +
                "                        <Strd>\n" +
                "                            <RfrdDocInf>\n" +
                "                                <Tp>\n" +
                "                                    <CdOrPrtry>\n" +
                "                                        <Cd>CINV</Cd>\n" +
                "                                    </CdOrPrtry>\n" +
                "                                </Tp>\n" +
                "                                <Nb>4562</Nb>\n" +
                "                                <RltdDt>2015-09-08</RltdDt>\n" +
                "                            </RfrdDocInf>\n" +
                "                        </Strd>\n" +
                "                    </RmtInf>\n" +
                "                </UndrlygCstmrCdtTrf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R3报文检查测试========================>>>>" + mxPacs00900110.checkR3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR4Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R4报文检查测试========================>>>>" + mxPacs00900110.checkR4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR4Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R4报文检查测试========================>>>>" + mxPacs00900110.checkR4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR5Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R5报文检查测试========================>>>>" + mxPacs00900110.checkR5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR5Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr02</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R5报文检查测试========================>>>>" + mxPacs00900110.checkR5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR6Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R6报文检查测试========================>>>>" + mxPacs00900110.checkR6());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR6Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R6报文检查测试========================>>>>" + mxPacs00900110.checkR6());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR7Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R7报文检查测试========================>>>>" + mxPacs00900110.checkR7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR7Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.011.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R7报文检查测试========================>>>>" + mxPacs00900110.checkR7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR8Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R8报文检查测试========================>>>>" + mxPacs00900110.checkR8());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR8Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R8报文检查测试========================>>>>" + mxPacs00900110.checkR8());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR9Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R9报文检查测试========================>>>>" + mxPacs00900110.checkR9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR9Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R9报文检查测试========================>>>>" + mxPacs00900110.checkR9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR10Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R10报文检查测试========================>>>>" + mxPacs00900110.checkR10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR10Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXA</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R10报文检查测试========================>>>>" + mxPacs00900110.checkR10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR11Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R11报文检查测试========================>>>>" + mxPacs00900110.checkR11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR11Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>CHASUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R11报文检查测试========================>>>>" + mxPacs00900110.checkR11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR12Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R12报文检查测试========================>>>>" + mxPacs00900110.checkR12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR12Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R12报文检查测试========================>>>>" + mxPacs00900110.checkR12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR13Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R13报文检查测试========================>>>>" + mxPacs00900110.checkR13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR13Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>/pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R13报文检查测试========================>>>>" + mxPacs00900110.checkR13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR14Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R14报文检查测试========================>>>>" + mxPacs00900110.checkR14());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR14Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R14报文检查测试========================>>>>" + mxPacs00900110.checkR14());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR15Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R15报文检查测试========================>>>>" + mxPacs00900110.checkR15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR15Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>/pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R15报文检查测试========================>>>>" + mxPacs00900110.checkR15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR16Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R16报文检查测试========================>>>>" + mxPacs00900110.checkR16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR16Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R16报文检查测试========================>>>>" + mxPacs00900110.checkR16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR17Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R17报文检查测试========================>>>>" + mxPacs00900110.checkR17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR17Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R17报文检查测试========================>>>>" + mxPacs00900110.checkR17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR18Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R18报文检查测试========================>>>>" + mxPacs00900110.checkR18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR18Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R18报文检查测试========================>>>>" + mxPacs00900110.checkR18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR19Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R19报文检查测试========================>>>>" + mxPacs00900110.checkR19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR19Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R19报文检查测试========================>>>>" + mxPacs00900110.checkR19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR20Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R30报文检查测试========================>>>>" + mxPacs00900110.checkR20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR20Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"XAU\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R20报文检查测试========================>>>>" + mxPacs00900110.checkR20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR21Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR21Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR22Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR22Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR23Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR23Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR24Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR24Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR25Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR25Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR26Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R26报文检查测试========================>>>>" + mxPacs00900110.checkR26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR26Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R26报文检查测试========================>>>>" + mxPacs00900110.checkR26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR27Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R27报文检查测试========================>>>>" + mxPacs00900110.checkR27());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR27Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R27报文检查测试========================>>>>" + mxPacs00900110.checkR27());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR28Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R28报文检查测试========================>>>>" + mxPacs00900110.checkR28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR28Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R28报文检查测试========================>>>>" + mxPacs00900110.checkR28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR29Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R29报文检查测试========================>>>>" + mxPacs00900110.checkR29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR29Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R29报文检查测试========================>>>>" + mxPacs00900110.checkR29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR30Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R30报文检查测试========================>>>>" + mxPacs00900110.checkR30());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR30Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R30报文检查测试========================>>>>" + mxPacs00900110.checkR30());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR31Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R31报文检查测试========================>>>>" + mxPacs00900110.checkR31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR31Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R31报文检查测试========================>>>>" + mxPacs00900110.checkR31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR32Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R32报文检查测试========================>>>>" + mxPacs00900110.checkR32());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR32Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R32报文检查测试========================>>>>" + mxPacs00900110.checkR32());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR33Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R33报文检查测试========================>>>>" + mxPacs00900110.checkR33());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR33Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R33报文检查测试========================>>>>" + mxPacs00900110.checkR33());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR34Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R34报文检查测试========================>>>>" + mxPacs00900110.checkR34());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR34Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R34报文检查测试========================>>>>" + mxPacs00900110.checkR34());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR35Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R35报文检查测试========================>>>>" + mxPacs00900110.checkR35());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR35Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R35报文检查测试========================>>>>" + mxPacs00900110.checkR35());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR36Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R36报文检查测试========================>>>>" + mxPacs00900110.checkR36());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR36Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R36报文检查测试========================>>>>" + mxPacs00900110.checkR36());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR37Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R37报文检查测试========================>>>>" + mxPacs00900110.checkR37());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR37Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R37报文检查测试========================>>>>" + mxPacs00900110.checkR37());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR38Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R38报文检查测试========================>>>>" + mxPacs00900110.checkR38());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR38Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R38报文检查测试========================>>>>" + mxPacs00900110.checkR38());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR39Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R39报文检查测试========================>>>>" + mxPacs00900110.checkR39());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR39Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R39报文检查测试========================>>>>" + mxPacs00900110.checkR39());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR40Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R40报文检查测试========================>>>>" + mxPacs00900110.checkR40());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR40Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R40报文检查测试========================>>>>" + mxPacs00900110.checkR40());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR41Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R41报文检查测试========================>>>>" + mxPacs00900110.checkR41());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR41Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R41报文检查测试========================>>>>" + mxPacs00900110.checkR41());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR42Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R42报文检查测试========================>>>>" + mxPacs00900110.checkR42());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR42Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R42报文检查测试========================>>>>" + mxPacs00900110.checkR42());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR43Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R43报文检查测试========================>>>>" + mxPacs00900110.checkR43());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR43Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R43报文检查测试========================>>>>" + mxPacs00900110.checkR43());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR44Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R44报文检查测试========================>>>>" + mxPacs00900110.checkR44());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR44Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R44报文检查测试========================>>>>" + mxPacs00900110.checkR44());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR45Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R45报文检查测试========================>>>>" + mxPacs00900110.checkR45());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR45Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R45报文检查测试========================>>>>" + mxPacs00900110.checkR45());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR46Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R46报文检查测试========================>>>>" + mxPacs00900110.checkR46());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR46Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>Us</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R46报文检查测试========================>>>>" + mxPacs00900110.checkR46());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR47Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R47报文检查测试========================>>>>" + mxPacs00900110.checkR47());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR47Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R47报文检查测试========================>>>>" + mxPacs00900110.checkR47());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR48Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R48报文检查测试========================>>>>" + mxPacs00900110.checkR48());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR48Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R48报文检查测试========================>>>>" + mxPacs00900110.checkR48());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR49Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R49报文检查测试========================>>>>" + mxPacs00900110.checkR49());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR49Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R49报文检查测试========================>>>>" + mxPacs00900110.checkR49());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR50Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R50报文检查测试========================>>>>" + mxPacs00900110.checkR50());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR50Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R50报文检查测试========================>>>>" + mxPacs00900110.checkR50());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR51Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R51报文检查测试========================>>>>" + mxPacs00900110.checkR51());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR51Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R51报文检查测试========================>>>>" + mxPacs00900110.checkR51());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR52Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R52报文检查测试========================>>>>" + mxPacs00900110.checkR52());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR52Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R52报文检查测试========================>>>>" + mxPacs00900110.checkR52());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR53Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R53报文检查测试========================>>>>" + mxPacs00900110.checkR53());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR53Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R53报文检查测试========================>>>>" + mxPacs00900110.checkR53());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR54Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R54报文检查测试========================>>>>" + mxPacs00900110.checkR54());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR54Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R54报文检查测试========================>>>>" + mxPacs00900110.checkR54());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR55Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R55报文检查测试========================>>>>" + mxPacs00900110.checkR55());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR55Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R55报文检查测试========================>>>>" + mxPacs00900110.checkR55());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR56Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R56报文检查测试========================>>>>" + mxPacs00900110.checkR56());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR56Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrLine></AdrLine>\n" +
                "                            <Ctry>US</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R56报文检查测试========================>>>>" + mxPacs00900110.checkR56());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR57Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R57报文检查测试========================>>>>" + mxPacs00900110.checkR57());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR57Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>pacs9bizmsgidr01</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-08-03T10:13:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08\">\n" +
                "        <FICdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>pacs9bizmsgidr01</MsgId>\n" +
                "                <CreDtTm>2020-08-03T10:13:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\"></TtlIntrBkSttlmAmt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <IntrmyAgt2>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt2>\n" +
                "                <IntrmyAgt3>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt3>\n" +
                "                <Dbtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>RBOSGB2LXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>HELSFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                            <TwnNm>BJ</TwnNm>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EVSEFIHHXXX</BICFI>\n" +
                "                        <PstlAdr>\n" +
                "                            <Ctry>AF</Ctry>\n" +
                "                        </PstlAdr>\n" +
                "                        <Nm>LSH</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Cdtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>pacs9bizmsgidr01</InstrId>\n" +
                "                    <EndToEndId>pacs009EndToEndId-001</EndToEndId>\n" +
                "                    <UETR>dab3b64f-092b-4839-b7e9-8f438af50961</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">654489.98</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-08-03</IntrBkSttlmDt>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ABNANL2AXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>NDEAFIHHXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Invoice: 456464-9663</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FICdtTrf>\n" +
                "    </Document>\n" +
                "</Envelope>";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R57报文检查测试========================>>>>" + mxPacs00900110.checkR57());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR58Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R58报文检查测试========================>>>>" + mxPacs00900110.checkR58());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR58Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R58报文检查测试========================>>>>" + mxPacs00900110.checkR58());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR59Success() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R59报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkR59Error() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R59报文检查测试========================>>>>" + mxPacs00900110.checkR59());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }


    @Test
    public void checkRSuccess() {
        String reqXml = "";

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkRError() {
        String reqXml = "";


        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        // 检查报文数据是否符合规范
        //String checkStpAll = appHdr1.checkStpAll();
        //System.out.println(checkStpAll);

        // 获取报文头数据
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00900110.class, MXPacs00900110._classes);
        Pacs00900110 pacs00900110 = (Pacs00900110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00900110 mxPacs00900110 = new MXPacs00900110();
        mxPacs00900110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00900110.setPacs00900110(pacs00900110);

        long begin = System.currentTimeMillis();
        System.out.println("R报文检查测试========================>>>>" + mxPacs00900110.checkR());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }


    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx = MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }


}
