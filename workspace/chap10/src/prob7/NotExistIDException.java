package prob7;

public class NotExistIDException extends Exception {

	public NotExistIDException() {}
	public NotExistIDException(String message) {
		super(message); // getMessage()로 호출하면 message가 반환됨
	}
}
