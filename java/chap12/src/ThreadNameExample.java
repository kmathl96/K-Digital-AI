
public class ThreadNameExample {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		Thread thread1 = new ThreadA();
		System.out.println(thread1.getName());
		thread1.start();
		
		Thread thread2 = new ThreadB();
		System.out.println(thread2.getName());
		thread2.start();
	}
}