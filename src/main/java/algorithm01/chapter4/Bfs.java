package algorithm01.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Bfs {

	private class Node {
		int x;
		int y;
		int s;

		public Node(int x, int y, int s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}

	void bfs() {

		int a[][] =
		{
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 }, };

		int book[][] = new int[51][51];
		int[][] next =
		{
				{ 0, 1 }, // right
				{ 1, 0 }, // down
				{ 0, -1 }, // left
				{ -1, 0 } // up
		};
		int n = 5;
		int m = 4;

		int startx = 1;
		int starty = 1;
		int p = 4;
		int q = 3;

		Deque<Node> queue = new ArrayDeque<Bfs.Node>();
		// insert
		Node newNode = new Node(startx, starty, 0);
		queue.offer(newNode);

		book[startx][starty] = 1;

		dfs_lable: 
		while (!queue.isEmpty()) {
			Node current = queue.poll(); 
			
			/**
			if (current.x == 4 && current.y == 4) {
				System.out.println("");
			}
			if (current.x == 5 && current.y == 3) {
				System.out.println("");
			}*/

			for (int k = 0; k < 4; k++) {
				int tx = current.x + next[k][0];
				int ty = current.y + next[k][1];
				if (tx < 1 || tx > n || ty < 1 || ty > m) {
					continue;
				}

				if (0 == a[tx][ty] && 0 == book[tx][ty]) {
					book[tx][ty] = 1;
					Node node = new Node(tx, ty, current.s + 1);
					queue.offer(node);
				}

				if (tx == p && ty == q) {
					break dfs_lable;
				}
			}
		}

		// 获取队尾的数据
		System.out.println(queue.pollLast().s);
	}

	public static void main(String[] args) {

		new Bfs().bfs();
	}
}
