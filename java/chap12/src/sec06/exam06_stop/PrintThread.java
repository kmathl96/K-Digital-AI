package sec06.exam06_stop;

public class PrintThread extends Thread {
	boolean stop; // false(0)�� �ʱ�ȭ

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	@Override
	public void run() {
		while (stop==false) {
			System.out.println("���� ��");
		}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
}