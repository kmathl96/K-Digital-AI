package sec01.val;

class InitTest {
	int iv=1;
	static int sv = 10;
	static int[] sarr = new int[10];
//	sarr[0] = 1; // ���ɾ�� �޼ҵ� �ȿ����� �� �� ����
	
	{ // instance �ʱ�ȭ block
		System.out.println(iv); // 1
		iv = 2;
		System.out.println(iv); // 2
	}
	static { // static �ʱ�ȭ block
		// ��ü �������� ���� �� => 10 20�� ���� ��µ�
		// ��ü ���� �� �����ص� �� ������� ���� (�� ó�� �ѹ��� �����)
		System.out.println(sv);
		sv = 20;
		System.out.println(sv);
		
		// �ڵ�� ���� ���� �ʱ�ȭ �� �� static block ���
		for (int i=0; i<sarr.length; i++) {
			sarr[i] = 10;
		}
	}
	InitTest() {
		iv = 3;
		System.out.println(iv); // 3
	}
}

public class InitBlockTest {

	public static void main(String[] args) {
		InitTest it1 = new InitTest();
		InitTest it2 = new InitTest();
	}
}