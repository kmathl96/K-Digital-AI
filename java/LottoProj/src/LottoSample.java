
public class LottoSample {

	public static void main(String[] args) {
		// 1. 1~45 정수값을 저장할 배열 선언과 할당
		int[] num = new int[46];
		
		// 2. 1에서 할당한 배열에 1~45 값 넣기
		for (int i=0; i<46; i++) {
			num[i] = i;
		}
		
		// 3. 1~45 중 랜덤 값 2개 구하여 배열 중 그 순번에 있는 배열의 값 바꾸기
		// 4. 3을 1000번 반복
		for (int j=0; j<1000; j++) {
			int a = (int)(Math.random()*45)+1;
			int b = (int)(Math.random()*45)+1;
			int tmp = num[a];
			num[a] = num[b];
			num[b] = tmp;
		}
		// 5. 배열의 요소 중 앞에서 6개를 로또 당첨 번호로 출력
		for (int k=1; k<7; k++) {
			System.out.print(num[k]+" ");
		}
	}
}
