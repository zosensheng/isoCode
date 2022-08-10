package com.hisun.kont.mx;

import org.dom4j.*;
import org.junit.Test;
import org.dom4j.io.SAXReader;
import java.util.List;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/4 15:29
 */
public class XpathTest {

    @Test
    public void pathTest1() {
        //查询时建议使用xpath表达式查询
        xpath("/hr/employee");
        xpath("//employee");
//        两个不同之处在于,第一个是在hr根目录下的所有employee元素 二第二个是全部的employee类型元素
        xpath("//employee[salary<4000]");  //中括号是谓语 输出薪水小于4000的员工
        xpath("//employee[name='李四']");  //按照姓名
        xpath("//employee[@no=3301]");  //按照属性
        xpath("//employee[1]");   //按照编号  第一个
        xpath("//employee[last()]"); //最后一个
        xpath("//employee[position()<3]");  //前三个
        xpath("//employee[3] |//employee[5]");  //选第三个和第五个
    }

    public void xpath(String xpathExp) {  //参数是XPath指令
        String file = "E:\\java\\HTML\\src\\hr.xml";  //个人xml文件地址
        SAXReader reader = new SAXReader(); //SAXReader类可以通过多种方法读取XML数据,返回Document类型文件
        try {
            String xmlStr =
//                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<!-- 人力资源管理系统-->\n" +
                    "<hr >\n" +
                    "    <employee no=\"3301\">\n" +
                    "        <name>张三</name>\n" +
                    "        <age>65</age>\n" +
                    "        <salary>5000</salary>\n" +
                    "        <department>\n" +
                    "            <dname>会计部</dname>\n" +
                    "            <adress>XX大厦-B103</adress>\n" +
                    "        </department>\n" +
                    "    </employee>\n" +
                    " \n" +
                    "    <employee no=\"3302\">\n" +
                    "        <name>李四</name>\n" +
                    "        <age>30</age>\n" +
                    "        <salary>5000</salary>\n" +
                    "        <department>\n" +
                    "            <dname>开发部</dname>\n" +
                    "            <adress>XX大厦-B103</adress>\n" +
                    "        </department>\n" +
                    "    </employee>\n" +
                    "    <employee no=\"3303\">\n" +
                    "        <name>李铁柱</name>\n" +
                    "        <age>25</age>\n" +
                    "        <salary>3500</salary>\n" +
                    "        <department>\n" +
                    "            <dname>人事部</dname>\n" +
                    "            <adress>XX大厦-B150</adress>\n" +
                    "        </department>\n" +
                    "    </employee>\n" +
                    "    <employee no=\"3304\">\n" +
                    "        <name>王大锤</name>\n" +
                    "        <age>50</age>\n" +
                    "        <salary>4800</salary>\n" +
                    "        <department>\n" +
                    "            <dname>开发岗</dname>\n" +
                    "            <adress>XX大厦-B150</adress>\n" +
                    "        </department>\n" +
                    "    </employee>\n" +
                    "    <employee no=\"3305\">\n" +
                    "        <name>孙六</name>\n" +
                    "        <age>40</age>\n" +
                    "        <salary>8000</salary>\n" +
                    "        <department>\n" +
                    "            <dname>人事部</dname>\n" +
                    "            <adress>XX大厦-B150</adress>\n" +
                    "        </department>\n" +
                    "    </employee>\n" +
                    "</hr>\n";
            Document document = DocumentHelper.parseText(xmlStr);
//                Document document = reader.read("");  //读取xml数据,返回Document类型文件
            List<Node> nodes = document.selectNodes(xpathExp);  //selectNodes方法,选择匹配XPath表达式的节点列表,返回Node类型
            System.out.println(nodes);
//            for (Node node : nodes) {  //遍历
//                Element emp = (Element) node;  //强制转换称Element类型  元素类型
//                System.out.println(emp.attributeValue("no"));  //输出和指令相符的no属性
//                System.out.println(emp.elementText("name"));  //输出和指令相符节点的姓名
//                System.out.println(emp.elementText("age"));  //输出和指令相符节点的年龄
//                System.out.println(emp.elementText("salary"));  //输出和指令相符节点的薪水
//                System.out.println("===============");
//            }

        } catch (DocumentException  e) {
            e.printStackTrace();
        }
    }
    
}
