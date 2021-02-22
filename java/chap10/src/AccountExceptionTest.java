enum BankExpCode {NOT_ACC, EXIST_ACC, WITHDRAW, DEPOSIT, MAIN_MENU, ACC_MENU};
class AccountException extends Exception {
	// 계좌번호가 틀립니다.
	// 중복 계좌입니다.
	// 잔액이 부족합니다.
	// 입금액이 잘못 되었습니다.
	// 0부터 5까지만 선택이 가능합니다.
	// 1, 2만 선택이 가능합니다.
	BankExpCode errCode;
	public AccountException() {
		super("계좌 예외");
	}
	public AccountException(String message) {
		super(message);
	}
	public AccountException(String messsage, BankExpCode errCode) {
		super(messsage);
		this.errCode = errCode;
	}
	public AccountException(BankExpCode errCode) {
		super("계좌 오류");
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
		case NOT_ACC: msg += ":계좌번호가 틀립니다."; break;
		case EXIST_ACC: msg += ":이미 존재하는 계좌번호입니다."; break;
		case WITHDRAW: msg += ":잔액이 부족합니다."; break;
		case DEPOSIT: msg += ":입금액이 잘못 되었습니다."; break;
		case MAIN_MENU: msg += ":0부터 5까지만 선택이 가능합니다."; break;
		case ACC_MENU: msg += ":1, 2만 선택이 가능합니다."; break;
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
