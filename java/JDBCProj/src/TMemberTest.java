import java.util.ArrayList;

import dao.TMemberDAO;
import dto.TMemberDTO;

public class TMemberTest {

	public static void main(String[] args) {
		
		// 멤버 조회
		TMemberDAO dao = new TMemberDAO();
		TMemberDTO member = dao.queryTMember("kim");
		if (member!=null) {
			System.out.println(member);
		} else {
			System.out.println("조회 실패");
		}
		
		// 전체 조회
//		TMemberDAO dao = new TMemberDAO();
//		ArrayList<TMemberDTO> mlist = dao.queryTMembers();
//		for (TMemberDTO m : mlist) {
//			System.out.println(m);
//		}
		
		// 데이터 삽입
//		TMemberDAO dao = new TMemberDAO();
//		int rcnt = dao.insertTMember(new TMemberDTO("yoo","1212","유재석","yoo@naver.com","21/02/18"));
//		if (rcnt>0) {
//			System.out.println("삽입 성공");
//		} else {
//			System.out.println("삽입 실패");
//		}
		
		// 갱신
//		TMemberDAO dao = new TMemberDAO();
//		int rcnt = dao.updateTMemberPwd("yoo", "3434");
//		if (rcnt > 0) {
//			System.out.println("갱신 성공");
//		} else {
//			System.out.println("갱신 실패");
//		}
		
		// 삭제
//		TMemberDAO dao = new TMemberDAO();
//		int rcnt = dao.deleteTMember("yoo");
//		if (rcnt > 0) {
//			System.out.println("삭제 성공");
//		} else {
//			System.out.println("삭제 실패");
//		}
	}
}