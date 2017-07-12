package algorithm01.chapter6;

public class ArrayAdjacent {

	public static void main(String[] args) {

		int m = 8; // 边的条数
		int n = 4; // 顶点个数
		int vx[] = new int[m + 1];
		int vy[] = new int[m + 1];
		int w[] = new int[m + 1];

		int[] first = new int[n + 1]; // 顶点
		int[] next = new int[m + 1]; // 记录边

		// 初始化first数组小标1~n的值为-1，表示1~n顶点暂时没有边
		for (int i = 1; i <= n; i++) {
			first[i] = -1;
		}

		// m条边的数据
		int a[][] =
		{
				{ 3, 1, 7 },
				{ 3, 4, 1 },
				{ 4, 1, 5 },
				{ 1, 2, 2 },
				{ 1, 3, 6 },
				{ 1, 4, 4 },
				{ 2, 3, 3 },
				{ 4, 3, 12 } };

		for (int i = 0; i < m; i++) {
			vx[i + 1] = a[i][0]; // 顶点x
			vy[i + 1] = a[i][1]; // 顶点y
			w[i + 1] = a[i][2]; // 顶点x到顶点y的权重
		}

		for (int i = 1; i <= m; i++) {
			next[i] = first[vx[i]];
			first[vx[i]] = i;
		}

		// 找到1号顶点的每一条边
		int k = first[1];
		while (k != -1) {
			System.out.println(vx[k] + " " + vy[k] + " " + w[k]);
			k = next[k];
		}

		System.out.println("________________________________");
		for (int i = 1; i <= n; i++) {
			k = first[i];
			while (k != -1) {
				System.out.println(vx[k] + " " + vy[k] + " " + w[k]);
				k = next[k];
			}
		}
	}
}
