package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Account;
import dto.SpecialAccount;

public class AccountDAO {
	Connection conn;
	
	public AccountDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void connectClose() {
		try {
			if (conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int insertAccount(Account acc) {
		String sql = "insert into Account values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int rcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			if (acc instanceof SpecialAccount) {
				pstmt.setString(4, ((SpecialAccount) acc).getGrade());
			} else {
				pstmt.setString(4, null);
			}
			rcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rcnt;
	}
	public Account queryAccount(String id) {
		String sql = "select * from account where id=?";
		PreparedStatement pstmt = null;
		Account acc = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String grade = rs.getString(4);
				if (grade==null) {
					acc = new Account();
				} else {
					acc = new SpecialAccount();
					((SpecialAccount) acc).setGrade(grade);
				}
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acc;
	}
	public ArrayList<Account> queryAllAccounts() {
		String sql = "select * from account";
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Account> accs = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String grade = rs.getString(4);
				Account acc;
				if (grade==null) {
					acc = new Account();
				} else {
					acc = new SpecialAccount();
					((SpecialAccount) acc).setGrade(grade);
				}
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
				accs.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accs;
	}
	public ArrayList<Account> queryAccounts(){
		String sql = "select * from account where grade is null";
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Account> accs = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
				accs.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accs;
	}
	public ArrayList<SpecialAccount> querySpecialAccounts(){
		String sql = "select * from account where grade is not null";
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<SpecialAccount> accs = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SpecialAccount acc = new SpecialAccount();
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
				acc.setGrade(rs.getString(4));
				accs.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accs;
	}
	public boolean depositAccount(String id, int money) {
		Account acc = queryAccount(id);
		if (acc==null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return false;
		}
		boolean success = acc.deposit(money);
		if (success==false) {
			System.out.println("입금액이 틀립니다.");
			return false;
		}
		int rcnt = updateAccount(acc);
		if (rcnt > 0) return true;
		else return false;
	}
	public boolean withdrawAccount(String id, int money) {
		Account acc = queryAccount(id);
		if (acc==null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return false;
		}
		boolean success = acc.withdraw(money);
		if (success==false) {
			System.out.println("출금액이 틀립니다.");
			return false;
		}
		int rcnt = updateAccount(acc);
		if (rcnt > 0) return true;
		else return false;
	}
	
	public int updateAccount(Account acc) {
		String sql = "update account set balance=? where id=?";
		PreparedStatement pstmt = null;
		int rcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			rcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rcnt;
	}
	public boolean transferAccount(String sid, String rid, int money) {
		try {
			conn.setAutoCommit(false); // 자동 커밋하지 않도록
			boolean success = withdrawAccount(sid, money);
			if (success==false) {
				conn.rollback();
				return false;
			}
			success = depositAccount(rid, money);
			if (success==false) {
				conn.rollback();
				return false;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true); // 다시 변경
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}