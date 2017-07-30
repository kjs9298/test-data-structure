import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by jisukim on 2017. 7. 30..
 */
public class LinearTest {

	@Test
	public void arrayCopy() {
		int[] integers = {0, 1, 2, 3, 4};

		int[] newIntegers = new int[integers.length + 1];
		System.arraycopy(integers, 0, newIntegers, 0, integers.length);
		integers = newIntegers;
		integers[5] = 5;

		Assert.assertEquals(5, integers[5]);
	}

	@Test
	public void QueueTest() {
		Queue<String> queue = new LinkedList<>();

		queue.add("first");
		queue.add("second");
		queue.add("third");

		Assert.assertEquals("first", queue.peek());
		Assert.assertEquals("first", queue.remove());
		Assert.assertEquals("second", queue.remove());
		Assert.assertEquals("third", queue.remove());
	}


	@Test
	public void DequeTest() {
		Deque<String> deque = new LinkedList<>();

		deque.add("second");
		deque.add("third");
		deque.addFirst("first");

		Assert.assertEquals("first", deque.peek());
		Assert.assertEquals("first", deque.remove());
		Assert.assertEquals("second", deque.remove());
		Assert.assertEquals("third", deque.remove());
	}

	// Are linked lists considered linear or non-linear data structures?
}
