package emp;

public abstract class Employee {
	String id;
	String name;
	
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	abstract public int getPay();
//	public void setPay(int pay) {
//		this.pay = pay;
//	}

	public String info() {
		return "사번:" + id + ", 이름:" + name;
	}
	
}