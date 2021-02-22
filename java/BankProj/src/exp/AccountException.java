package exp;

public class AccountException extends java.lang.Exception {
	BankExpCode errCode;
	public AccountException() {
		super("���� ����");
	}
	public AccountException(String message) {
		super(message);
	}
	public AccountException(String messsage, BankExpCode errCode) {
		super(messsage);
		this.errCode = errCode;
	}
	public AccountException(BankExpCode errCode) {
		super("���� ����");
		this.errCode = errCode;
	}
	public BankExpCode getErrCode() {
		return errCode;
	}
	public void setErrCode(BankExpCode errCode) {
		this.errCode = errCode;
	}
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		switch(errCode) {
		case NOT_ACC: msg += ":���¹�ȣ�� Ʋ���ϴ�."; break;
		case EXIST_ACC: msg += ":�̹� �����ϴ� ���¹�ȣ�Դϴ�."; break;
		case WITHDRAW: msg += ":�ܾ��� �����մϴ�."; break;
		case DEPOSIT: msg += ":�Աݾ��� �߸� �Ǿ����ϴ�."; break;
		case MAIN_MENU: msg += ":0~5�� ���� �����մϴ�."; break;
		case ACC_MENU: msg += ":1~2�� ���� �����մϴ�."; break;
		case LIST_MENU: msg += ":1~3�� ���� �����մϴ�."; break;
		}
		return msg;
	}
}
