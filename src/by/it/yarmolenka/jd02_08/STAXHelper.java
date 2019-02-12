package by.it.yarmolenka.jd02_08;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

class STAXHelper {
    private StringBuilder textXML;
    private StringBuilder insideText;
    private String tab;

    STAXHelper() {
        this.textXML = new StringBuilder();
        this.insideText = new StringBuilder();
        tab = "";
    }

    StringBuilder buildSBFromXML(XMLStreamReader xml) throws XMLStreamException {
        while (xml.hasNext()) {
            int type = xml.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:{
                    processStartElement(xml);
                    break;
                }
                case XMLStreamConstants.END_ELEMENT:{
                    processEndElement(xml);
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

    private void processEndElement(XMLStreamReader xml) {
        String text = insideText.toString().trim();
        if (!text.isEmpty()){
            textXML.append(tab).append(text).append('\n');
            insideText.setLength(0);
        }
        tab = tab.substring(1);
        textXML.append(tab).append("</").append(xml.getLocalName()).append(">\n");
    }

    private void processStartElement(XMLStreamReader xml) {
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
    }


}
