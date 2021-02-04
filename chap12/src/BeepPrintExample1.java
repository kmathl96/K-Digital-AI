public class BeepPrintExample1 {

	public static void main(String[] args) {
//		Thread thread = new Thread(new BeepTask());
		Thread thread = new BeepThread();
		thread.start();
		for (int i=0; i<5; i++) {
			System.out.println("BEEP");
			try { Thread.sleep(500);} catch (Exception e) {}
		}
	}

}
