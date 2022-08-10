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
 * @date 2022/7/7 16:10
 */
public class BusinessApplicationHeaderV02Test {


    @Test
    public void checkC1Success() {
        String reqXml = "<message>\n" +
                "    <AppHdr\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <Fr>\n" +
                "<OrgId><Id><OrgId><AnyBIC>AAAAGB2L</AnyBIC></OrgId></Id></OrgId>\n" +
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C1报文检查测试========================>>>>" + appHdr1.checkC1());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }
 @Test
    public void checkC1Error() {
        String reqXml = "<message>\n" +
                "    <AppHdr\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <Fr>\n" +
                "<OrgId><Id><OrgId><AnyBIC>AAAAGB2</AnyBIC></OrgId></Id></OrgId>\n" +
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C1报文检查测试========================>>>>" + appHdr1.checkC1());
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
                "<OrgId><Id><OrgId><AnyBIC>AAAAGB2L</AnyBIC></OrgId></Id></OrgId>\n" +
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C2报文检查测试========================>>>>" + appHdr1.checkC2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC2Error() {
        String reqXml = "<message>\n" +
                "    <AppHdr\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <Fr>\n" +
                "<OrgId><Id><OrgId><AnyBIC>AAAAGB2L</AnyBIC></OrgId></Id></OrgId>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>BBBBUS3</BICFI>\n" +
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C2报文检查测试========================>>>>" + appHdr1.checkC2());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkC3Success() {
        String reqXml = "<message>\n" +
                "    <AppHdr\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <Fr>\n" +
                "<OrgId>" +
                "<CtryOfRes>US</CtryOfRes>"+
                "<Id>" +
                "<OrgId>" +
                "<AnyBIC>AAAAGB2L</AnyBIC>" +
                "</OrgId>" +
                "</Id>" +
                "</OrgId>\n" +
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C3报文检查测试========================>>>>" + appHdr1.checkC3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }
    @Test
    public void checkC3Error() {
        String reqXml = "<message>\n" +
                "    <AppHdr\n" +
                "        xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <Fr>\n" +
                "   <OrgId>" +
                "   <CtryOfRes>AA</CtryOfRes>"+
                "   <Id>" +
                "   <OrgId>" +
                "   <AnyBIC>AAAAGB2L</AnyBIC>" +
                "   </OrgId>" +
                "   </Id>" +
                "   </OrgId>\n" +
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C3报文检查测试========================>>>>" + appHdr1.checkC3());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
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
                "                    <BICFI>AAAAGB2L</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "         <CpyDplct>CODU</CpyDplct>\n" +
                "         <Rltd></Rltd>\n"+
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C5报文检查测试========================>>>>" + appHdr1.checkC5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
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
                "                    <BICFI>AAAAGB2L</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "         <CpyDplct>CODU</CpyDplct>\n" +
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
        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        long begin = System.currentTimeMillis();
        System.out.println("C5报文检查测试========================>>>>" + appHdr1.checkC5());
        long end = System.currentTimeMillis();
        System.out.println("报文检查时间========================>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkAllError() {
        long begin = System.currentTimeMillis();
        checkC1Error();
        checkC2Error();
        checkC3Error();
        checkC5Error();
        long end = System.currentTimeMillis();
        System.out.println("检查总共用时：===================>>>>>>>>>>" + (end - begin) + "ms");
    }

    @Test
    public void checkAllSuccess() {
        long begin = System.currentTimeMillis();
        checkC1Success();
        checkC2Success();
        checkC3Success();
        checkC5Success();
        long end = System.currentTimeMillis();
        System.out.println("检查总共用时：===================>>>>>>>>>>" + (end - begin) + "ms");
    }

}
