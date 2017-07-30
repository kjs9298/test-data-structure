import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jisukim on 2017. 7. 30..
 */
public class SearchingTest {

	@Test
	public void binarySearchTest () {
		List<Integer> numbers = Arrays.asList(5, 7, 3, 17, 3, 2, 4, 6, 45, 8);
		Collections.sort(numbers);

		Assert.assertTrue(this.binarySearch(numbers, 45));
		Assert.assertFalse(this.binarySearch(numbers, 1));
		Assert.assertFalse(this.binarySearch(numbers, 50));
	}

	private boolean binarySearch(List<Integer> numbers, int target) {

		if(numbers.isEmpty()) {
			return false;
		}

		int midIdx = numbers.size()/2;
		int midVal = numbers.get(midIdx);

		if(target == midVal) {
			return true;
		} else if(target < midVal) {
			return binarySearch(numbers.subList(0, midIdx), target);
		} else {
			return binarySearch(numbers.subList(midIdx + 1, numbers.size()), target);
		}
	}
}
