package algorithm01.chapter6;

public class FloydWarshall {

	public final static int INF_NUM = Integer.MAX_VALUE;

	public static void floyd(int[][] e, int n) {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// e[i][k] + e[k][j] < e[i][j] 为了防止超过整数的范围溢出，所以写成
					// e[i][k] < e[i][j] - e[k][j] 
					if (e[i][k] < INF_NUM && e[k][j] < INF_NUM && e[i][k] < e[i][j] - e[k][j]) {
						e[i][j] = e[i][k] + e[k][j];
					}
				}
			}
		}
	}
}
 