package sec01.inter;

class Unit {}

@FunctionalInterface // ������Ʈ�� �޼ҵ� �������̵��� �ƴ�, �ϳ��� �޼ҵ常 ������ ��
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
		Attackable f1 = new Fighter(); // ������ ��ü�� interface ���������� ���� �� ����
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