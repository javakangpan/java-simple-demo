 package utils;

import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {
     static Properties pp;    
     static{
         pp = new Properties();
         try {
             InputStream fps = PropertiesUtil.class.getResourceAsStream("config.properties");
             pp.load(fps);
             fps.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     public static String values(String key) {
         String value = pp.getProperty(key);
         if (value != null) {
             return value;
         } else {
             return null;
         }
     }
}
