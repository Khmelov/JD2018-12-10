package by.it.titkovskaya.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    private StringBuilder xmlTxt;
    private StringBuilder elementTxt;
    private String tab;

    @Override
    public void startDocument() {
        xmlTxt = new StringBuilder();
        elementTxt = new StringBuilder();
        tab = "";
    }

    @Override
    public void endDocument() {
        System.out.println(xmlTxt);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        xmlTxt.append(tab).append("<").append(qName);
        int attCount = attributes.getLength();
        for (int i = 0; i < attCount; i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            String attText = String.format(" %s=\"%s\"", name, value);
            xmlTxt.append(attText);
        }
        tab = tab.concat("\t");
        xmlTxt.append(">\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String text = elementTxt.toString().trim();
        if (!text.isEmpty()) {
            xmlTxt.append(tab).append(text).append("\n");
            elementTxt.setLength(0);
        }
        tab = tab.substring(1);
        xmlTxt.append(tab).append("</").append(qName).append(">\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String part = new String(ch, start, length);
        elementTxt.append(part);
    }
}
