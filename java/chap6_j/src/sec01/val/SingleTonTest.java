package sec01.val;

class SingleTon {
	private static SingleTon instance = new SingleTon(); // static �Լ����� static ������ ���� �� �� �����Ƿ� static���� ����
	public static SingleTon getInstance() { // �ٸ� ��Ű��������, ��ü ���� ���� ������ public
		return instance;
	}
	private SingleTon() {}; // private�� �ܺο��� ��ü ���� �Ұ�
}

public class SingleTonTest {

	public static void main(String[] args) {
//		SingleTon t = new SingleTon(); // ��ü ���� �Ұ� (�����ڰ� private�̹Ƿ�)
		SingleTon t1 = SingleTon.getInstance();
		SingleTon t2 = SingleTon.getInstance(); // t1, t2�� ���� ��ü ����
	}
}