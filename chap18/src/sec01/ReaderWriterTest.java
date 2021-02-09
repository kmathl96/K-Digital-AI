package sec01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("temp.txt");
		FileWriter fw = new FileWriter("copy2.txt");
		
//		int data;
//		while ((data=fr.read())!=-1) { // 파일의 끝은 -1
//			fw.write(data);
//			System.out.print((char)data);
//		}
//		fr.close();
//		fw.close();
		
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		int data;
		while ((data=br.read())!=-1) { // 파일의 끝은 -1
			bw.write(data);
			System.out.print((char)data);
		}
		br.close();
		bw.close();
	}
}