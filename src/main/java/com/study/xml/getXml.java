package com.study.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class getXml {

    //获得节点
    @Test
    public void readXml() throws Exception {
        //1.获得工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.得到xml DOM解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        //3.生成document对象
        Document document = builder.parse("src/book.xml");
        //4.得到标签名为book的元素
        NodeList list = document.getElementsByTagName("book");
        //5.取得元素下标为1
        Node item = list.item(1);
        //获得元素文本名称
        String content = item.getTextContent();
        System.out.println(content);
    }





}
