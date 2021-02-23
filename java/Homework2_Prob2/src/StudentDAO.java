import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	Connection conn;
	
	public StudentDAO() {
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
	
	public void insertStudent(StudentDTO studentDTO) {
		String sql = "insert into student values (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentDTO.getNo());
			pstmt.setString(2, studentDTO.getName());
			pstmt.setString(3, studentDTO.getDet());
			pstmt.setString(4, studentDTO.getAddr());
			pstmt.setString(5, studentDTO.getTel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void printAllStudents() {
		String sql = "select * from student";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setNo(rs.getInt(1));
				studentDTO.setName(rs.getString(2));
				studentDTO.setDet(rs.getString(3));
				studentDTO.setAddr(rs.getString(4));
				studentDTO.setTel(rs.getString(5));
				System.out.println(studentDTO.toString());
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
	}
}