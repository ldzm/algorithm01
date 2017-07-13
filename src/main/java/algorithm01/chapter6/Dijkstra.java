package algorithm01.chapter6;

public class Dijkstra {
	public final static int INF_NUM = Integer.MAX_VALUE / 2;

	private class Edge {
		public int x;
		int y;
		int w;
		public Edge(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	/**
	 * 点u到其他点的最短距离
	 * @param e
	 * @param u
	 * @param n
	 */
	public static int[] dijkstra(int[][] e, int u, int n) {

		int[] dis = new int[n + 1];
		int[] book = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dis[i] = e[u][i];
			book[i] = 0;
		}

		book[u] = 1;
		for (int i = 1; i <= n - 1; i++) {
			int min = INF_NUM;
			for (int j = 1; j <= n; j++) {
				if (0 == book[j] && dis[j] < min) {
					min = dis[j];
					u = j;
				}
			}

			book[u] = 1;
			for (int k = 1; k <= n; k++) {
				if (e[u][k] < INF_NUM) {
					if (dis[k] > dis[u] + e[u][k]) {
						dis[k] = dis[u] + e[u][k];
					}
				}
			}
		}
		
		return dis;
	}
	
	/**
	 * 点u到其他点的最短距离
	 * 堆优化
	 * 我们使用jdk提供的优先队列
	 * @param e
	 * @param u
	 * @param n
	 */
	public static int[] dijkstraHeap(Edge [] edges, int u, int n) {

		return null;
	}
}
