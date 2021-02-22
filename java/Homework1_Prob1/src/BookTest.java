import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("21424","Java Pro","김하나","Jaen.kr",15000,"기본문법"));
		books.add(new Book("35355","OOAD 분석,설계","소나무","Jaen.kr",30000,""));
		books.add(new Magazine("35535","Java World","편집부","androidjava.com",2013,2,7000,""));
		
		System.out.println("****************************** 도서 목록 ******************************");
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
}