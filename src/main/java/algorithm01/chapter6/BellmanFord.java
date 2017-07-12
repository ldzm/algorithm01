package algorithm01.chapter6;

import java.util.ArrayDeque;
import java.util.Queue;

public class BellmanFord {
	public final static int INF_NUM = Integer.MAX_VALUE;

	/**
	 * 点u到其他点的最短距离
	 * 
	 * 第i条边：顶点vx[i]到顶点vy[i]，权重是w[i]
	 * 
	 * @param vx
	 * @param vy
	 * @param w
	 * @param u
	 * @param n
	 *            顶点个数
	 * @param m
	 *            边的个数
	 * @return
	 */
	public static int[] ford(int[] vx, int[] vy, int[] w, int u, int n, int m) {

		int[] dis = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dis[i] = INF_NUM;
		}
		dis[u] = 0;

		for (int j = 1; j <= n - 1; j++) {

			for (int i = 1; i <= m; i++) {

				// dis[vy[i]] > dis[vx[i]] + w[i]
				if (dis[vy[i]] - dis[vx[i]] > w[i]) {
					dis[vy[i]] = dis[vx[i]] + w[i];
				}
			}
		}

		return dis;
	}

	/**
	 * 优化 添加一个一维数组用来备份数组dis。如果在一轮松弛之后dis没有发生变化，可以提前跳出循环
	 * 
	 * @param vx
	 * @param vy
	 * @param w
	 * @param u
	 * @param n
	 * @param m
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int[] ford2(int[] vx, int[] vy, int[] w, int u, int n, int m) {

		int[] dis = new int[n + 1];
		int[] back = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dis[i] = INF_NUM;
		}
		dis[u] = 0;

		ford2_label: for (int j = 1; j <= n - 1; j++) {

			for (int i = 1; i <= n; i++) {
				back[i] = dis[i];
			}

			for (int i = 1; i <= m; i++) {

				// dis[vy[i]] > dis[vx[i]] + w[i]
				if (dis[vy[i]] - dis[vx[i]] > w[i]) {
					dis[vy[i]] = dis[vx[i]] + w[i];
				}
			}

			for (int i = 1; i <= n; i++) {
				if (back[i] != dis[i]) {
					break;
				}

				break ford2_label;
			}
		}

		int flag = 0;

		for (int i = 1; i <= m; i++) {
			if (dis[vy[i]] - dis[vx[i]] > w[i]) {
				flag = 1;
			}
		}

		// flag == 1表明包含负权回路，没有最短路径
		if (flag == 1) {
			return null;
		}

		return dis;
	}

	/**
	 * 使用队列优化 添加一个一维数组用来备份数组dis。如果在一轮松弛之后dis没有发生变化，可以提前跳出循环
	 * 每次选取队首定点vx[i],对定点vx[i]所有出边进行松弛。
	 * 例如：vx[i]->vy[i],如果vx[i]->vy[i]这条边使得源点到顶点vy[i]的最短路径变短dis[vx[i]] + w[i] <
	 * dis[vy[i]], 且顶点vy[i]不在当前队列，就把顶带你vy[i]放入队尾
	 * 
	 * @return
	 */
	public static int[] ford3(int[] vx, int[] vy, int[] w, int[] first, int[] next, int u, int n, int m) {

		int[] dis = new int[n + 1];
		int[] book = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dis[i] = INF_NUM;
		}

		dis[u] = 0;

		for (int i = 1; i <= n; i++) {
			dis[i] = INF_NUM;
		}
		dis[u] = 0;

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(u);
		book[u] = 1; // 标记u号顶点已经入队

		while (!queue.isEmpty()) {
			int k = first[queue.peek()];
			while (k != -1) {
				// dis[vy[k]] > dis[vx[k]] + w[k] 判断是否松弛
				if (dis[vy[k]] - dis[vx[k]] > w[k]) {
					dis[vy[k]] = dis[vx[k]] + w[k];
					
					if (book[vy[k]] == 0) {// 0表示不在队列中，将vy{k]加入队列中
						queue.offer(vy[k]);
						book[vy[k]] = 1;
					}
				}

				k = next[k];
			}
			book[queue.poll()] = 0;// 出队后book对应的赋值为0
		}

		return dis;
	}
}
