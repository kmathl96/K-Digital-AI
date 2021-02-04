
public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}
	// synchronized : 하나의 스레드가 호출하면 다른 스레드는 이미 실행되고 있는 스레드가 끝날 때까지 대기함
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName()+":"+this.memory);
	}
}