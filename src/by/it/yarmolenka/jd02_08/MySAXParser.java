package by.it.yarmolenka.jd02_08;

import by.it.yarmolenka.MathCalc.GetPath;
import by.it.yarmolenka.jd02_07.UsersValidator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

class MySAXParser {
    public static void main(String[] args) {
        String pathToXML = GetPath.getPath(UsersValidator.class) + "users+att+xsd.xml";
        MyHandler myHandler = new MyHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(pathToXML, myHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
