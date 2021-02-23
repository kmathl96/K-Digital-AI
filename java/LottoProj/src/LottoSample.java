
public class LottoSample {

	public static void main(String[] args) {
		// 1. 1~45 �������� ������ �迭 ����� �Ҵ�
		int[] num = new int[46];
		
		// 2. 1���� �Ҵ��� �迭�� 1~45 �� �ֱ�
		for (int i=0; i<46; i++) {
			num[i] = i;
		}
		
		// 3. 1~45 �� ���� �� 2�� ���Ͽ� �迭 �� �� ������ �ִ� �迭�� �� �ٲٱ�
		// 4. 3�� 1000�� �ݺ�
		for (int j=0; j<1000; j++) {
			int a = (int)(Math.random()*45)+1;
			int b = (int)(Math.random()*45)+1;
			int tmp = num[a];
			num[a] = num[b];
			num[b] = tmp;
		}
		// 5. �迭�� ��� �� �տ��� 6���� �ζ� ��÷ ��ȣ�� ���
		for (int k=1; k<7; k++) {
			System.out.print(num[k]+" ");
		}
	}
}