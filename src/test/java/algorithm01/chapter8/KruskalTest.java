package algorithm01.chapter8;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class KruskalTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public KruskalTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(KruskalTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testKruskal() {

		// 第一个元素不用，从索引为1开始使用
		int n = 6;
		int m = 9;

		int[] u =
		{ 0, 2, 3, 4, 5, 2, 4, 1, 3, 1 };
		int[] v =
		{ 0, 4, 5, 6, 6, 3, 5, 2, 4, 3 };
		int[] w =
		{ 0, 11, 13, 3, 4, 6, 7, 1, 9, 2 };

		Kruskal kruskal = new Kruskal(n, m);
		int result = kruskal.kruskal(u, v, w);

		assertEquals(19, result);
	}
}
