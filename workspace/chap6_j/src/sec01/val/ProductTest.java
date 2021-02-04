package sec01.val;

class Product {
	static int count = 100;
	int serialNo;
	
	public Product() {
		serialNo = count++;
	}
}

public class ProductTest {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println(p1.serialNo);
		System.out.println(p2.serialNo);
		System.out.println(p3.serialNo);
	}
}