package chap4;

public class WhileGugudan {

	public static void main(String[] args) {
		int i = 1;
		while (i<10) {
			int j = 2;
			while (j<10) {
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
