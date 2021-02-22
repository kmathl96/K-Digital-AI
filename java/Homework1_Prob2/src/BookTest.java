import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("21424","Java Basic","김하나","Jaen.kr",15000,"기본문법"));
		books.add(new Book("33455","JDBX Pro","김철수","Jaen.kr",23000));
		books.add(new Book("55355","Servlet/JSP","박자바","Jaen.kr",41000,"Model2 기반"));
		books.add(new Book("35332","Android App","홍길동","Jaen.kr",25000,"Lightweight Framework"));
		books.add(new Book("35355","OOAD 분석,설계","소나무","Jaen.kr",30000));
		books.add(new Magazine("35535","Java World","편집부","Jaen.kr",7000,2013,2));
		books.add(new Magazine("33434","Mobile World","편집부","Jaen.kr",8000,2013,8));
		books.add(new Magazine("75342","Next Web","편집부","Jaen.kr",10000,"AJAX 소개",2012,10));
		books.add(new Magazine("76543","Architecture","편집부","Jaen.kr",5000,"java 시스템",2010,3));
		books.add(new Magazine("76534","Data Modeling","편집부","Jaen.kr",14000,2012,12));
		
		System.out.println("****************************** 도서 목록 ******************************");
		for (Book book : books) {
			if (!(book instanceof Magazine)) {				
				System.out.println(book.toString());
			}
		}
		System.out.println("****************************** 잡지 목록 ******************************");
		for (Book book : books) {
			if (book instanceof Magazine) {				
				System.out.println(book.toString());
			}
		}
	}
}