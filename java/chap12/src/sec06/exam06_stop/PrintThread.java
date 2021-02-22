package sec06.exam06_stop;

public class PrintThread extends Thread {
	boolean stop; // false(0)로 초기화

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	@Override
	public void run() {
		while (stop==false) {
			System.out.println("실행 중");
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}