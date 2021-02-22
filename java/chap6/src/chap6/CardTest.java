package chap6;

class Card {
	String shape;
	String num;
	static int width = 20;
	static int height = 30;
	
	public Card(String shape, String num) {
		this.shape = shape;
		this.num = num;
	}
	public String view() {
		return "["+shape+", "+num+","+width+","+height+"]";
	}
}

public class CardTest {
	public static void main(String[] args) {
		Card c1 = new Card("��Ʈ", "A");
		Card c2 = new Card("���̾Ƹ��", "5");
		Card c3 = new Card("Ŭ�ι�", "7");
		System.out.println(c1.view());
		System.out.println(c2.view());
		System.out.println(c3.view());
		Card.height=50;
		Card.width=25;
		System.out.println(c1.view());
		System.out.println(c2.view());
		System.out.println(c3.view());
	}
}
