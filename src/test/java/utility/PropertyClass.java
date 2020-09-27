package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {

	
	public PropertyClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String getFromPropertyFile(String key)
	{
		Properties props = new Properties();
		String configpath = ".//src//main//resources//propertyfile.properties";
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(configpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = props.getProperty(key);
		return value;
	}
}
