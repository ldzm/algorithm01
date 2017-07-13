package algorithm01.chapter7;


import java.lang.reflect.Array;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HeapSortTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public HeapSortTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(HeapSortTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testHeapSort() {

		// 第一个元素不用，从索引为1开始使用
		int [] heap = {0, 99, 5, 36, 7, 22, 17, 46, 12, 2, 19, 25, 28, 1, 92};
		int [] result = {0, 1, 2, 5, 7, 12, 17, 19, 22, 25, 28, 36, 46, 92, 99};
		HeapSort heapSort = new HeapSort(heap.length - 1);
		heapSort.sort(heap);
		
		assertTrue(Arrays.equals(heap, result));
	}
	
	public void testHeapSort2() {

		// 第一个元素不用，从索引为1开始使用
		int [] heap = {0, 99, 5, 36, 7, 22, 17, 46, 12, 2, 19, 25, 28, 1, 92};
		int [] result = {0, 99, 92, 46, 36, 28, 25, 22, 19, 17, 12, 7, 5, 2, 1};
		HeapSort heapSort = new HeapSort(heap.length - 1);
		heapSort.sort2(heap);
		
		assertTrue(Arrays.equals(heap, result));
	}
}
