public class StudentTest {
	public static void insertStudent() {
		StudentDAO dao = new StudentDAO();
		dao.insertStudent(new StudentDTO(3,"���浿","�����а�","����","010-3333-3333"));
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