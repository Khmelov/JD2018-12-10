package by.it.lyakhova.jd02_09.taskC;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;


public class ConverterJsonToXml extends Converter {
    ConverterJsonToXml(Class beanClass){
        super(beanClass);
    }

    @Override
    public String getText() {
        StringWriter writer = new StringWriter();
        try {
            jaxbContext = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean,writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    @Override
    public void load(String json) {
        gson = new GsonBuilder().serializeNulls().create();
        bean = gson.fromJson(json, beanClass);
    }
}
