import java.util.ArrayList;

import dao.TMemberDAO;
import dto.TMemberDTO;

public class TMemberTest {

	public static void main(String[] args) {
		
		// ��� ��ȸ
		TMemberDAO dao = new TMemberDAO();
		TMemberDTO member = dao.queryTMember("kim");
		if (member!=null) {
			System.out.println(member);
		} else {
			System.out.println("��ȸ ����");
		}
		
		// ��ü ��ȸ
//		TMemberDAO dao = new TMemberDAO();
//		ArrayList<TMemberDTO> mlist = dao.queryTMembers();
//		for (TMemberDTO m : mlist) {
//			System.out.println(m);
//		}
		
		// ������ ����
//		TMemberDAO dao = new TMemberDAO();
//		int rcnt = dao.insertTMember(new TMemberDTO("yoo","1212","���缮","yoo@naver.com","21/02/18"));
//		if (rcnt>0) {
//			System.out.println("���� ����");
//		} else {
//			System.out.println("���� ����");
//		}
		
		// ����
//		TMemberDAO dao = new TMemberDAO();
//		int rcnt = dao.updateTMemberPwd("yoo", "3434");
//		if (rcnt > 0) {
//			System.out.println("���� ����");
//		} else {
//			System.out.println("���� ����");
//		}
		
		// ����
//		TMemberDAO dao = new TMemberDAO();
//		int rcnt = dao.deleteTMember("yoo");
//		if (rcnt > 0) {
//			System.out.println("���� ����");
//		} else {
//			System.out.println("���� ����");
//		}
	}
}