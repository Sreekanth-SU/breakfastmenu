import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStreamReader;

public class ParseJson {
    public BreakfastMenu getBreakfastMenuFromJsonInput(String fileName) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BreakfastMenuJsonMapper breakfastMenuJsonMapper = mapper.readValue(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)), BreakfastMenuJsonMapper.class);
            return breakfastMenuJsonMapper.getBreakfastMenu();
        } catch (Exception e) {
            throw new Exception("Unable to Pare File " + e.getMessage());
        }
    }
}


