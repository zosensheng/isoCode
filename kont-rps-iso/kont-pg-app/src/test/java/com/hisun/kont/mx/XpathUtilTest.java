package com.hisun.kont.mx;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/4 15:29
 */
public class XpathUtilTest {

    @Test
    public void pathTest1() {
        //查询时建议使用xpath表达式查询
        xpath("//Envelope");
        xpath("//Envelope/AppHdr/Fr/FIId/FinInstnId/BICFI");
////        两个不同之处在于,第一个是在hr根目录下的所有employee元素 二第二个是全部的employee类型元素
//        xpath("//employee[salary<4000]");  //中括号是谓语 输出薪水小于4000的员工
//        xpath("//employee[name='李四']");  //按照姓名
//        xpath("//employee[@no=3301]");  //按照属性
//        xpath("//employee[1]");   //按照编号  第一个
//        xpath("//employee[last()]"); //最后一个
//        xpath("//employee[position()<3]");  //前三个
//        xpath("//employee[3] |//employee[5]");  //选第三个和第五个
        System.out.println("===============");
    }

    public void xpath(String xpathExp) {  //参数是XPath指令
        String file = "E:\\java\\HTML\\src\\hr.xml";  //个人xml文件地址
        SAXReader reader = new SAXReader(); //SAXReader类可以通过多种方法读取XML数据,返回Document类型文件
        try {
            String xmlStr ="<message>\n" +
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
            Document document = DocumentHelper.parseText(xmlStr);
            //获得某个节点的属性对象
            Element rootElem = document.getRootElement();
            //获取根节点属性对象
            Attribute rootAttr = rootElem.attribute("Ctry");

            //获取指定节点属性对象
            Element contactElem = rootElem.element("contact");
            Attribute contactAttr = contactElem.attribute("BICFI");

            //获取指定对象的属性名
            System.out.println(rootAttr.getName());
            System.out.println(contactAttr.getName());

            //获取指定对象的属性值
            System.out.println(contactAttr.getValue());
            System.out.println(rootAttr.getValue());

            //遍历某个节点的所有属性
            for (Iterator it = contactElem.attributeIterator(); it.hasNext();){
                Attribute  conAttr= (Attribute)it.next();
                String conTxt = conAttr.getValue();
                String conAttrName = conAttr.getName();
                System.out.println(conAttrName+" = "+conTxt);
            }

            //设置某节点的属性和值
            contactElem.addAttribute("name", "zhangsan");

            //设置(更改)某属性的值
            Attribute nameAttr = contactElem.attribute("name");
            nameAttr.setValue("lisi");

            //删除某节点的指定属性
            contactElem.remove(nameAttr);

//                Document document = reader.read("");  //读取xml数据,返回Document类型文件
            List<Node> nodes = document.selectNodes(xpathExp);  //selectNodes方法,选择匹配XPath表达式的节点列表,返回Node类型
            for (Node node : nodes) {  //遍历
                Element emp = (Element) node;  //强制转换称Element类型  元素类型
                System.out.println(emp.attributeValue("BICFI"));  //输出和指令相符的no属性
//                System.out.println(emp.elementText("name"));  //输出和指令相符节点的姓名
//                System.out.println(emp.elementText("age"));  //输出和指令相符节点的年龄
//                System.out.println(emp.elementText("salary"));  //输出和指令相符节点的薪水
                System.out.println("===============");
            }

        } catch (DocumentException  e) {
            e.printStackTrace();
        }
    }
    
}
