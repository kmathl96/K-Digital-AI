package chap5;

public class CopyArySample {

	public static void main(String[] args) {
		int[] ary = new int[] {10,20,30};
		int[] cpy1 = new int[3];
		int[] cpy2 = new int[3];
		
		cpy1 = ary; // ���� ���� (�ּҰ� ����)
		System.arraycopy(ary, 0, cpy2, 0, ary.length); // ���� ���� (�޸𸮿� �и��Ͽ� ����)
		
		ary[0] = 100; // cpy1[0]�� ���� �ٲ, cpy2[0]�� �ٲ��� ����
		
		System.out.println("---���� ������---");
		for (int i=0; i<ary.length; i++) {
			System.out.println(ary[i]);
		} // 100 20 30
		System.out.println("---���� ����---");
		for (int i=0; i<cpy1.length; i++) {
			System.out.println(cpy1[i]);
		} // 100 20 30
		System.out.println("---���� ����---");
		for (int i=0; i<cpy2.length; i++) {
			System.out.println(cpy2[i]);
		} // 10 20 30
	}
}