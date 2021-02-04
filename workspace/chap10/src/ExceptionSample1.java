
public class ExceptionSample1 {

	public static void main(String[] args) {
		String str = "hi";
		int a=10, b=0;
		try {
			System.out.println(str.toString());
			System.out.println(a/b);
		} catch (NullPointerException e) {
			// 예외 상황이 발생했을 때 처리할 사항
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 종료");
	}
}