package new_things;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyTest {

    public static void main(String[] args) {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            String testurl = property.getProperty("testurl");

            System.out.println("TESTURL: "+testurl);

        }catch (IOException e){
            System.out.println("Error: Property File is absent");
        }


    }


}
