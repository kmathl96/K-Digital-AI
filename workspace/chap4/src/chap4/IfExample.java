package chap4;

public class IfExample {

	public static void main(String[] args) {
		int score = 85;
		if (score >= 90) {
			System.out.println('A');
		} else if (score >= 80) { // 위 조건을 만족하지 않을 때만 비교, 만족한다면 if문 전체를 빠져나옴
			System.out.println('B');
		} else if (score >= 70) {
			System.out.println('C');
		} else if (score >= 60) {
			System.out.println('D');
		} else {
			System.out.println('F');
		}
		System.out.println("종료");
	}
}
