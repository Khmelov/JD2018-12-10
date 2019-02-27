package by.it.a_khmelev.jd02_09.taskC;

import by.it.lyakhova.jd02_09.beans.Users;

import java.io.File;

public class Runner {

    public static void main(String[] args) {

        String fileIn = System.getProperty("user.dir") + "/src/by/it/lyakhova/jd02_09/users+xsd.xml";
        String xmlOut = System.getProperty("user.dir") + "/src/by/it/lyakhova/jd02_09/users+xsd2.xml";

        ConverterFactory factory = new ConverterFactory();


        Converter xmlToJson = factory.getConverter(Direction.XML_TO_JSON, Users.class);
        xmlToJson.load(new File(fileIn));
        String json = xmlToJson.getText();

        System.out.println("JSON VIEW");
        System.out.println(json);



        Converter jsonToXml = factory.getConverter(Direction.JSON_TO_XML, Users.class);
        jsonToXml.load(json);
        String xml = jsonToXml.getText();
        jsonToXml.save(new File(xmlOut));

        System.out.println("FINAL XML");
        System.out.println(xml);



    }
}
