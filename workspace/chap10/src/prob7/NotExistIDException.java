package prob7;

public class NotExistIDException extends Exception {

	public NotExistIDException() {}
	public NotExistIDException(String message) {
		super(message); // getMessage()�� ȣ���ϸ� message�� ��ȯ��
	}
}
