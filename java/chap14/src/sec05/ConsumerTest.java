package sec05;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<String> consumer = (t)->{ System.out.println(t+"11");};
		consumer.accept("Java"); // Java11
		
		BiConsumer<Integer, Integer> calc = (x,y)->{ System.out.println(x+y);};
		calc.accept(3,5); // 8
		
		BinaryOperator<Double> bo = (x,y)->x+y;
		System.out.println(bo.apply(3.14, 5.21));
		
		BiPredicate<String, String> bp = (x,y)->x.equals(y);
		System.out.println(bp.test("hong", "hong"));
		System.out.println(bp.test("bong", "pong"));
	}
}