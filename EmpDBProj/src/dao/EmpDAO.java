package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.EmpDTO;

public class EmpDAO {
	Connection conn;
	
	public EmpDAO() {
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
	
	public int insertEmp(EmpDTO emp) {
		String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int rcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setDouble(7, emp.getComm());
			pstmt.setDouble(8, emp.getDeptno());
			rcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rcnt;
	}
	
	public EmpDTO queryEmp(int empno) {
		String sql = "select * from emp where empno=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpDTO emp = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			emp = new EmpDTO();
			while (rs.next()) {
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
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
		return emp;
	}
	public ArrayList<EmpDTO> queryEmps(int deptno){
		String sql = "select * from emp where deptno=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpDTO> emps = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO emp = new EmpDTO();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
				emps.add(emp);
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
		return emps;
	}
	public ArrayList<EmpDTO> queryEmpsByDname(String dname){
		String sql = "select * from emp where deptno ="
				+ "(select deptno from dept where dname=?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpDTO> emps = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO emp = new EmpDTO();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
				emps.add(emp);
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
		return emps;
	}
	public ArrayList<EmpDTO> queryEmps(){
		String sql = "select * from emp";
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<EmpDTO> emps = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmpDTO emp = new EmpDTO();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
				emps.add(emp);
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
		return emps;
	}
	public int deleteEmp(int empno) {
		String sql = "delete from emp where empno=?";
		PreparedStatement pstmt = null;
		int rcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			// 물음표 개수만큼 set
			pstmt.setInt(1, empno);
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
}