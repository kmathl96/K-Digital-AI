class Parent {
	int pnum;
	public Parent() {}
	public Parent(int pnum) {
		this.pnum = pnum;
	}
	public void method() {
		
	}
	public void method1() {
		
	}
}

class Child extends Parent {
	int cnum;

	public Child() {}
	public Child(int pnum, int cnum) {
		super(pnum); // �θ� ������ ȣ��
		this.cnum = cnum;
	}

	@Override
	public void method() {
		super.method();
	}
	
	public void method2() {
		method1(); // super.method1()�� �ᵵ �� (���� �� �������)
	}
}

public class InheritSample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
