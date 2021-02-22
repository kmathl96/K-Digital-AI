import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr"); // DB와 연결
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from t_member");
			while (rset.next()) {
				String id = rset.getString("id");
				String name=rset.getString("name");
				System.out.println("id:"+id+", name:"+name)
;			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn!=null) conn.close();
				if(stmt!=null) stmt.close();
				if(rset!=null) rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
 	}
}