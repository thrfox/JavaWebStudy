package com.study.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;

public class XPathTrain {
    /**
     * 查找user.xml文档中是否有匹配数据


    public static void ThreadMain(String[] args) throws DocumentException {
        String username = "aaa";
        String pw = "123";

        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("H:\\GitHub\\JavaWebStudy\\Xml\\src\\user.xml"));

        Node node = document.selectSingleNode("//user[@name='"+ username +"' and @password='"+ pw +"']");
        if (node == null) System.out.println("用户名密码错误");
        else System.out.println("成功");
    }
     */
}
