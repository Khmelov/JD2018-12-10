package by.it.titkovskaya.jd02.jd02_08;

import by.it.titkovskaya.jd02.jd02_07.ClientsValidator;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StAXParser {
    public static void main(String[] args) {
        String fileName = (new Path()).getPath(ClientsValidator.class, "clients+att+xsd.xml");
        StAXParser parser = new StAXParser();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            StringBuilder xml = parser.process(xmlStreamReader);
            System.out.println(xml);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder process(XMLStreamReader xml) throws XMLStreamException {
        StringBuilder xmlTxt = new StringBuilder();
        StringBuilder elementTxt = new StringBuilder();
        String tab = "";
        while (xml.hasNext()) {
            int type = xml.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    xmlTxt.append(tab).append("<").append(xml.getLocalName());
                    int attCount = xml.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = xml.getAttributeLocalName(i);
                        String value = xml.getAttributeValue(i);
                        String attText = String.format(" %s=\"%s\"", name, value);
                        xmlTxt.append(attText);
                    }
                    tab = tab.concat("\t");
                    xmlTxt.append(">\n");
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String text = elementTxt.toString().trim();
                    if (!text.isEmpty()) {
                        xmlTxt.append(tab).append(text).append("\n");
                        elementTxt.setLength(0);
                    }
                    tab = tab.substring(1);
                    xmlTxt.append(tab).append("</").append(xml.getLocalName()).append(">\n");
                    break;
                }
                case XMLStreamConstants.CHARACTERS: {
                    elementTxt.append(xml.getText());
                    break;
                }
            }
        }
        return xmlTxt;
    }
}
