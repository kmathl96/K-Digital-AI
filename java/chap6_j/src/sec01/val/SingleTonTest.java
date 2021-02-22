package sec01.val;

class SingleTon {
	private static SingleTon instance = new SingleTon(); // static 함수에선 static 변수만 접근 할 수 있으므로 static으로 선언
	public static SingleTon getInstance() { // 다른 패키지에서도, 객체 생성 없이 쓰려면 public
		return instance;
	}
	private SingleTon() {}; // private로 외부에서 객체 생성 불가
}

public class SingleTonTest {

	public static void main(String[] args) {
//		SingleTon t = new SingleTon(); // 객체 생성 불가 (생성자가 private이므로)
		SingleTon t1 = SingleTon.getInstance();
		SingleTon t2 = SingleTon.getInstance(); // t1, t2는 동일 객체 참조
	}
}