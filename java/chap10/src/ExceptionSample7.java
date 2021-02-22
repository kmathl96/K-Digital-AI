public class ExceptionSample7 {
	public static void method1() throws Exception {
		method2();
	}
	public static void method2() throws Exception {
		String str = null;
		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			throw new Exception("다시 생성한 예외");
		}
	}
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}