package Utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static String loadProperty(String name){
        Properties props = new Properties();
        try{
            String PROP_FILE = "/app.properties";
            props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
        }catch(IOException e){
            e.printStackTrace();
        }

        String value = "";

        if (name != null){
            value = props.getProperty(name);
        }
        return value;
    }
}
