package by.it.titkovskaya.jd02.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTTransformer {

    private final static String root = "src/by/it/titkovskaya/jd02_08/";

    public static void main(String[] args) {
        String fileName = root + "clients.xml";
        String fileHTML = root + "clients.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root + "clients.xsl"));
            transformer.transform(new StreamSource(fileName), new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}
