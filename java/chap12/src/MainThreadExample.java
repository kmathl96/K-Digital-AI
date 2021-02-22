public class MainThreadExample {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		// 하나의 calculator를 둘이 공유 => 같은 메모리 값을 가짐
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}
