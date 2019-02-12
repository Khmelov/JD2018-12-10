package by.it.yarmolenka.jd02_08;

import by.it.yarmolenka.MathCalc.GetPath;
import by.it.yarmolenka.jd02_07.UsersValidator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

class MySTAXParser {
    public static void main(String[] args) {
        String path = GetPath.getPath(UsersValidator.class) + "users+att+xsd.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (Reader reader = new BufferedReader(new FileReader(path))) {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            StringBuilder xmlText = process(xmlStreamReader);
            System.out.println(xmlText);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder process(XMLStreamReader xml) throws XMLStreamException {
        StringBuilder textXML = new StringBuilder();
        StringBuilder insideText = new StringBuilder();
        String tab = "";
        while (xml.hasNext()) {
            int type = xml.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:{
                    textXML.append(tab).append('<').append(xml.getLocalName());
                    int attrCount = xml.getAttributeCount();
                    for (int i = 0; i < attrCount; i++) {
                        String attributeName = xml.getAttributeLocalName(i);
                        String attributeValue = xml.getAttributeValue(i);
                        String attributeText = String.format(" %s=\"%s\"", attributeName, attributeValue);
                        textXML.append(attributeText);
                        if (attributeText.length()>30 && attrCount-i>1) textXML.append('\n').append(tab);
                    }
                    textXML.append(">\n");
                    tab += "\t";
                    break;
                }
                case XMLStreamConstants.END_ELEMENT:{
                    String text = insideText.toString().trim();
                    if (!text.isEmpty()){
                        textXML.append(tab).append(text).append('\n');
                        insideText.setLength(0);
                    }
                    tab = tab.substring(1);
                    textXML.append(tab).append("</").append(xml.getLocalName()).append(">\n");
                    break;
                }
                case XMLStreamConstants.CHARACTERS:{
                    insideText.append(xml.getText());
                    break;
                }
            }
        }
        return textXML;
    }
}
