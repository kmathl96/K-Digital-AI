package sec01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterTest {

	public static void writeInfo() throws IOException {
		FileWriter fw = new FileWriter("info.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String str = "";
		int age = 20;
		double height = 175.3;
		String name = "홍길동";
		String info = name+"#"+age+"#"+height;
		bw.write(info);
		bw.newLine();
		age = 30;
		height = 180.2;
		name = "고길동";
		info = name+"#"+age+"#"+height;
		bw.write(info);
		bw.newLine();
		bw.close();
		
	}
	public static void readInfo() throws IOException {
		FileReader fr = new FileReader("info.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		String[] its;
		while ((line=br.readLine())!=null) {
//			System.out.println(line);
			its = line.split("#");
			String name = its[0];
			int age = Integer.parseInt(its[1]);
			double height = Double.parseDouble(its[2]);
			System.out.printf("이름:%s,나이:%d,키:%.1f\n",name,age,height);
		}
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		writeInfo();
		readInfo();
		String str = "apple,banana,orange";
		String[] fruit = str.split(",");
		for (String s: fruit) {
			System.out.println(s);
		}
		
		String str1 = 7+7+"7";
		String str2 = "7"+7+7;
		System.out.println(str1);
		System.out.println(str2);
	}
}