package algorithm01.chapter5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * input: 5 7 1 5 1 2 1 3 2 3 2 4 3 4 3 5 4 5 output : 2
 * 
 * @author ldzm
 *
 */
public class GraphBfs2 {

	private int[] book;
	private int n;
	private int[][] e;

	private class Node {
		int x;
		int s;

		public Node(int x, int s) {
			this.x = x;
			this.s = s;
		}
	}

	public GraphBfs2() {
		book = new int[101];
		e = new int[101][101];
	}

	public void bfs(int from, int to) {

		Deque<Node> queue = new ArrayDeque<Node>();
		queue.offer(new Node(from, 0));
		book[from] = 1;

		bsf_lable: 
		while (!queue.isEmpty()) {
			for (int i = 1; i <= n; i++) {
				Node cur = queue.peek();
				if (e[cur.x][i] == 1 && book[i] == 0) {
					book[i] = 1;
					queue.offer(new Node(i, cur.s + 1));
				}

				if (cur.x == to) {
					break bsf_lable;
				}
			}
			queue.poll();
		}

		System.out.println(queue.getLast().s);
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		GraphBfs2 graphDfs = new GraphBfs2();
		graphDfs.n = in.nextInt();
		int m = in.nextInt();

		int from = in.nextInt();
		int to = in.nextInt();

		for (int i = 1; i <= graphDfs.n; i++) {
			for (int j = 1; j <= graphDfs.n; j++) {
				if (i == j) {
					graphDfs.e[i][j] = 0;
				} else {
					graphDfs.e[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		// 读入顶点
		for (int i = 1; i <= m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			graphDfs.e[a][b] = 1;
			graphDfs.e[b][a] = 1;
		}

		graphDfs.book[from] = 1;
		graphDfs.bfs(from, to);
	}
}
