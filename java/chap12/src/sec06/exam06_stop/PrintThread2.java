package sec06.exam06_stop;

public class PrintThread2 extends Thread {
	@Override
	public void run() {
		// 1.
		try {
			while (true) {
				System.out.println("실행 중");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("마무리 작업");
		}
		
		// 2.
//		while (true) {
//			System.out.println("실행 중");
//			if (Thread.interrupted()) {
//				break;
//			}
//		}
//		System.out.println("마무리 작업");
	}
}