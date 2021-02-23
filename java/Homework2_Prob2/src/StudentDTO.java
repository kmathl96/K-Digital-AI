public class StudentDTO {
	int no;
	String name;
	String det;
	String addr;
	String tel;
	
	public StudentDTO() {}
	public StudentDTO(int no, String name, String det, String addr, String tel) {
		this.no = no;
		this.name = name;
		this.det = det;
		this.addr = addr;
		this.tel = tel;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDet() {
		return det;
	}
	public void setDet(String det) {
		this.det = det;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + det + "\t" + addr + "\t" + tel;
	}
}