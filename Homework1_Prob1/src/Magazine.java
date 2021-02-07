public class Magazine extends Book {
	int year;
	int month;

	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price, String desc) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString()+ "\t | " + year + "." + month;
	}
}