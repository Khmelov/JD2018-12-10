package by.it.titkovskaya.jd02.jd02_09.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.Writer;

class ConverterJsonToXml<Bean> extends Converter<Bean> {

    ConverterJsonToXml(Class<Bean> beanClass) {
        super(beanClass);
    }

    @Override
    void load(String source) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Bean bean = gson.fromJson(source, getBeanClass());
        setBean(bean);
        System.out.println("\n=================== JSON loaded ===================");
        System.out.println(bean);
    }

    @Override
    String getText() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Writer writer = new StringWriter();
            marshaller.marshal(getBean(), writer);
            System.out.println("\n=================== XML from JSON ===================\n");
            System.out.println(writer.toString());
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}

/*
При преобразовании в самостоятельный ковертер из JSON в XML логичнее результат конвертации
записыватьв файл непосредственно во время маршализации, минуя создание Writer, т.е:
вместо:
        Writer writer = new StringWriter();
        marshaller.marshal(getBean(), writer);
писать:
        marshaller.marshal(getBean(), new File(xmlOutput));
 */