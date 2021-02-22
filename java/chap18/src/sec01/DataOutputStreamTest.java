package sec01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		char ch = 'A';
		int n = 100;
		double p = 3.14;
		String str = "String";
		
		try {
			fos = new FileOutputStream("data.bin"); // try-catch 사용하지 않으면 컴파일 에러
			dos = new DataOutputStream(fos);
			dos.writeChar(ch);
			dos.writeInt(n);
			dos.writeDouble(p);
			dos.writeUTF(str);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos!=null) dos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}