enum BankExpCode {NOT_ACC, EXIST_ACC, WITHDRAW, DEPOSIT, MAIN_MENU, ACC_MENU};
class AccountException extends Exception {
	// ���¹�ȣ�� Ʋ���ϴ�.
	// �ߺ� �����Դϴ�.
	// �ܾ��� �����մϴ�.
	// �Աݾ��� �߸� �Ǿ����ϴ�.
	// 0���� 5������ ������ �����մϴ�.
	// 1, 2�� ������ �����մϴ�.
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
		case MAIN_MENU: msg += ":0���� 5������ ������ �����մϴ�."; break;
		case ACC_MENU: msg += ":1, 2�� ������ �����մϴ�."; break;
		}
		return msg;
	}
}
public class AccountExceptionTest {
	public static void errNotAcc() throws AccountException {
		throw new AccountException(BankExpCode.NOT_ACC);
	}
	public static void errExistAcc() throws AccountException {
		throw new AccountException(BankExpCode.EXIST_ACC);
	}
	public static void main(String[] args) {
		try {
//			errNotAcc();
			errExistAcc();
		} catch (AccountException e) {
			if (e.getErrCode()==BankExpCode.ACC_MENU) {
				
			}
			System.out.println(e.getMessage());
		}
	}

}
