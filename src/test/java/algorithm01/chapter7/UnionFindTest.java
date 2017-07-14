package algorithm01.chapter7;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class UnionFindTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public UnionFindTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(UnionFindTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testUnionFind() {

		// 第一个元素不用，从索引为1开始使用
		int[] v =
		{ 1, 3, 5, 4, 2, 8, 9, 1, 2 };
		int[] u =
		{ 2, 4, 2, 6, 6, 7, 7, 6, 4 };
		
		UnionFind unionFind = new UnionFind(10, v.length);
		int result = unionFind.unionFind(v, u);

		assertEquals(3, result);
	}
}
