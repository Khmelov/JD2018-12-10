package by.it.titkovskaya.jd02.jd02_09.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

class ConverterXmlToJson<Bean> extends Converter<Bean> {

    ConverterXmlToJson(Class<Bean> beanClass) {
        super(beanClass);
    }

    void load(File source) {
        try {
            JAXBContext context = JAXBContext.newInstance(getBeanClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Bean bean = (Bean) unmarshaller.unmarshal(source);
            setBean(bean);
            System.out.println("\n=================== XML loaded ===================");
            System.out.println(bean);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    String getText() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(getBean());
        System.out.println("\n=================== JSON from XML ===================");
        System.out.println(json);
        return json;
    }

    @Override
    void load(String source) {
        File xmlSource = new File((new Path()).getPath(Converter.class, "xmlSource.xml"));
        save(source,xmlSource);
        load(xmlSource);
    }
}

/*
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(xmlSource))) {
            writer.write(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
 */
