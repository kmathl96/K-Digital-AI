public class InterfaceSample1 {

	public static void sayHello(MessageBean bean) {
		bean.sayHello("java");
	}
	
	public static void main(String[] args) {
//		MessageBean mb = new MessageBean(); // ��ü ���� �� ��
		MessageBean mb = new MessageBean_kr();
		mb.sayHello("java");
		sayHello(new MessageBean_kr());
	}
}
