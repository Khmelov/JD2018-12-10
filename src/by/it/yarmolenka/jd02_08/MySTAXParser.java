package by.it.yarmolenka.jd02_08;

import by.it.yarmolenka.MathCalc.GetPath;
import by.it.yarmolenka.jd02_07.UsersValidator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

class MySTAXParser {
    public static void main(String[] args) {
        String path = GetPath.getPath(UsersValidator.class) + "users+att+xsd.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (Reader reader = new BufferedReader(new FileReader(path))) {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            STAXHelper helper = new STAXHelper();
            StringBuilder xmlText = helper.buildSBFromXML(xmlStreamReader);
            System.out.println(xmlText);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }


}
