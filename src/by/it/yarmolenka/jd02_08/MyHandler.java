package by.it.yarmolenka.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class MyHandler extends DefaultHandler {
    private String tab;
    private StringBuilder textXML;
    private StringBuilder insideText;


    MyHandler() {
    }

    @Override
    public void startDocument() {
        tab = "";
        textXML = new StringBuilder();
        insideText = new StringBuilder();
    }

    @Override
    public void endDocument() {
        System.out.println(textXML);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        textXML.append(tab).append('<').append(qName);
        int attrCount = attributes.getLength();
        for (int i = 0; i < attrCount; i++) {
            String attributeName = attributes.getLocalName(i);
            String attributeValue = attributes.getValue(i);
            String attributeText = String.format(" %s=\"%s\"", attributeName, attributeValue);
            textXML.append(attributeText);
            if (attributeText.length()>30 && attrCount-i>1) textXML.append('\n').append(tab);
        }
        textXML.append(">\n");
        tab += "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String text = insideText.toString().trim();
        if (!text.isEmpty()){
            textXML.append(tab).append(text).append('\n');
            insideText.setLength(0);
        }
        tab = tab.substring(1);
        textXML.append(tab).append("</").append(qName).append(">\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        insideText.append(ch, start, length);
    }
}
