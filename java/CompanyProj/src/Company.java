import emp.Employee;
import emp.IBusinessTrip;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class Company {
	Employee[] emps = new Employee[100];
	static int empCnt;
	
	public void addEmployee(Employee emp) { // upcasting
		emps[empCnt++] = emp;
	}
	public void empList() {
		for (int i=0; i<Company.empCnt; i++) {
			System.out.println("사번:"+emps[i].getId()+", 이름:"+emps[i].getName()+", 급여:"+emps[i].getPay());
		}
	}
	public int getTotEmpPay() {
		int sum = 0;
		for (int i=0; i<Company.empCnt; i++) {
			sum += emps[i].getPay();
		}
		return sum;
	}
	
	public void regBusinessTrip(IBusinessTrip e, int day) {
		e.goBusinessTrip(day);			
	}
	
	public static void main(String[] args) {
		Company com = new Company();
		Permanent e1 = new Permanent("101","김과장",3000000);
		Sales e2 = new Sales("102","박대리",2000000,500000);
		PartTime e3 = new PartTime("103","홍차장",40,10000);
		com.addEmployee(e1);
		com.addEmployee(e2);
		com.addEmployee(e3);
		
		com.regBusinessTrip(e2,3); // 가능하게
		com.regBusinessTrip(e3,3); // 가능하게
		
		com.empList();
		System.out.println();
		System.out.println("총 급여액:"+com.getTotEmpPay());
	}
}