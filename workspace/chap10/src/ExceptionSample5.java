public class ExceptionSample5 {

	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.toString());
			System.out.println("try"); // ������� ����
		} catch (Exception e) {
			System.out.println("���� ó��");
			return;
		} finally {
			System.out.println("������ ó��"); // ���� �߻��̳� return���� ����Ǿ ������ �����
		}
		System.out.println("���α׷� ����");
	}
}