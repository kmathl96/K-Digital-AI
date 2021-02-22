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
		TV t; // TV 인스턴스를 참조하기 위한 변수 선언
		t = new TV(); // 인스턴스를 생성하여 참조변수에 넣음
		t.channel = 7;
		t.channelDown();
		System.out.println("현재 채녈은 "+t.channel+" 입니다."); // 6
	
		TV t2 = new TV();
		TV t3 = t2;
		t2.channel = 9;
		System.out.println("현재 채녈은 "+t2.channel+" 입니다."); // 9
		
		t2 = t;
		System.out.println("현재 채녈은 "+t2.channel+" 입니다."); // 6
		
		t.channelUp();
		System.out.println("현재 채녈은 "+t2.channel+" 입니다."); // 7
	
		method(t);
	}
}
