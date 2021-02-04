package sec01.abtr;

abstract class Player {
	int currentPos;
	Player() {
		currentPos = 0;
	}
	abstract void play(int pos);
	abstract void stop();
	
	void play() {
		play(currentPos);
	}
}

class IPlayer extends Player {

	@Override
	void play(int pos) {
	}

	@Override
	void stop() {
	}
}

public class AbstractTest {

	public static void main(String[] args) {
//		player p1 = new Player(); // abstract Ŭ������ ��ü ���� �Ұ���
		Player p2 = new IPlayer();
		p2.play(); // �θ� �޼��� ȣ��
	}
}