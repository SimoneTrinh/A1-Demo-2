package ultils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {
    private static Properties properties;
    static String projectPath = System.getProperty("user.dir");
    static String propertiesFilePath = "src/test/java/resources/resources.properties";
    static String fullPathPropertiesFile = projectPath + "/" + propertiesFilePath;

    public static void setPropertiesFile() {
        properties = new Properties();

        try {
            FileInputStream fileIn = new FileInputStream(fullPathPropertiesFile);

            // load properties file
            properties.load(fileIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropValue(String key) {
        try {
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
