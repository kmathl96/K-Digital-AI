package sec06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		prop.setProperty("driver", "oracle.jdbc.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("username", "hr");
		prop.setProperty("password", "hr");
		
		FileOutputStream out1 = new FileOutputStream("db.properties");
		prop.store(out1, "database set");
		
		FileOutputStream out2 = new FileOutputStream("db.xml");
		prop.storeToXML(out2, "database set", "utf-8");
	}
}