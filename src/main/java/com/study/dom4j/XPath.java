package com.study.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;

public class XPath {

    @Test
    public void xpathRead() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        String text = document.selectSingleNode("//book-name").getText();
        System.out.println(text);

    }
}
