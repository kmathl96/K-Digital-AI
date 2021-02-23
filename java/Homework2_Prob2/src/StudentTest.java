public class StudentTest {
	public static void insertStudent() {
		StudentDAO dao = new StudentDAO();
		dao.insertStudent(new StudentDTO(3,"나길동","영문학과","제주","010-3333-3333"));
	}
	public static void printAllStudents() {
		StudentDAO dao = new StudentDAO();
		dao.printAllStudents();
	}
	public static void main(String[] args) {
		insertStudent();
		printAllStudents();
	}
}