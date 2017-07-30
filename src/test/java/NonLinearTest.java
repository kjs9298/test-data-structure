import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by jisukim on 2017. 7. 30..
 */
public class NonLinearTest {

	@Test
	public void treeMapTraversalTest() {
		Map<Integer, String> counts = new TreeMap<>();
		counts.put(4, "meat");
		counts.put(3, "chicken");
		counts.put(1, "beef");
		counts.put(2, "beer");

		Iterator<Integer> keys = counts.keySet().iterator();
		Assert.assertEquals(Integer.valueOf(1), keys.next());
		Assert.assertEquals(Integer.valueOf(2), keys.next());
		Assert.assertEquals(Integer.valueOf(3), keys.next());
		Assert.assertEquals(Integer.valueOf(4), keys.next());
	}

	// Does not it maintain the order of elements using hashMap?

	@Test
	public void hashMapTraversalTest() {
		Map<Integer, String> counts = new HashMap<>();
		counts.put(4, "meat");
		counts.put(3, "chicken");
		counts.put(1, "beef");
		counts.put(2, "beer");

		System.out.println("before removing : " + counts);

		counts.remove(2);

		System.out.println("after removing : " + counts);

	}

	@Test
	public void linkedHashMapTraversalTest() {
		Map<Integer, String> counts = new LinkedHashMap<>();
		counts.put(4, "meat");
		counts.put(3, "chicken");
		counts.put(1, "beef");
		counts.put(2, "beer");

		Iterator<Integer> keys = counts.keySet().iterator();
		Assert.assertEquals(Integer.valueOf(4), keys.next());
		Assert.assertEquals(Integer.valueOf(3), keys.next());
		Assert.assertEquals(Integer.valueOf(1), keys.next());
		Assert.assertEquals(Integer.valueOf(2), keys.next());
	}

	@Test
	public void treeSetTraversalTest() {
		Set<String> set = new TreeSet<>();

		set.add("e");
		set.add("a");
		set.add("d");
		set.add("b");
		set.add("c");

		Iterator<String> it = set.iterator();
		Assert.assertEquals("a", it.next());
		Assert.assertEquals("b", it.next());
		Assert.assertEquals("c", it.next());
		Assert.assertEquals("d", it.next());
		Assert.assertEquals("e", it.next());

	}

	@Test
	public void linkedSetTraversalTest() {
		Set<String> set = new LinkedHashSet<>();

		set.add("e");
		set.add("a");
		set.add("d");
		set.add("b");
		set.add("c");

		Iterator<String> it = set.iterator();
		Assert.assertEquals("e", it.next());
		Assert.assertEquals("a", it.next());
		Assert.assertEquals("d", it.next());
		Assert.assertEquals("b", it.next());
		Assert.assertEquals("c", it.next());
	}

}
