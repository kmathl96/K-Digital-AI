import java.util.Scanner;

public class ExceptionSample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel;
		while (true) {
			try {
				System.out.print("���� �Է� >> ");
				sel = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��� �����մϴ�.");
			}
		}
	}
}