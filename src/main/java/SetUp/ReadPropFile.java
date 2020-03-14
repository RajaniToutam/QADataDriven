package SetUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

    private String path = System.getProperty("user.dir");
    private Properties properties;
    private FileInputStream fileInputStream;

    //constructor to read the property file and load it - optional we can use IOException instead of try&catch
    public ReadPropFile() {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(path + "//src//main//resources//CRM.properties"); // get or read the property file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream); //load the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername(){
        return properties.getProperty("username");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }
}
