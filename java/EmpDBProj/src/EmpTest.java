import java.util.List;

import dao.EmpDAO;
import dto.EmpDTO;

public class EmpTest {
	public static void insertEmp() {
		EmpDTO emp = new EmpDTO();
		emp.setEmpno(9000);
		emp.setEname("ADAMS");
		emp.setJob("RESEARCH");
		emp.setMgr(7839);
		emp.setSal(3000);
		emp.setDeptno(20);
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(emp);
		dao.connectClose();
	}
	public static void queryEmp() {
		EmpDAO dao = new EmpDAO();
		EmpDTO emp = dao.queryEmp(9000);
		dao.connectClose();
		System.out.println(emp.getEname());
	}
	public static void queryEmps() {
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> list = dao.queryEmps(20);
		dao.connectClose();
		for (EmpDTO emp : list) {
			System.out.println(emp.getEmpno()+":"+emp.getEname());
		}
	}
	public static void queryEmpsByDname() {
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> list = dao.queryEmpsByDname("RESEARCH");
		dao.connectClose();
		for (EmpDTO emp : list) {
			System.out.println(emp.getEmpno()+":"+emp.getEname());
		}
	}
	public static void queryAllEmps() {
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> list = dao.queryEmps();
		dao.connectClose();
		for (EmpDTO emp : list) {
			System.out.println(emp.getEmpno()+":"+emp.getEname());
		}
	}
	public static void deleteEmp() {
		EmpDAO dao = new EmpDAO();
		int rcnt = dao.deleteEmp(9000);
		dao.connectClose();
		if (rcnt > 0) System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
	}
	public static void main(String[] args) {
//		insertEmp();
//		queryEmp();
//		queryEmps();
//		queryAllEmps();
//		queryEmpsByDname();
		deleteEmp();
	}
}