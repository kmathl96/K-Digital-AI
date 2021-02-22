package sec01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		char ch;
		int n;
		double d;
		String str;
		
		try {
			fis = new FileInputStream("data.bin");
			dis = new DataInputStream(fis);
			ch = dis.readChar();
			n = dis.readInt();
			d = dis.readDouble();
			str = dis.readUTF();
			System.out.println(ch);
			System.out.println(n);
			System.out.println(d);
			System.out.println(str);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				dis.close();
			} catch (IOException e) {}
		}
	}
}