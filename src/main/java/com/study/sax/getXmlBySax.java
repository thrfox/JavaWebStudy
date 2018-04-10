package com.study.sax;

import com.sun.xml.internal.fastinfoset.stax.events.StAXEventReader;
import org.junit.Test;
import org.xml.sax.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class getXmlBySax {

    @Test
    public void getXmlBySax() throws Exception {
        //1.取得SAX工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.取得sax解析器
        SAXParser parser = factory.newSAXParser();
        //3.取得读取器
        XMLReader reader = parser.getXMLReader();
        //4.获取事件处理器
        //reader.setContentHandler(new ListHandler());

        //5.读取xml
        reader.parse("src/book.xml");

    }
    /**
    //获取所有标签
    class ListHandler implements ContentHandler{

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            System.out.println("<" + qName + ">");
            for (int i = 0; i < atts.getLength() && atts != null; i++) {
                System.out.println(atts.getQName(i) + "=" + atts.getValue(i));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("<" + qName + ">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println(new String(ch, start, length));
        }
        @Override
        public void setDocumentLocator(Locator locator) {

        }

        @Override
        public void startDocument() throws SAXException {

        }

        @Override
        public void endDocument() throws SAXException {

        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {

        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {

        }



        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {

        }

        @Override
        public void skippedEntity(String name) throws SAXException {

        }
    }
     **/
}
