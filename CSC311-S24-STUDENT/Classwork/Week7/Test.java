package Week7;

import com.usman.csudh.csc311.datastructures.QueueEmptyException;
import com.usman.csudh.csc311.datastructures.StackEmptyException;

public class Test {

	public static void main(String[] args) throws StackEmptyException, QueueEmptyException {
		LinkedQueue test = new LinkedQueue();
		test.add(6);
		test.add(5);
		test.add(7);
		test.add(7);
		test.add(7);
		System.out.println(test);
		System.out.println(test.remove());
		System.out.println(test);
		test.add(7);
		System.out.println(test.isEmpty());
	}

}
