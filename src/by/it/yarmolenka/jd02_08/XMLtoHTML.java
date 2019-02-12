package by.it.yarmolenka.jd02_08;

import by.it.yarmolenka.MathCalc.GetPath;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLtoHTML {
    public static void main(String[] args) {
        String path = GetPath.getPath(XMLtoHTML.class);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(path + "users.xsl"));
            transformer.transform(new StreamSource(path + "users.xml"), new StreamResult(path + "users.html"));
            System.out.println("Transformation of " + path + "users.xml is complete");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
