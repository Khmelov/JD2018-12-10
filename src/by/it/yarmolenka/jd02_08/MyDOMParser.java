package by.it.yarmolenka.jd02_08;

import by.it.yarmolenka.MathCalc.GetPath;
import by.it.yarmolenka.jd02_07.UsersValidator;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MyDOMParser {
    public static void main(String[] args) {
        String path = GetPath.getPath(UsersValidator.class) + "users+att+xsd.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document parse = builder.parse(path);
            Element e = parse.getDocumentElement();
            StringBuilder xmlText = new StringBuilder();
            XMLTextToSB("", e, xmlText);
            System.out.println(xmlText);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void XMLTextToSB(String prefix, Node node, StringBuilder xmlText) {
        String content = node.getTextContent().trim();
        String name = node.getNodeName();
        if (content.isEmpty() || name == null) return;
        if (!name.equals("#text")) {
            openingTagToSB(prefix, node, xmlText, name);
        }
        if (name.equals("#text")) {
            xmlText.append(prefix).append(node.getTextContent().trim()).append('\n');
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            XMLTextToSB(prefix + "\t", childNodes.item(i), xmlText);
        }
        if (!name.equals("#text")) {
            xmlText.append(prefix).append("</").append(name).append(">\n");
        }
    }

    private static void openingTagToSB(String prefix, Node node, StringBuilder xmlText, String name) {
        xmlText.append(prefix).append('<').append(name);
        if (node.hasAttributes()) {
            NamedNodeMap attributes = node.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = attributes.item(i);
                String attribute = String.format(" %s=\"%s\"", item.getNodeName(), item.getNodeValue());
                xmlText.append(attribute);
                if (attribute.length() > 30 && length - i > 1) xmlText.append('\n');
            }
        }
        xmlText.append(">\n");
    }
}