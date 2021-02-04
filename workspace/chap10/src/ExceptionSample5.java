public class ExceptionSample5 {

	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.toString());
			System.out.println("try"); // 실행되지 않음
		} catch (Exception e) {
			System.out.println("예외 처리");
			return;
		} finally {
			System.out.println("마무리 처리"); // 예외 발생이나 return으로 종료되어도 무조건 실행됨
		}
		System.out.println("프로그램 종료");
	}
}