package sec02;

import java.util.ArrayList;

public class ArrayListObjExample {

	public static void main(String[] args) {
		ArrayList<Korean> kors = new ArrayList<Korean>();
		Korean k = new Korean("121212","lee","incheon");
		kors.add(k);
		kors.add(new Korean("131313","kim","seoul"));
		kors.add(new Korean("141414","park","busan"));
		kors.remove(k);
	}
}
