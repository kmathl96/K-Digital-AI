package prob7;

public class NotExistIDException extends Exception {

	public NotExistIDException() {}
	public NotExistIDException(String message) {
		System.out.println(message);
	}
}
