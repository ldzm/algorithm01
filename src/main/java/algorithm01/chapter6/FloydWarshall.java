package algorithm01.chapter6;

public class FloydWarshall {

	public final static int INF_NUM = Integer.MAX_VALUE / 2;

	public static void floyd(int[][] e, int n) {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (e[i][k] < INF_NUM && e[k][j] < INF_NUM && e[i][k] + e[k][j] < e[i][j]) {
						e[i][j] = e[i][k] + e[k][j];
					}
				}
			}
		}
	}
}
 