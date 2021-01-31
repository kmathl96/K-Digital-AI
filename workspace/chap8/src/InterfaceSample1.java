public class InterfaceSample1 {

	public static void sayHello(MessageBean bean) {
		bean.sayHello("java");
	}
	
	public static void main(String[] args) {
//		MessageBean mb = new MessageBean(); // °´Ã¼ »ý¼º ¾È µÊ
		MessageBean mb = new MessageBean_kr();
		mb.sayHello("java");
		sayHello(new MessageBean_kr());
	}
}
