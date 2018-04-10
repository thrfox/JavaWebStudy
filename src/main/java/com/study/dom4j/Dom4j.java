package com.study.dom4j;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Dom4j {

    //读取xml文档第二本书的书名
    @Test
    public void read() throws Exception {
        //1.获取xml解析器
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));
        //2.获得xml根节点
        Element root = document.getRootElement();
        //3.获得第二本book
        Element book = (Element) root.elements("book").get(1);
        //4.获得书名
        Element bookName = book.element("book-name");
        System.out.println(bookName.getText());

        //获得属性名
        String value = bookName.attributeValue("name");
        System.out.println(value);

    }

    //在第一本书上添加新价格
    @Test
    public void add() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        Element book = document.getRootElement().element("book");
        book.addElement("book-price").setText("999元");

        //设置格式化输出器
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        //写回XML文档
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),format);
        writer.write(document);
        writer.close();
    }

    //在第一本书指定位置上添加新价格
    @Test
    public void add2() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        Element book = document.getRootElement().element("book");
        //获得书下的所有节点
        List list = book.elements();

        //创建元素
        Element price = DocumentHelper.createElement("book-price");
        price.setText("888元");

        //添加指定位置
        list.add(2,price);

        //设置格式化输出器
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        //写回XML文档
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),format);
        writer.write(document);
        writer.close();
    }

    //删除节点
    @Test
    public void delete() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        //获得删除的节点，第二个节点
        Element price2 = (Element) document.getRootElement().element("book").elements("book-price").get(1);
        price2.getParent().remove(price2);

        //设置格式化输出器
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        //写回XML文档
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),format);
        writer.write(document);
        writer.close();
    }

    //更新节点
    @Test
    public void update() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        //获得节点，第二个节点
        Element price2 = (Element) document.getRootElement().element("book").elements("book-price").get(1);
        //设置内容
        price2.setText("一亿元");
        //设置属性
        price2.addAttribute("level","hight");

        //设置格式化输出器
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        //写回XML文档
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),format);
        writer.write(document);
        writer.close();
    }



}
