package oose.dea.datasource.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseProperties {

    private Properties properties;
    private static final  String PROPERTYNAME = "database.properties";
    private static final String CONNECTIONURL = "connectionstring";
    private static final String DRIVER = "driver";
    public DatabaseProperties() {
        this.properties = new Properties();
        loadPropertyFile();
    }


    private void loadPropertyFile(){

        InputStream stream = null;
        try{
            stream = new FileInputStream(PROPERTYNAME);
            properties.load(stream);

        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            if(stream != null){
                try {
                    stream.close();
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }

    }


    public String getConnectionUrl(){
        return properties.getProperty(CONNECTIONURL);
    }

    public String getDriver(){
        return properties.getProperty(DRIVER);
    }


}
