package sec01.base;

import java.nio.channels.Channel;

class TV {
	String color;
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
}

public class TvTest {
	public static void method(TV at) {
		
	}

	public static void main(String[] args) {
		TV t; // TV �ν��Ͻ��� �����ϱ� ���� ���� ����
		t = new TV(); // �ν��Ͻ��� �����Ͽ� ���������� ����
		t.channel = 7;
		t.channelDown();
		System.out.println("���� ä���� "+t.channel+" �Դϴ�."); // 6
	
		TV t2 = new TV();
		TV t3 = t2;
		t2.channel = 9;
		System.out.println("���� ä���� "+t2.channel+" �Դϴ�."); // 9
		
		t2 = t;
		System.out.println("���� ä���� "+t2.channel+" �Դϴ�."); // 6
		
		t.channelUp();
		System.out.println("���� ä���� "+t2.channel+" �Դϴ�."); // 7
	
		method(t);
	}
}
