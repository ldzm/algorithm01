package algorithm01.chapter5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * input:5 5
1 2
1 3
1 5
2 4
3 5

output : 1 2 3 5 4 
 * @author ldzm
 *
 */
public class GraphBfs {

	private int[] book;
	private int sum;
	private int n;
	private int[][] e;

	public GraphBfs() {
		book = new int[101];
		e = new int[101][101];
	}

	public void bfs(int cur) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(cur);
		book[cur] = 1;
		sum = 1;
		while(!queue.isEmpty()) {
			for (int i = 1; i <= n; i++) {
				cur = queue.peek();
				if (e[cur][i] == 1 && book[i] == 0) {
					book[i] = 1;
					sum++;
					queue.offer(i);
				}
				
				if(sum > n) {
					break;
				}
			}
			
			System.out.print(queue.poll() + " ");
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		GraphBfs graphDfs = new GraphBfs();
		graphDfs.n = in.nextInt();
		int m = in.nextInt();

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

		graphDfs.book[1] = 1;
		graphDfs.bfs(1);
	}
}
