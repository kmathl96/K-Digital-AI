package sec01.inter;

class Unit {}

@FunctionalInterface // 오브젝트의 메소드 오버라이딩이 아닌, 하나의 메소드만 오도록 함
interface Movable {
	void move(int x, int y);
}

interface Attackable {
	void attack();
}

class Fighter extends Unit implements Movable, Attackable {

	@Override
	public void attack() {
	}

	@Override
	public void move(int x, int y) {
	}
	
}

public class InterfaceTest {

	public static void main(String[] args) {
		Attackable f1 = new Fighter(); // 구현한 객체를 interface 참조변수에 가질 수 있음
		f1.attack();
//		f1.move();
		Movable f2 = new Fighter();
		f2.move(10, 10);
//		f2.attack();
		Unit f3 = new Fighter();
//		f3.attack();
//		f3.move();
	}
}