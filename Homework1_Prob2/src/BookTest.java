import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("21424","Java Basic","���ϳ�","Jaen.kr",15000,"�⺻����"));
		books.add(new Book("33455","JDBX Pro","��ö��","Jaen.kr",23000));
		books.add(new Book("55355","Servlet/JSP","���ڹ�","Jaen.kr",41000,"Model2 ���"));
		books.add(new Book("35332","Android App","ȫ�浿","Jaen.kr",25000,"Lightweight Framework"));
		books.add(new Book("35355","OOAD �м�,����","�ҳ���","Jaen.kr",30000));
		books.add(new Magazine("35535","Java World","������","Jaen.kr",7000,2013,2));
		books.add(new Magazine("33434","Mobile World","������","Jaen.kr",8000,2013,8));
		books.add(new Magazine("75342","Next Web","������","Jaen.kr",10000,"AJAX �Ұ�",2012,10));
		books.add(new Magazine("76543","Architecture","������","Jaen.kr",5000,"java �ý���",2010,3));
		books.add(new Magazine("76534","Data Modeling","������","Jaen.kr",14000,2012,12));
		
		System.out.println("****************************** ���� ��� ******************************");
		for (Book book : books) {
			if (!(book instanceof Magazine)) {				
				System.out.println(book.toString());
			}
		}
		System.out.println("****************************** ���� ��� ******************************");
		for (Book book : books) {
			if (book instanceof Magazine) {				
				System.out.println(book.toString());
			}
		}
	}
}