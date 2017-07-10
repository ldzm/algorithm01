package algorithm01.chapter4;

public class Dfs {

	public static int minnum = Integer.MAX_VALUE;
	void dfs(int step, int[] a, int[] book, int n) {
		if (step == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(a[i] + 1);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (book[i] == 0) {
				a[step] = i;
				book[i] = 1;
				dfs(step + 1, a, book, n);
				book[i] = 0;
			}

		}

		return;
	}

	void dfs(int step, int x, int y, int p, int q, int m, int n, int[][] a, int[][] book) {
		int[][] next =
		{
				{ 0, 1 }, // right
				{ 1, 0 }, // down
				{ 0, -1 }, // left
				{ -1, 0 } // up
		};

		if (x == p && y == q) {
			if (step < minnum) {
				minnum = step;
			}
			return;
		}

		for (int k = 0; k < 4; k++) {
			int tx = x + next[k][0];
			int ty = y + next[k][1];
			if (tx < 1 || tx > n || ty < 1 || ty > m) {
				continue;
			}
			if (0 == a[tx][ty] && 0 == book[tx][ty]) {
				book[tx][ty] = 1;
				dfs(step + 1, tx, ty, p, q, m, n, a, book);
				book[tx][ty] = 0;
			}
		}
		return;
	}

	public static void main(String[] args) {

		// 1
		int[] a =
		{ 1, 2, 3 };
		int[] book = new int[3];
		new Dfs().dfs(0, a, book, 3);

		// 2

		int a2[][] =
		{
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 }, };

		int book2[][] = new int[51][51];
		
		int n = 5;
		int m = 4;
		
		int startx = 1, starty = 1;
		int p = 4;
		int q = 3;
		book2[startx][starty] = 1;
		
		new Dfs().dfs(0, startx, starty, p, q, m, n, a2, book2);

		System.out.println(minnum);
	}
}
