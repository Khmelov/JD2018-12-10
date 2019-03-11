package by.it.titkovskaya.jd02.jd02_09;

import by.it.titkovskaya.jd02.jd02_09.beans.Clients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private Clients clients;

    private JAXBContext jaxbContext;
    private Gson gson;

    public TaskB() {
        try {
            jaxbContext = JAXBContext.newInstance(Clients.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    }

    private void readXml() {
        String xmlIn = System.getProperty("user.dir") + "/src/by/it/titkovskaya/jd02_09/clients+xsd_resultA.xml";
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            clients = (Clients) unmarshaller.unmarshal(new File(xmlIn));
            System.out.println(clients);
            System.out.println("=======================================================\n");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private String getJson(){
        return gson.toJson(clients);
    }

    private void readJson(String json){
        clients=gson.fromJson(json,Clients.class);
    }

    private void saveXML() {
        String xmlOut = System.getProperty("user.dir") + "/src/by/it/titkovskaya/jd02_09/clients+xsd_resultB.xml";
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients, new File(xmlOut));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TaskB instance = new TaskB();
        instance.readXml();
        String json = instance.getJson();
        System.out.println(json);
        instance.readJson(json);
        instance.saveXML();
    }

}
