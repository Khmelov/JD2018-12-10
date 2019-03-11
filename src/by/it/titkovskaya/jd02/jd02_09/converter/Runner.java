package by.it.titkovskaya.jd02.jd02_09.converter;

import by.it.titkovskaya.jd02.jd02_09.beans.Clients;
import java.io.File;

public class Runner {

    public static void main(String[] args) {

        //Перед началом конвертации УКАЗЫВАЕМ путь к исходному файлу (если источником является String,
        //заменяем File ___Source на исходный String ___Source = "...";).
        //Затем при созданиие конвертера ОБЯЗАТЕЛЬНО УКАЗЫВАЕМ корневой beanClass для преобразуемого файла(текста),
        //т.е. после указания вида преобразования (XML_TO_JSON, JSON_TO_XML) вставляем необходимый класс.
        //Файлы, полученные в результате конвертации, сохраняются в папке конвертера (можно задать собственный путь).

        File xmlSource = new File((new Path()).getPath(Converter.class, "clients+xsd.xml"));
        File jsonOutput = new File((new Path()).getPath(Converter.class, "json.json"));
        File jsonSource = new File((new Path()).getPath(Converter.class, "json.json"));
        File xmlOutput = new File((new Path()).getPath(Converter.class, "outputXML.xml"));

        ConverterFactory factory = new ConverterFactory<>();

        Converter converter = factory.getConverter(Direction.XML_TO_JSON, Clients.class); //указываем beanClass
        converter.load(xmlSource);
        converter.save(converter.getText(),jsonOutput);

        converter = factory.getConverter(Direction.JSON_TO_XML, Clients.class); //указываем beanClass
        converter.load(jsonSource);
        converter.save(converter.getText(),xmlOutput);
    }

}
