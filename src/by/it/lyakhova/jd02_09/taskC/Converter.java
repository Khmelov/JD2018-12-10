package by.it.lyakhova.jd02_09.taskC;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import java.io.*;

public abstract class Converter {


     Class beanClass;//our class we work
     Object bean;//object for save
     Gson gson;//json builder
     JAXBContext jaxbContext;//architector marshal/unmarshal



    public abstract String getText();
    public abstract void load(String file);

    Converter(Class beanClass){
        this.beanClass=beanClass;
    }

    void save(File file){
        try(BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(file))){
            writer.write(getText());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    void load(File file){
        try(BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file))){

            load(file.toString());

            StringBuilder sb = new StringBuilder();

            while(reader.ready()){
                sb.append(reader.readLine());
            }
            System.out.println("START XML FILE");
            System.out.println(sb);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



}
