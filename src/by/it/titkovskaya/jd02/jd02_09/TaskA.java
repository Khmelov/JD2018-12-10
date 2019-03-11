package by.it.titkovskaya.jd02.jd02_09;

import by.it.titkovskaya.jd02.jd02_09.beans.Client;
import by.it.titkovskaya.jd02.jd02_09.beans.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        String xmlIn = System.getProperty("user.dir")+"/src/by/it/titkovskaya/jd02_09/clients+xsd.xml";
        String xmlOut = System.getProperty("user.dir")+"/src/by/it/titkovskaya/jd02_09/clients+xsd_resultA.xml";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Clients clients = (Clients) unmarshaller.unmarshal(new File(xmlIn));
            System.out.println(clients);
            System.out.println("=======================================================\n");
            Client john = clients.getClient().get(0);
            john.setLogin("johnSUPER");
            System.out.println(clients);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients,new File(xmlOut));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
