import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStreamReader;

public class ParseXml {

    public BreakfastMenu getBreakfastMenuFromXml(String fileName) throws Exception {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BreakfastMenu.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (BreakfastMenu) jaxbUnmarshaller.unmarshal(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)));
        } catch (Exception e) {
            throw new Exception("Unable to Parse File " + e.getMessage());
        }
    }
}
