package com.hisun.kont.mx;

import com.hisun.kont.mx.enums.BusAppHeadToBusSerEnum;
import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.pacs.MXPacs00800110;
import com.hisun.kont.mx.msg.pacs.Pacs00800110;
import com.hisun.kont.mx.util.AppHdrParser;
import com.hisun.kont.mx.util.MxParseUtils;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.Optional;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/11 16:44
 */
public class MXPacs00800108FTPTest {

    @Test
    public void checkStpR1Success() {
        String reqXml = "<message>\n" +
                "    <AppHdr\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
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
                "                    <BICFI>AAAAGB2L</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "        <InstrPrty>NORM</InstrPrty>\n\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CCT/JPY/123</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>COVE</SttlmMtd>\n" +
                "                    <InstgRmbrsmntAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CCCCJPJT</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAJPJT</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </InstdRmbrsmntAgt>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <Prty>NORM</Prty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>ABC Corporation</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Times Square</StrtNm>\n" +
                "                        <BldgNb>7</BldgNb>\n" +
                "                        <PstCd>NY 10036</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125574999</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>DEF Electronics</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Mark Lane</StrtNm>\n" +
                "                        <BldgNb>55</BldgNb>\n" +
                "                        <PstCd>EC3R7NE</PstCd>\n" +
                "                        <TwnNm>London</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>23683707994215</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <Purp>\n" +
                "                    <Cd>GDDS</Cd>\n" +
                "                </Purp>\n" +
                "                <RmtInf>\n" +
                "                    <Strd>\n" +
                "                        <RfrdDocInf>\n" +
                "                            <Tp>\n" +
                "                                <CdOrPrtry>\n" +
                "                                    <Cd>CINV</Cd>\n" +
                "                                </CdOrPrtry>\n" +
                "                            </Tp>\n" +
                "                            <Nb>4562</Nb>\n" +
                "                            <RltdDt>2015-09-08</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R1报文检查测试========================>>>>" + mxPacs00800110.checkStpR1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR1Error() {
        String reqXml = "<message>\n" +
                "    <AppHdr\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
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
                "                    <BICFI>AAAAGB2L</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "        <Prty>NORM</Prty>\n\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CCT/JPY/123</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>COVE</SttlmMtd>\n" +
                "                    <InstgRmbrsmntAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CCCCJPJT</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>AAAAJPJT</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </InstdRmbrsmntAgt>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>HIGH</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">10000000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>ABC Corporation</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Times Square</StrtNm>\n" +
                "                        <BldgNb>7</BldgNb>\n" +
                "                        <PstCd>NY 10036</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125574999</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>DEF Electronics</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Mark Lane</StrtNm>\n" +
                "                        <BldgNb>55</BldgNb>\n" +
                "                        <PstCd>EC3R7NE</PstCd>\n" +
                "                        <TwnNm>London</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine>Corn Exchange 5th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>23683707994215</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <Purp>\n" +
                "                    <Cd>GDDS</Cd>\n" +
                "                </Purp>\n" +
                "                <RmtInf>\n" +
                "                    <Strd>\n" +
                "                        <RfrdDocInf>\n" +
                "                            <Tp>\n" +
                "                                <CdOrPrtry>\n" +
                "                                    <Cd>CINV</Cd>\n" +
                "                                </CdOrPrtry>\n" +
                "                            </Tp>\n" +
                "                            <Nb>4562</Nb>\n" +
                "                            <RltdDt>2015-09-08</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R1报文检查测试========================>>>>" + mxPacs00800110.checkStpR1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR2Success() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R2报文检查测试========================>>>>" + mxPacs00800110.checkStpR2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR2Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB1LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R2报文检查测试========================>>>>" + mxPacs00800110.checkStpR2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR3Success() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R3报文检查测试========================>>>>" + mxPacs00800110.checkStpR3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR3Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB1LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R3报文检查测试========================>>>>" + mxPacs00800110.checkStpR3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR4Success() {
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R4报文检查测试========================>>>>" + mxPacs00800110.checkStpR4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR4Error() {
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R4报文检查测试========================>>>>" + mxPacs00800110.checkStpR4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR5Success() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R5报文检查测试========================>>>>" + mxPacs00800110.checkStpR5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR5Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272709</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R5报文检查测试========================>>>>" + mxPacs00800110.checkStpR5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR6Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R6报文检查测试========================>>>>" + mxPacs00800110.checkStpR6());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR6Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.01.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.09\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R6报文检查测试========================>>>>" + mxPacs00800110.checkStpR6());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR7Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R7报文检查测试========================>>>>" + mxPacs00800110.checkStpR7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR7Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.009.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R7报文检查测试========================>>>>" + mxPacs00800110.checkStpR7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR8Success() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R8报文检查测试========================>>>>" + mxPacs00800110.checkStpR8());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR8Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.01</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R8报文检查测试========================>>>>" + mxPacs00800110.checkStpR8());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR9Success() {
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R9报文检查测试========================>>>>" + mxPacs00800110.checkStpR9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR9Error() {
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R9报文检查测试========================>>>>" + mxPacs00800110.checkStpR9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR10Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
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
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R10报文检查测试========================>>>>" + mxPacs00800110.checkStpR10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR10Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
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
                "                    <BICFI>CHASGB2LXX</BICFI>\n" +
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
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R10报文检查测试========================>>>>" + mxPacs00800110.checkStpR10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR11Success() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "            <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R11报文检查测试========================>>>>" + mxPacs00800110.checkStpR11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR11Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R11报文检查测试========================>>>>" + mxPacs00800110.checkStpR11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR12Success() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R12报文检查测试========================>>>>" + mxPacs00800110.checkStpR12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR12Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R12报文检查测试========================>>>>" + mxPacs00800110.checkStpR12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR13Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
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
                "            <Fr>\n" +
                "                <FIId>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </FIId>\n" +
                "            </Fr>\n" +
                "            <To>\n" +
                "                <FIId>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </FIId>\n" +
                "            </To>\n" +
                "            <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "            <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "            <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "            <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "            <CpyDplct>DUPL</CpyDplct>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf></ChrgsInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R13报文检查测试========================>>>>" + mxPacs00800110.checkStpR13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR13Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
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
                "            <Fr>\n" +
                "                <FIId>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </FIId>\n" +
                "            </Fr>\n" +
                "            <To>\n" +
                "                <FIId>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </FIId>\n" +
                "            </To>\n" +
                "            <BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "            <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "            <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "            <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "            <CpyDplct>DUPL</CpyDplct>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R13报文检查测试========================>>>>" + mxPacs00800110.checkStpR13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR14Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASES2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTES31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R14报文检查测试========================>>>>" + mxPacs00800110.checkStpR14());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR14Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASES2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTAD31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R14报文检查测试========================>>>>" + mxPacs00800110.checkStpR14());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR15Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASFR2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTMC31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R15报文检查测试========================>>>>" + mxPacs00800110.checkStpR15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR15Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASFR2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTMC31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R15报文检查测试========================>>>>" + mxPacs00800110.checkStpR15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR16Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASIT2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTSM31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R16报文检查测试========================>>>>" + mxPacs00800110.checkStpR16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR16Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASIT2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTSM31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R16报文检查测试========================>>>>" + mxPacs00800110.checkStpR16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR17Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASIT2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTVA31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R17报文检查测试========================>>>>" + mxPacs00800110.checkStpR17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR17Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASIT2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTVA31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R17报文检查测试========================>>>>" + mxPacs00800110.checkStpR17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR18Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASAT2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTBE31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R18报文检查测试========================>>>>" + mxPacs00800110.checkStpR18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR18Error() {
        String reqXml = "<Envelope\n" +
                "    xmlns=\"urn:swift:xsd:envelope\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
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
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "        <CpyDplct>DUPL</CpyDplct>\n" +
                "        <Rltd>\n" +
                "            <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        </Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>A2B0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <RltdRmtInf></RltdRmtInf>\n" +
                "                <RmtInf></RmtInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>A2B0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <IntrmyAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </IntrmyAgt1>\n" +
                "                <Dbtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>ES</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASAT2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTBE31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R18报文检查测试========================>>>>" + mxPacs00800110.checkStpR18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR19Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R19报文检查测试========================>>>>" + mxPacs00800110.checkStpR19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR19Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R19报文检查测试========================>>>>" + mxPacs00800110.checkStpR19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR20Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R20报文检查测试========================>>>>" + mxPacs00800110.checkStpR20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR20Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>/B2C0506272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R20报文检查测试========================>>>>" + mxPacs00800110.checkStpR20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR21Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R21报文检查测试========================>>>>" + mxPacs00800110.checkStpR21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR21Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"XAU\">39980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R21报文检查测试========================>>>>" + mxPacs00800110.checkStpR21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR22Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">49980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R22报文检查测试========================>>>>" + mxPacs00800110.checkStpR22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR22Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"USD\">49980</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R22报文检查测试========================>>>>" + mxPacs00800110.checkStpR22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR23Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">90000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "\t\t\t\t<XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R23报文检查测试========================>>>>" + mxPacs00800110.checkStpR23());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR23Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">90000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                 <XchgRate>0.5</XchgRate>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R23报文检查测试========================>>>>" + mxPacs00800110.checkStpR23());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR24Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "               <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R24报文检查测试========================>>>>" + mxPacs00800110.checkStpR24());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR24Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "               <XchgRate>0.5</XchgRate>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R24报文检查测试========================>>>>" + mxPacs00800110.checkStpR24());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR25Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R25报文检查测试========================>>>>" + mxPacs00800110.checkStpR25());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR25Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R25报文检查测试========================>>>>" + mxPacs00800110.checkStpR25());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR26Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R26报文检查测试========================>>>>" + mxPacs00800110.checkStpR26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR26Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R26报文检查测试========================>>>>" + mxPacs00800110.checkStpR26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR27Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R27报文检查测试========================>>>>" + mxPacs00800110.checkStpR27());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR27Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R27报文检查测试========================>>>>" + mxPacs00800110.checkStpR27());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR28Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R28报文检查测试========================>>>>" + mxPacs00800110.checkStpR28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR28Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R28报文检查测试========================>>>>" + mxPacs00800110.checkStpR28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR29Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <InitgPty>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </InitgPty>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R29报文检查测试========================>>>>" + mxPacs00800110.checkStpR29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR29Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <InitgPty>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </InitgPty>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R29报文检查测试========================>>>>" + mxPacs00800110.checkStpR29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR30Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "\t\t<Rltd>\n" +
                "\t\t        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "\t\t</Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R30报文检查测试========================>>>>" + mxPacs00800110.checkStpR30());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR30Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2026-01-11T12:50:41.960-05:00</CreDt>\n" +
                "\t\t<Rltd>\n" +
                "\t\t        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.stp.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "\t\t</Rltd>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R30报文检查测试========================>>>>" + mxPacs00800110.checkStpR30());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR31Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                           <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R31报文检查测试========================>>>>" + mxPacs00800110.checkStpR31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR31Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs></NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                           <AnyBIC></AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R31报文检查测试========================>>>>" + mxPacs00800110.checkStpR31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR32Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "\t\t\t\t\t<Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId><Othr></Othr></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R32报文检查测试========================>>>>" + mxPacs00800110.checkStpR32());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR32Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId><Othr></Othr></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R32报文检查测试========================>>>>" + mxPacs00800110.checkStpR32());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR33Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R33报文检查测试========================>>>>" + mxPacs00800110.checkStpR33());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR33Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R33报文检查测试========================>>>>" + mxPacs00800110.checkStpR33());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR34Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                       <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId><Othr></Othr></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R34报文检查测试========================>>>>" + mxPacs00800110.checkStpR34());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR34Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                  <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId><Othr></Othr></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R34报文检查测试========================>>>>" + mxPacs00800110.checkStpR34());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR35Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R35报文检查测试========================>>>>" + mxPacs00800110.checkStpR35());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR35Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R35报文检查测试========================>>>>" + mxPacs00800110.checkStpR35());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR36Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R36报文检查测试========================>>>>" + mxPacs00800110.checkStpR36());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR36Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R36报文检查测试========================>>>>" + mxPacs00800110.checkStpR36());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR37Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +

                "                   <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R37报文检查测试========================>>>>" + mxPacs00800110.checkStpR37());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR37Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                       <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R37报文检查测试========================>>>>" + mxPacs00800110.checkStpR37());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR38Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R38报文检查测试========================>>>>" + mxPacs00800110.checkStpR38());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR38Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R38报文检查测试========================>>>>" + mxPacs00800110.checkStpR38());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR39Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R39报文检查测试========================>>>>" + mxPacs00800110.checkStpR39());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR39Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R30报文检查测试========================>>>>" + mxPacs00800110.checkStpR39());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR40Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R40报文检查测试========================>>>>" + mxPacs00800110.checkStpR40());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR40Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R40报文检查测试========================>>>>" + mxPacs00800110.checkStpR40());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR41Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R41报文检查测试========================>>>>" + mxPacs00800110.checkStpR41());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR41Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R41报文检查测试========================>>>>" + mxPacs00800110.checkStpR41());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR42Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R42报文检查测试========================>>>>" + mxPacs00800110.checkStpR42());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR42Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R42报文检查测试========================>>>>" + mxPacs00800110.checkStpR42());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR43Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R43报文检查测试========================>>>>" + mxPacs00800110.checkStpR43());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR43Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R43报文检查测试========================>>>>" + mxPacs00800110.checkStpR43());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR44Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R44报文检查测试========================>>>>" + mxPacs00800110.checkStpR44());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR44Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R44报文检查测试========================>>>>" + mxPacs00800110.checkStpR44());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR45Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R45报文检查测试========================>>>>" + mxPacs00800110.checkStpR45());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR45Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R45报文检查测试========================>>>>" + mxPacs00800110.checkStpR45());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR46Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R46报文检查测试========================>>>>" + mxPacs00800110.checkStpR46());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR46Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R46报文检查测试========================>>>>" + mxPacs00800110.checkStpR46());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR47Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R47报文检查测试========================>>>>" + mxPacs00800110.checkStpR47());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR47Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R47报文检查测试========================>>>>" + mxPacs00800110.checkStpR47());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR48Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R48报文检查测试========================>>>>" + mxPacs00800110.checkStpR48());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR48Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>LV</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R48报文检查测试========================>>>>" + mxPacs00800110.checkStpR48());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR49Success() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R49报文检查测试========================>>>>" + mxPacs00800110.checkStpR49());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpR49Error() {
        String reqXml = "<?xml version=\"1.0\"?>\n" +
                "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">\n" +
                "    <AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>C2D0506272708</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "        <BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "        <CreDt>2020-01-11T12:50:41.960-05:00</CreDt>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>B2C0506272708</MsgId>\n" +
                "                <CreDtTm>2020-01-11T12:50:41.960-05:00</CreDtTm>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <UltmtCdtr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtCdtr>\n" +
                "                <UltmtDbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId></OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </UltmtDbtr>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>B2C050//6272708</InstrId>\n" +
                "                    <EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "                    <UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">80000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "                <InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "                <ChrgBr>DEBT</ChrgBr>\n" +
                "                <XchgRate>0.5</XchgRate>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"USD\">10</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CHASUS33XXX</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
                "                <PrvsInstgAgt1>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </PrvsInstgAgt1>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>FTSBUS33XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>NOKIA CORPORATION</Nm>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "                        <PstCd>RG74SA</PstCd>\n" +
                "                        <TwnNm>THEALE</TwnNm>\n" +
                "                        <Ctry>GB</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CHASGB2LXXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BAUTUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ATnT</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>208 ARAKD ST</StrtNm>\n" +
                "                        <PstCd>1096</PstCd>\n" +
                "                        <TwnNm>DALLAS</TwnNm>\n" +
                "                        <TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                        <AdrLine></AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                    <Id>\n" +
                "                        <PrvtId></PrvtId>\n" +
                "                        <OrgId>\n" +
                "                            <AnyBIC>1</AnyBIC>\n" +
                "                            <Othr></Othr>\n" +
                "                        </OrgId>\n" +
                "                    </Id>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>1</IBAN>\n" +
                "                        <Othr>\n" +
                "                            <Id>794115296</Id>\n" +
                "                        </Othr>\n" +
                "                    </Id>\n" +
                "                </DbtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>INV2708</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
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
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        //1.3 获取请求体的内容
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);

        long begin = System.currentTimeMillis();
        System.out.println("R49报文检查测试========================>>>>" + mxPacs00800110.checkStpR49());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkStpAllSuccess(){
        long begin = System.currentTimeMillis();
        checkStpR1Success();
        checkStpR2Success();
        checkStpR3Success();
//        checkStpR4Success();
        checkStpR5Success();
        checkStpR6Success();
        checkStpR7Success();
        checkStpR8Success();
        //checkStpR9Success();
        checkStpR10Success();
        checkStpR11Success();
        checkStpR12Success();
        checkStpR13Success();
        checkStpR14Success();
        checkStpR15Success();
        checkStpR16Success();
        checkStpR17Success();
        checkStpR18Success();
        checkStpR19Success();
        checkStpR20Success();
        checkStpR21Success();
        checkStpR22Success();
        checkStpR23Success();
        checkStpR24Success();
        checkStpR25Success();
        checkStpR26Success();
        checkStpR27Success();
        checkStpR28Success();
        checkStpR29Success();
        checkStpR30Success();
        checkStpR31Success();
        checkStpR32Success();
        checkStpR33Success();
        checkStpR34Success();
        checkStpR35Success();
        checkStpR36Success();
        checkStpR37Success();
        checkStpR38Success();
        checkStpR39Success();
        checkStpR40Success();
        checkStpR41Success();
        checkStpR42Success();
        checkStpR43Success();
        checkStpR44Success();
        checkStpR45Success();
        checkStpR46Success();
        checkStpR47Success();
        checkStpR48Success();
        checkStpR49Success();
        long end = System.currentTimeMillis();
        System.out.println("总花费时常=================>>>>>>"+(end-begin)+"ms");
    }

    @Test
    public void checkStpAllError(){
        long begin = System.currentTimeMillis();
        checkStpR1Error();
        checkStpR2Error();
        checkStpR3Error();
        //checkStpR4Error();
        checkStpR5Error();
        checkStpR6Error();
        checkStpR7Error();
        checkStpR8Error();
        //checkStpR9Error();
        checkStpR10Error();
        checkStpR11Error();
        checkStpR12Error();
        checkStpR13Error();
        checkStpR14Error();
        checkStpR15Error();
        checkStpR16Error();
        checkStpR17Error();
        checkStpR18Error();
        checkStpR19Error();
        checkStpR20Error();
        checkStpR21Error();
        checkStpR22Error();
        checkStpR23Error();
        checkStpR24Error();
        checkStpR25Error();
        checkStpR26Error();
        checkStpR27Error();
        checkStpR28Error();
        checkStpR29Error();
        checkStpR30Error();
        checkStpR31Error();
        checkStpR32Error();
        checkStpR33Error();
        checkStpR34Error();
        checkStpR35Error();
        checkStpR36Error();
        checkStpR37Error();
        checkStpR38Error();
        checkStpR39Error();
        checkStpR40Error();
        checkStpR41Error();
        checkStpR42Error();
        checkStpR43Error();
        checkStpR44Error();
        checkStpR45Error();
        checkStpR46Error();
        checkStpR47Error();
        checkStpR48Error();
        checkStpR49Error();
        long end = System.currentTimeMillis();
        System.out.println("总花费时常=================>>>>>>"+(end-begin)+"ms");
    }

    @Test
    public void testEnum(){
        BusAppHeadToBusSerEnum[] values = BusAppHeadToBusSerEnum.values();
        for (BusAppHeadToBusSerEnum value : values) {
            String bizSvc = value.getBizSvc();
            if ("swift.cbprplus.stp.02".equals(bizSvc)){
                System.out.println(value.getMsgDefIdr());
            }
        }
    }

    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx = MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }
}
