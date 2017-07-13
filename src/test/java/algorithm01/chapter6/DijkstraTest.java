package algorithm01.chapter6;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DijkstraTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public DijkstraTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DijkstraTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testDijkstra() {

		int m = 8;
		int n = 4;
		int e[][] = new int[n + 1][n + 1];
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

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					e[i][j] = 0;
				} else {
					e[i][j] = Dijkstra.INF_NUM;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			int num1 = a[i][0];
			int num2 = a[i][1];
			e[num1][num2] = a[i][2];
		}

		int[][] result =
		{
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 5, 4 },
				{ 0, 9, 0, 3, 4 },
				{ 0, 6, 8, 0, 1 },
				{ 0, 5, 7, 10, 0 }, };

		for (int i = 1; i <= n; i++) {
			int[] res = Dijkstra.dijkstra(e, i, n);
			assertTrue(Arrays.equals(res, result[i]));
		}
	}
}
