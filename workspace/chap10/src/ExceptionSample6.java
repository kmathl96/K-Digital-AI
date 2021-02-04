import java.util.Scanner;

public class ExceptionSample6 {

	static Scanner sc = new Scanner(System.in);
	public static int menu() {
		int sel = Integer.parseInt(sc.nextLine());
		return sel;
	}
	public static void subMenu() {
		int sel = Integer.parseInt(sc.nextLine());
	}
	public static void main(String[] args) {
		try {
			menu();
			subMenu();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}