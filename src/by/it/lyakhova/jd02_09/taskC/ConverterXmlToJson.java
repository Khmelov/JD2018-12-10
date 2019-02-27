package by.it.lyakhova.jd02_09.taskC;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConverterXmlToJson extends Converter {

    ConverterXmlToJson(Class beanClass) {
        super(beanClass);
    }

   @Override
   public String getText() {
        gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(bean);
   }

    @Override
    public void load(String fileIn) {
       try{
            jaxbContext = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bean = unmarshaller.unmarshal(new File(fileIn));
       }catch (Exception e){
               e.printStackTrace();
       }
   }
}
