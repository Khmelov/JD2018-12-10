package by.it.titkovskaya.jd02.jd02_08;

import by.it.titkovskaya.jd02.jd02_07.ClientsValidator;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String fileName = (new Path()).getPath(ClientsValidator.class,"clients+att+xsd.xml");
        SAXHandler myHandler = new SAXHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(fileName,myHandler);
    }
}
