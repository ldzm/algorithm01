package algorithm01.chapter6;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BellmanFordTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public BellmanFordTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(BellmanFordTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testFord() {

		int m = 8;
		int n = 4;
		int a[][] =
		{
				{ 1, 2, 2 },
				{ 1, 3, 6 },
				{ 3, 4, 1 },
				{ 4, 1, 5 },
				{ 1, 4, 4 },
				{ 2, 3, 3 },
				{ 3, 1, 7 },
				{ 4, 3, 12 } };

		int[] vx = new int[m + 1];
		int[] vy = new int[m + 1];
		int[] w = new int[m + 1];
		for (int i = 0; i < m; i++) {
			vx[i + 1] = a[i][0]; // 顶点x
			vy[i + 1] = a[i][1]; // 顶点y
			w[i + 1] = a[i][2]; // 顶点x到顶点y的权重
		}

		int[][] result =
		{
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 5, 4 },
				{ 0, 9, 0, 3, 4 },
				{ 0, 6, 8, 0, 1 },
				{ 0, 5, 7, 10, 0 }, };

		for (int i = 1; i <= n; i++) {
			int[] res = BellmanFord.ford(vx, vy, w, i, n, m);

			assertTrue(Arrays.equals(res, result[i]));
		}
	}

	public void testFord2() {

		int m = 8;
		int n = 4;
		int a[][] =
		{
				{ 1, 2, 2 },
				{ 1, 3, 6 },
				{ 3, 4, 1 },
				{ 4, 1, 5 },
				{ 1, 4, 4 },
				{ 2, 3, 3 },
				{ 3, 1, 7 },
				{ 4, 3, 12 } };

		int[] vx = new int[m + 1];
		int[] vy = new int[m + 1];
		int[] w = new int[m + 1];
		for (int i = 0; i < m; i++) {
			vx[i + 1] = a[i][0]; // 顶点x
			vy[i + 1] = a[i][1]; // 顶点y
			w[i + 1] = a[i][2]; // 顶点x到顶点y的权重
		}

		int[][] result =
		{
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 5, 4 },
				{ 0, 9, 0, 3, 4 },
				{ 0, 6, 8, 0, 1 },
				{ 0, 5, 7, 10, 0 }, };

		for (int i = 1; i <= n; i++) {
			int[] res = BellmanFord.ford2(vx, vy, w, i, n, m);

			assertTrue(Arrays.equals(res, result[i]));
		}
	}

	public void testFord3() {

		int m = 8;
		int n = 4;
		int a[][] =
		{
				{ 1, 2, 2 },
				{ 1, 3, 6 },
				{ 3, 4, 1 },
				{ 4, 1, 5 },
				{ 1, 4, 4 },
				{ 2, 3, 3 },
				{ 3, 1, 7 },
				{ 4, 3, 12 } };

		int[] vx = new int[m + 1];
		int[] vy = new int[m + 1];
		int[] w = new int[m + 1];

		int[] first = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			first[i] = -1;
		}
		int[] next = new int[m + 1];

		for (int i = 0; i < m; i++) {
			vx[i + 1] = a[i][0]; // 顶点x
			vy[i + 1] = a[i][1]; // 顶点y
			w[i + 1] = a[i][2]; // 顶点x到顶点y的权重

			next[i + 1] = first[vx[i + 1]];
			first[vx[i + 1]] = i + 1;
		}

		int[][] result =
		{
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 5, 4 },
				{ 0, 9, 0, 3, 4 },
				{ 0, 6, 8, 0, 1 },
				{ 0, 5, 7, 10, 0 }, };

		for (int i = 1; i <= n; i++) {
			int[] res = BellmanFord.ford3(vx, vy, w, first, next, i, n, m);

			assertTrue(Arrays.equals(res, result[i]));
		}
	}
}
