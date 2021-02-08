class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("MyRun");
	}
}

public class RunTest {

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("������ ����");
			}
		}).start();
		
		new Thread(()->{System.out.println("������ ����");}).start();
		
		MyThread my = new MyThread();
		my.start();
	}
}