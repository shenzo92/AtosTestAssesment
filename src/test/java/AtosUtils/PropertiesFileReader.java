package AtosUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 
public class PropertiesFileReader {

 private Properties properties; 
 
 public PropertiesFileReader() throws IOException{
 BufferedReader reader;
 File directory = new File(".");
 String propertyFilePath = directory.getCanonicalPath() + "\\resources\\FrameWork.properties";
 try {
 reader = new BufferedReader(new FileReader(propertyFilePath));
 properties = new Properties();
 try {
 properties.load(reader);
 reader.close();
 } catch (IOException e) {
 e.printStackTrace();
 }
 } catch (FileNotFoundException e) {
 e.printStackTrace();
 throw new RuntimeException("FrameWork.properties not found at " + propertyFilePath);
 } 
 }
 
 public String getNodeURL(){
 String nodeURL = properties.getProperty("nodeURL");
 if(nodeURL!= null) return nodeURL;
 else throw new RuntimeException("nodeURL not specified in the FrameWork.properties file."); 
 }
 
 
 public String getBaseUrl() {
 String BaseURL = properties.getProperty("BaseURL");
 if(BaseURL != null) return BaseURL;
 else throw new RuntimeException("BaseURL not specified in the Configuration.properties file.");
 }
 
}
