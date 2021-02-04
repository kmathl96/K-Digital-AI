import java.awt.Toolkit;

public class BeepThread extends Thread { // 다른 클래스의 기능을 상속 받을 수 없음 (단일 상속만 가능)

	@Override
	public void run() {
		super.run();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<5; i++) {
			toolkit.beep();
			try { Thread.sleep(500);} catch (Exception e) {}
		}
	}
	
}
