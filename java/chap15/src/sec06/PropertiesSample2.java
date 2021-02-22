package sec06;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesSample2 {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		prop.load(new FileReader("db.properties"));
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		System.out.println("driver="+driver);
		System.out.println("url="+url);
		System.out.println("username="+username);
		System.out.println("password="+password);
	}
}