package chap5;

public class AdvancedForSample {

	public static void main(String[] args) {
		int[] ary = {10,20,30,40,50};
		int sum = 0;
		for (int data : ary) {
			sum += data;
		}
		System.out.println(sum);
	}
}