import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by jisukim on 2017. 7. 30..
 */
public class SortingTest {

	// What is the difference between Comparator Comparable?

	@Test
	public void sortInts() {
		int[] numbers = {-3, -5, 1, 7, 4, -2};
		int[] expected = {-5, -3, -2, 1,4, 7};

		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@Test
	public void sortObjects() {
		String[] strings = {"z", "x", "y", "abc", "zzz","zazzy" };
		String[] expected = {"abc", "x", "y", "z","zazzy", "zzz"};

		Arrays.sort(strings);
		assertArrayEquals(expected, strings);
	}

	@Test
	public void bubbleSort() {
		int[] numbers = {6,4,9,5};
		int[] expected = {4,5,6,9};

		boolean switched = true;

		while (switched) {
			switched = false;

			for(int i = 0; i<numbers.length-1; ++i) {
				if(numbers[i+1] < numbers[i]) {
					int tmp = numbers[i+1];
					numbers[i+1] = numbers[i];
					numbers[i] = tmp;
					switched = true;
				}
			}
		}

		assertArrayEquals(numbers, expected);
	}

	// What is the difference between ArrayList and LinkedList?

	@Test
	public void insertSort() {
		List<Integer> numbers = Arrays.asList(5,4,7,11,2);
		List<Integer> sortedList = new LinkedList<>();


	}

	@Test
	public void recursiveSortTest() {
		List<Integer> numbers = Arrays.asList(5,4,7,11,2);
		List<Integer> expected = Arrays.asList(2,4,5,7,11);

		List<Integer> quickSorted = this.quickSort(numbers);

		assertEquals(expected, quickSorted);

		List<Integer> mergeSorted = this.mergeSort(numbers);

		assertEquals(expected, mergeSorted);

	}

	private List<Integer> quickSort(List<Integer> numbers) {
		if(numbers.size() < 2) {
			return numbers;
		}

		Integer pivot = numbers.get(0);
		List<Integer> lowers = new ArrayList<>();
		List<Integer> highers = new ArrayList<>();

		for(int i = 0; i<numbers.size(); ++i) {
			if(numbers.get(i) < pivot) {
				lowers.add(numbers.get(i));
			} else if(numbers.get(i) > pivot) {
				highers.add(numbers.get(i));
			}
		}

		List<Integer> sorted = quickSort(lowers);
		sorted.add(pivot);
		sorted.addAll(quickSort(highers));

		return sorted;
	}

	private List<Integer> mergeSort(List<Integer> numbers) {
		if(numbers.size() < 2) {
			return numbers;
		}

		int mid = numbers.size() / 2;
		List<Integer> lefts = numbers.subList(0, mid);
		List<Integer> rights = numbers.subList(mid, numbers.size());

		return this.merge(mergeSort(lefts), mergeSort(rights));
	}

	private List<Integer> merge(List<Integer> lefts, List<Integer> rights) {
		List<Integer> results = new ArrayList<>();

		int leftIdx = 0;
		int rightIdx = 0;

		while(leftIdx < lefts.size() && rightIdx < rights.size()) {
			if(lefts.get(leftIdx) < rights.get(rightIdx)) {
				results.add(lefts.get(leftIdx));
				leftIdx ++;
			} else {
				results.add(rights.get(rightIdx));
				rightIdx ++;
			}
		}

		while(leftIdx < lefts.size()) {
			results.add(lefts.get(leftIdx));
			leftIdx ++;
		}

		while(rightIdx < rights.size()) {
			results.add(rights.get(rightIdx));
			rightIdx ++;
		}


		return results;
	}

}
