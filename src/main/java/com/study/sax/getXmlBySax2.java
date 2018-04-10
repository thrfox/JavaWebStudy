package com.study.sax;

import org.junit.Test;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class getXmlBySax2 {

    @Test
    public void getXmlBySax2() throws Exception {
        //1.取得SAX工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.取得sax解析器
        SAXParser parser = factory.newSAXParser();
        //3.取得读取器
        XMLReader reader = parser.getXMLReader();
        //4.获取事件处理器
        BeanListHandler handler = new BeanListHandler();
        reader.setContentHandler(handler);

        //5.读取xml
        reader.parse("src/book.xml");

        handler.getList();
        System.out.println(1);

    }
    //获取所有标签
    class BeanListHandler extends DefaultHandler{
        private List bookList = new ArrayList();
        private String currentTag = null;
        private Book book = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentTag = qName;
            if ("book".equals(currentTag)){
                book = new Book();
                book.setName(currentTag);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch,start,length);
            if ("book-name".equals(currentTag)){
                book.setName(content);
            }
            if ("book-price".equals(currentTag)){
                book.setPrice(content);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("book".equals(qName)){
                bookList.add(book);
                book = null;
            }
            currentTag = null;
        }

        public List getList(){
            return bookList;
        }
    }
}
