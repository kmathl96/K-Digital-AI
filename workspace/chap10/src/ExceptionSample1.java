
public class ExceptionSample1 {

	public static void main(String[] args) {
		String str = "hi";
		int a=10, b=0;
		try {
			System.out.println(str.toString());
			System.out.println(a/b);
		} catch (NullPointerException e) {
			// ���� ��Ȳ�� �߻����� �� ó���� ����
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("���α׷� ����");
	}
}