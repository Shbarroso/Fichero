package es.ies.puerto.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public abstract class AbstractController {
    private Properties propertiesIdioma;

    public Properties getPropertiesIdioma(){
        return propertiesIdioma;
    }

    public void setPropertiesIdioma(Properties propertiesIdioma) {
        this.propertiesIdioma = propertiesIdioma;
    }
    

    public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();
        if (nombreFichero == null || idioma == null) {
            return properties;
        }
        String path = "src/main/resources/"+nombreFichero+"-"+idioma+".properties";
        
        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            System.out.println("PAth: "+file.getAbsolutePath());
            return properties;
        }
        try {
            FileInputStream input = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            properties.load(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
    
}
