package com.err;

public class AccountException extends Exception {
	BankErrCode errCode;
	public AccountException() {
		super("계좌 오류");
	}
	public AccountException(String message) {
		super(message);
	}
	public AccountException(String message, BankErrCode errCode) {
		super(message);
		this.errCode = errCode;
	}
	public AccountException(BankErrCode errCode) {
		super("계좌 오류");
		this.errCode = errCode;
	}
	@Override
	public String toString() {
		String msg = super.getMessage()+" : ";
		switch(errCode) {
		case NOT_ACC: msg += "계좌번호 오류입니다."; break;
		case EXIST_ACC: msg += "사용할 수 없는 계좌번호입니다."; break;
		case NO_DATA: msg += "개설된 계좌가 없습니다."; break;
		case LACK_BALANCE: msg += "잔액이 부족합니다."; break;
		case FAIL_MAKE: msg += "계좌 개설을 실패했습니다."; break;
		case FAIL_DEPOSIT: msg += "입금을 실패했습니다."; break;
		case FAIL_WITHDRAW: msg += "출금을 실패했습니다."; break;
		}
		return msg;
	}
}