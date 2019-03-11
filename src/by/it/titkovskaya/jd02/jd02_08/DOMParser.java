package by.it.titkovskaya.jd02.jd02_08;

import by.it.titkovskaya.jd02.jd02_07.ClientsValidator;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {

    public static void main(String[] args) {
        String fileName = (new Path()).getPath(ClientsValidator.class, "clients+att+xsd.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            Element element = document.getDocumentElement();
            printDom("", element);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }

    private static void printDom(String prefix, Node node) {

        if (node.getNodeType()==node.ELEMENT_NODE) {
            System.out.print(prefix + "<" + node.getNodeName());
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(" " + attributes.item(i));
            }
            System.out.println(">");
        }

        String text=node.getNodeValue();
        if (text!=null) {
            if (text.trim().length()>0)
                System.out.println(prefix + text.trim());
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix + "\t", children.item(i));
        }

        if (node.getNodeType()==node.ELEMENT_NODE) {
            System.out.println(prefix + "</" + node.getNodeName() + ">");
        }
    }
}
