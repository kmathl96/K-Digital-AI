import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("21424","Java Pro","���ϳ�","Jaen.kr",15000,"�⺻����"));
		books.add(new Book("35355","OOAD �м�,����","�ҳ���","Jaen.kr",30000,""));
		books.add(new Magazine("35535","Java World","������","androidjava.com",2013,2,7000,""));
		
		System.out.println("****************************** ���� ��� ******************************");
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
}