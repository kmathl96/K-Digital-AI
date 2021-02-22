package sec01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("temp.txt");
		FileOutputStream fos = new FileOutputStream("copy.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
//		byte[] buffer = new byte[1024];
//		int len;
//		while ((len=fis.read(buffer))!=-1) { // 파일의 끝은 -1
//			fos.write(buffer,0,len);
//		}
//		fis.close();
//		fos.close();
		
		int data;
		while((data=bis.read())!=-1) {
			bos.write(data);
		}
		bis.close();
		bos.close();
		
	}
}