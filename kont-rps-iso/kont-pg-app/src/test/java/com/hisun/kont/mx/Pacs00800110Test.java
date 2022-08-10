package com.hisun.kont.mx;

import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.pacs.MXPacs00800110;
import com.hisun.kont.mx.msg.pacs.Pacs00800110;
import com.hisun.kont.mx.msg.pacs.dic.FIToFICustomerCreditTransferV10;
import com.hisun.kont.mx.util.AppHdrParser;
import com.hisun.kont.mx.util.MxParseUtils;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.Optional;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/4 15:29
 */
public class Pacs00800110Test {

    @Test
    public void checkSuccess() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("报文检查测试========================>>>>" + pacs00800110.checkAll());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkError() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("报文检查测试========================>>>>" + pacs00800110.checkAll());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC1Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C1报文检查测试========================>>>>" + pacs00800110.checkC1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC1Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"AA\">10000000</IntrBkSttlmAmt>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C1报文检查测试========================>>>>" + pacs00800110.checkC1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC2Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "                        <TaxRmt>" +
                "                           <TtlTaxAmt Ccy=\"JPY\"></TtlTaxAmt>" +
                "                        </TaxRmt>" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C2报文检查测试========================>>>>" + pacs00800110.checkC2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    /**
     * todo 需要获取对应的测试报文
     */
    @Test
    public void checkC2Error() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "                        <TaxRmt>" +
                "                           <TtlTaxAmt Ccy=\"AA\"></TtlTaxAmt>" +
                "                        </TaxRmt>" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C2报文检查测试========================>>>>" + pacs00800110.checkC2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC3Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <Purp>\n" +
                "                    <Cd>GDDS</Cd>\n" +
                "                </Purp>\n" +
                "                <RmtInf>\n" +
                "                    <Strd>\n" +
                "                       <Invcr>\n" +
                "                           <Id>\n" +
                "                               <OrgId>\n" +
                "                                   <AnyBIC>AAAAGB2L</AnyBIC>\n" +
                "                               </OrgId>\n" +
                "                           </Id>\n" +
                "                        </Invcr>\n" +
                "                        <RfrdDocInf>\n" +
                "                            <Tp>\n" +
                "                                <CdOrPrtry>\n" +
                "                                    <Cd>CINV</Cd>\n" +
                "                                </CdOrPrtry>\n" +
                "                            </Tp>\n" +
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C3报文检查测试========================>>>>" + pacs00800110.checkC3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC3Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <Purp>\n" +
                "                    <Cd>GDDS</Cd>\n" +
                "                </Purp>\n" +
                "                <RmtInf>\n" +
                "                    <Strd>\n" +
                "                       <Invcr>\n" +
                "                           <Id>\n" +
                "                               <OrgId>\n" +
                "                                   <AnyBIC>AAAAGB2</AnyBIC>\n" +
                "                               </OrgId>\n" +
                "                           </Id>\n" +
                "                        </Invcr>\n" +
                "                        <RfrdDocInf>\n" +
                "                            <Tp>\n" +
                "                                <CdOrPrtry>\n" +
                "                                    <Cd>CINV</Cd>\n" +
                "                                </CdOrPrtry>\n" +
                "                            </Tp>\n" +
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C3报文检查测试========================>>>>" + pacs00800110.checkC3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC4Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C4报文检查测试========================>>>>" + pacs00800110.checkC4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC4Error() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "                        <BICFI>AAAAGB2</BICFI>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C4报文检查测试========================>>>>" + pacs00800110.checkC4());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC5Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C5报文检查测试========================>>>>" + pacs00800110.checkC5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC5Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C5报文检查测试========================>>>>" + pacs00800110.checkC5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC7Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>" +
                "   </message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C7报文检查测试========================>>>>" + pacs00800110.checkC7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC7Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C7报文检查测试========================>>>>" + pacs00800110.checkC7());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC9Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C9报文检查测试========================>>>>" + pacs00800110.checkC9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC9Error() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "                        <Ctry>AA</Ctry>\n" +
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
                "                        <Ctry>BB</Ctry>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C9报文检查测试========================>>>>" + pacs00800110.checkC9());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC10Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">1000000</IntrBkSttlmAmt>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C10报文检查测试========================>>>>" + pacs00800110.checkC10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }


    @Test
    public void checkC10Error() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">1000000.0000000000</IntrBkSttlmAmt>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C10报文检查测试========================>>>>" + pacs00800110.checkC10());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC11Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">1000000</IntrBkSttlmAmt>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C11报文检查测试========================>>>>" + pacs00800110.checkC11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间===========================>>>>" + (end - begin) + "ms");
    }


    @Test
    public void checkC11Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000.000000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C11报文检查测试========================>>>>" + pacs00800110.checkC11());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间===========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC12Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C12报文检查测试========================>>>>" + pacs00800110.checkC12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC12Error() {
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
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CCT/JPY/123</MsgId>\n" +
                "                <IntrBkSttlmDt>2019-10-28</IntrBkSttlmDt>\n" +
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C12报文检查测试========================>>>>" + pacs00800110.checkC12());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC13Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C13报文检查测试========================>>>>" + pacs00800110.checkC13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC13Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>D89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C13报文检查测试========================>>>>" + pacs00800110.checkC13());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC15Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C15报文检查测试========================>>>>" + pacs00800110.checkC15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }


    @Test
    public void checkC15Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C15报文检查测试========================>>>>" + pacs00800110.checkC15());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC16Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C16报文检查测试========================>>>>" + pacs00800110.checkC16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间===========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC16Error() {
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
                "                <InstdAgt></InstdAgt>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C16报文检查测试========================>>>>" + pacs00800110.checkC16());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间===========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC17Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <XchgRate>0.1</XchgRate>" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C17报文检查测试========================>>>>" + pacs00800110.checkC17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC17Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"USA\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C17报文检查测试========================>>>>" + pacs00800110.checkC17());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC18Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C18报文检查测试========================>>>>" + pacs00800110.checkC18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间===========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC18Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <XchgRate>0.1</XchgRate>" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C18报文检查测试========================>>>>" + pacs00800110.checkC18());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间===========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC19Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C19报文检查测试========================>>>>" + pacs00800110.checkC19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }


    @Test
    public void checkC19Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <XchgRate>0.1</XchgRate>" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>\n";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C19报文检查测试========================>>>>" + pacs00800110.checkC19());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC20Success() {
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
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C20报文检查测试========================>>>>" + pacs00800110.checkC20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC20Error() {
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
                "                    <InstdRmbrsmntAgtAcct></InstdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>COVE</SttlmMtd>\n" +
                "                    <InstgRmbrsmntAgt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>CCCCJPJT</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </InstgRmbrsmntAgt>\n" +
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C20报文检查测试========================>>>>" + pacs00800110.checkC20());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC21Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C21报文检查测试========================>>>>" + pacs00800110.checkC21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC21Error() {
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
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>AAAAGB2L</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C21报文检查测试========================>>>>" + pacs00800110.checkC21());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC22Success() {
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C22报文检查测试========================>>>>" + pacs00800110.checkC22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC22Error() {
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
                "                    <InstgRmbrsmntAgtAcct></InstgRmbrsmntAgtAcct>\n" +
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
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C22报文检查测试========================>>>>" + pacs00800110.checkC22());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC23Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <InstrForCdtrAgt>\n" +
                "                    <Cd>CHQB</Cd>\n" +
                "                </InstrForCdtrAgt>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C23报文检查测试========================>>>>" + pacs00800110.checkC23());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC23Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <InstrForCdtrAgt>\n" +
                "                    <Cd>CHQB</Cd>\n" +
                "                </InstrForCdtrAgt>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C23报文检查测试========================>>>>" + pacs00800110.checkC23());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC24Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C24报文检查测试========================>>>>" + pacs00800110.checkC24());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC24Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C24报文检查测试========================>>>>" + pacs00800110.checkC24());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC25Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C25报文检查测试========================>>>>" + pacs00800110.checkC25());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC25Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C25报文检查测试========================>>>>" + pacs00800110.checkC25());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC26Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C26报文检查测试========================>>>>" + pacs00800110.checkC26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC26Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C26报文检查测试========================>>>>" + pacs00800110.checkC26());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC27Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C27报文检查测试========================>>>>" + pacs00800110.checkC27());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC27Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C27报文检查测试========================>>>>" + pacs00800110.checkC27());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC28Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C28报文检查测试========================>>>>" + pacs00800110.checkC28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC28Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C28报文检查测试========================>>>>" + pacs00800110.checkC28());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC29Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C29报文检查测试========================>>>>" + pacs00800110.checkC29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC29Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
                "\t\t\t<CdtTrfTxInf>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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

        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C29报文检查测试========================>>>>" + pacs00800110.checkC29());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC30Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C30报文检查测试========================>>>>" + pacs00800110.checkC30());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC30Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
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
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C30报文检查测试========================>>>>" + pacs00800110.checkC30());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC31Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt1Acct></PrvsInstgAgt1Acct>\n" +
                "                <PrvsInstgAgt1></PrvsInstgAgt1>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C31报文检查测试========================>>>>" + pacs00800110.checkC31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC31Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt1Acct></PrvsInstgAgt1Acct>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C31报文检查测试========================>>>>" + pacs00800110.checkC31());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC33Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt2Acct></PrvsInstgAgt2Acct>\n" +
                "                <PrvsInstgAgt2></PrvsInstgAgt2>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C33报文检查测试========================>>>>" + pacs00800110.checkC33());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC33Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt2Acct></PrvsInstgAgt2Acct>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C33报文检查测试========================>>>>" + pacs00800110.checkC33());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC34Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt1Acct></PrvsInstgAgt1Acct>\n" +
                "                <PrvsInstgAgt1></PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2Acct></PrvsInstgAgt2Acct>\n" +
                "                <PrvsInstgAgt2></PrvsInstgAgt2>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C34报文检查测试========================>>>>" + pacs00800110.checkC34());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC34Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt2Acct></PrvsInstgAgt2Acct>\n" +
                "                <PrvsInstgAgt2></PrvsInstgAgt2>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C34报文检查测试========================>>>>" + pacs00800110.checkC34());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC35Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt1Acct></PrvsInstgAgt1Acct>\n" +
                "                <PrvsInstgAgt1></PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2Acct></PrvsInstgAgt2Acct>\n" +
                "                <PrvsInstgAgt2></PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3Acct></PrvsInstgAgt3Acct>\n" +
                "                <PrvsInstgAgt3></PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C35报文检查测试========================>>>>" + pacs00800110.checkC35());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC35Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt1Acct></PrvsInstgAgt1Acct>\n" +
                "                <PrvsInstgAgt1></PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2Acct></PrvsInstgAgt2Acct>\n" +
                "                <PrvsInstgAgt2></PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3Acct></PrvsInstgAgt3Acct>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C35报文检查测试========================>>>>" + pacs00800110.checkC35());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC36Success() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt1Acct></PrvsInstgAgt1Acct>\n" +
                "                <PrvsInstgAgt1></PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt2Acct></PrvsInstgAgt2Acct>\n" +
                "                <PrvsInstgAgt2></PrvsInstgAgt2>\n" +
                "                <PrvsInstgAgt3Acct></PrvsInstgAgt3Acct>\n" +
                "                <PrvsInstgAgt3></PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C36报文检查测试========================>>>>" + pacs00800110.checkC36());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC36Error() {
        String reqXml = "\n" +
                "<message>\n" +
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
                "                <PrvsInstgAgt1Acct></PrvsInstgAgt1Acct>\n" +
                "                <PrvsInstgAgt1></PrvsInstgAgt1>\n" +
                "                <PrvsInstgAgt3Acct></PrvsInstgAgt3Acct>\n" +
                "                <PrvsInstgAgt3></PrvsInstgAgt3>\n" +
                "                <IntrmyAgt1Acct></IntrmyAgt1Acct>\n" +
                "                <IntrmyAgt1></IntrmyAgt1>\n" +
                "                <IntrmyAgt2Acct></IntrmyAgt2Acct>\n" +
                "                <IntrmyAgt2></IntrmyAgt2>\n" +
                "                <IntrmyAgt3Acct></IntrmyAgt3Acct>\n" +
                "                <IntrmyAgt3></IntrmyAgt3>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/JPY/123/1</InstrId>\n" +
                "                    <EndToEndId>ABC/4562/2015-09-08</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/JPY/123/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
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
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C36报文检查测试========================>>>>" + pacs00800110.checkC36());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC37Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C37报文检查测试========================>>>>" + pacs00800110.checkC37());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC37Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C37报文检查测试========================>>>>" + pacs00800110.checkC37());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC38Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>CLRG</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C38报文检查测试========================>>>>" + pacs00800110.checkC38());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC38Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>CLRG</SttlmMtd>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C38报文检查测试========================>>>>" + pacs00800110.checkC38());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC39Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>COVE</SttlmMtd>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C39报文检查测试========================>>>>" + pacs00800110.checkC39());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC39Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>COVE</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C39报文检查测试========================>>>>" + pacs00800110.checkC39());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC40Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>COVE</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C40报文检查测试========================>>>>" + pacs00800110.checkC40());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC40Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>COVE</SttlmMtd>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C40报文检查测试========================>>>>" + pacs00800110.checkC40());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC43Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C43报文检查测试========================>>>>" + pacs00800110.checkC43());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC43Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C43报文检查测试========================>>>>" + pacs00800110.checkC43());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC44Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "\t\t\t\t\t<InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "\t\t\t\t\t<InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C44报文检查测试========================>>>>" + pacs00800110.checkC44());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC44Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C44报文检查测试========================>>>>" + pacs00800110.checkC44());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC45Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C45报文检查测试========================>>>>" + pacs00800110.checkC45());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC45Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C45报文检查测试========================>>>>" + pacs00800110.checkC45());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC46Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <TtlIntrBkSttlmAmt></TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt></IntrBkSttlmDt>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C46报文检查测试========================>>>>" + pacs00800110.checkC46());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC46Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <TtlIntrBkSttlmAmt></TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt></IntrBkSttlmDt>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">6000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C46报文检查测试========================>>>>" + pacs00800110.checkC46());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC47Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C47报文检查测试========================>>>>" + pacs00800110.checkC47());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC47Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"JPY\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C47报文检查测试========================>>>>" + pacs00800110.checkC47());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC48Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C48报文检查测试========================>>>>" + pacs00800110.checkC48());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC48Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C48报文检查测试========================>>>>" + pacs00800110.checkC48());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC49Success() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C49报文检查测试========================>>>>" + pacs00800110.checkC49());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC49Error() {
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
                "                    <BICFI>EEEEDEFF</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>BBBB/150928-CT/EUR/912</MsgId>\n" +
                "                <CreDtTm>2015-09-28T16:01:00</CreDtTm>\n" +
                "                <NbOfTxs>2</NbOfTxs>\n" +
                "                <TtlIntrBkSttlmAmt Ccy=\"EUR\">504500</TtlIntrBkSttlmAmt>\n" +
                "                <SttlmInf>\n" +
                "                    <ThrdRmbrsmntAgtAcct></ThrdRmbrsmntAgtAcct>\n" +
                "                    <ThrdRmbrsmntAgt></ThrdRmbrsmntAgt>\n" +
                "                    <InstgRmbrsmntAgt></InstgRmbrsmntAgt>\n" +
                "                    <InstdRmbrsmntAgt></InstdRmbrsmntAgt>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                    <SttlmAcct>\n" +
                "                        <Id>\n" +
                "                            <Othr>\n" +
                "                                <Id>29314569847</Id>\n" +
                "                            </Othr>\n" +
                "                        </Id>\n" +
                "                    </SttlmAcct>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>BBBBUS33</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/1</InstrId>\n" +
                "                    <EndToEndId>ABC/ABC-13679/2015-09-15</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/1</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">499500</IntrBkSttlmAmt>\n" +
                "                <InstdAmt Ccy=\"EUR\">500000</InstdAmt>\n" +
                "                <ChrgBr>CRED</ChrgBr>\n" +
                "                <ChrgsInf>\n" +
                "                    <Amt Ccy=\"EUR\">500</Amt>\n" +
                "                    <Agt>\n" +
                "                        <FinInstnId>\n" +
                "                            <BICFI>BBBBUS33</BICFI>\n" +
                "                        </FinInstnId>\n" +
                "                    </Agt>\n" +
                "                </ChrgsInf>\n" +
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
                "                        <BICFI>DDDDBEBB</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>GHI Semiconductors</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Avenue Brugmann</StrtNm>\n" +
                "                        <BldgNb>415</BldgNb>\n" +
                "                        <PstCd>1180</PstCd>\n" +
                "                        <TwnNm>Brussels</TwnNm>\n" +
                "                        <Ctry>BE</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>BE30001216371411</IBAN>\n" +
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
                "                            <Nb>ABC-13679</Nb>\n" +
                "                            <RltdDt>20102-09-15</RltdDt>\n" +
                "                        </RfrdDocInf>\n" +
                "                    </Strd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <IntrBkSttlmDt>2015-09-29</IntrBkSttlmDt>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>BBBB/150928-CCT/EUR/912/2</InstrId>\n" +
                "                    <EndToEndId>BBBB/150928-ZZ/JO/164794</EndToEndId>\n" +
                "                    <TxId>BBBB/150928-CCT/EUR/912/2</TxId>\n" +
                "                </PmtId>\n" +
                "                <PmtTpInf>\n" +
                "                    <InstrPrty>NORM</InstrPrty>\n" +
                "                </PmtTpInf>\n" +
                "                <IntrBkSttlmAmt Ccy=\"EUR\">5000</IntrBkSttlmAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Mr. Jones</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>16th Street</StrtNm>\n" +
                "                        <BldgNb>30</BldgNb>\n" +
                "                        <PstCd>NY10023</PstCd>\n" +
                "                        <TwnNm>New York</TwnNm>\n" +
                "                        <Ctry>US</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAcct>\n" +
                "                    <Id>\n" +
                "                        <Othr>\n" +
                "                            <Id>00125583145</Id>\n" +
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
                "                        <BICFI>EEEEDEFF</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>ZZ Insurances</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <StrtNm>Friedrich-Ebert-Anlage</StrtNm>\n" +
                "                        <BldgNb>2-14</BldgNb>\n" +
                "                        <PstCd>D-60 325</PstCd>\n" +
                "                        <TwnNm>Frankfurt am Main</TwnNm>\n" +
                "                        <Ctry>DE</Ctry>\n" +
                "                        <AdrLine>City Haus 1 10th Floor</AdrLine>\n" +
                "                    </PstlAdr>\n" +
                "                </Cdtr>\n" +
                "                <CdtrAcct>\n" +
                "                    <Id>\n" +
                "                        <IBAN>DE89370400440532014000</IBAN>\n" +
                "                    </Id>\n" +
                "                </CdtrAcct>\n" +
                "                <RmtInf>\n" +
                "                    <Ustrd>Contract ZZ/JO/164794</Ustrd>\n" +
                "                </RmtInf>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(reqXml);
        if (appHdr.isPresent()) {
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        }
        //2报文拆解
        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
        long begin = System.currentTimeMillis();
        System.out.println("C49报文检查测试========================>>>>" + pacs00800110.checkC49());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间==========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkAllError() {
        long begin = System.currentTimeMillis();
        checkC1Error();
        checkC2Error();
        checkC3Error();
        checkC4Error();
        checkC5Error();
        checkC7Error();
        checkC9Error();
        checkC10Error();
        checkC11Error();
        checkC12Error();
        checkC13Error();
        checkC15Error();
        checkC16Error();
        checkC17Error();
        checkC18Error();
        checkC19Error();
        checkC20Error();
        checkC21Error();
        checkC22Error();
        checkC23Error();
        checkC24Error();
        checkC25Error();
        checkC26Error();
        checkC27Error();
        checkC28Error();
        checkC29Error();
        checkC30Error();
        checkC31Error();
        checkC33Error();
        checkC34Error();
        checkC35Error();
        checkC36Error();
        checkC37Error();
        checkC38Error();
        checkC39Error();
        checkC40Error();
        checkC43Error();
        checkC44Error();
        checkC45Error();
        checkC46Error();
        checkC47Error();
        checkC48Error();
        checkC49Error();
        long end = System.currentTimeMillis();
        System.out.println("检查总共用时：===================>>>>>>>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkAllSuccess() {
        long begin = System.currentTimeMillis();
        checkC1Success();
        checkC2Success();
        checkC3Success();
        checkC4Success();
        checkC5Success();
        checkC7Success();
        checkC9Success();
        checkC10Success();
        checkC11Success();
        checkC12Success();
        checkC13Success();
        checkC15Success();
        checkC16Success();
        checkC17Success();
        checkC18Success();
        checkC19Success();
        checkC20Success();
        checkC21Success();
        checkC22Success();
        checkC23Success();
        checkC24Success();
        checkC25Success();
        checkC26Success();
        checkC27Success();
        checkC28Success();
        checkC29Success();
        checkC30Success();
        checkC31Success();
        checkC33Success();
        checkC34Success();
        checkC35Success();
        checkC36Success();
        checkC37Success();
        checkC38Success();
        checkC39Success();
        checkC40Success();
        checkC43Success();
        checkC44Success();
        checkC45Success();
        checkC46Success();
        checkC47Success();
        checkC48Success();
        checkC49Success();

        long end = System.currentTimeMillis();
        System.out.println("检查总共用时：===================>>>>>>>>>>" + (end - begin) + "ms");
    }

    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx = MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }
}
