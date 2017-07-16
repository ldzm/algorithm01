package algorithm01.chapter8;

public class Kruskal {

	public class Edge {
		int u;
		int v;
		int w;

		public Edge(int u, int v, int w) {

			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	private int n;
	private int m;
	private int[] f;

	// n个城市，m条路
	public Kruskal(int n, int m) {
		this.n = n;
		this.m = m;
		f = new int[n + 1];
	}

	public int kruskal(int[] u, int[] v, int[] w) {

		Edge[] edges = new Edge[m + 1];

		for (int i = 1; i <= n; i++) {
			f[i] = i;
		}

		for (int i = 1; i <= m; i++) {
			edges[i] = new Edge(u[i], v[i], w[i]);
		}

		quickSort(edges, 1, m);

		int sum = 0;
		int count = 0;
		for (int i = 1; i <= m; i++) {
			if (merge(edges[i].u, edges[i].v)) {
				count++;
				sum += edges[i].w;
			}

			if (count == n - 1) {
				break;
			}
		}

		return sum;

	}

	public void quickSort(Edge[] src, int left, int right) {

		if (left > right) {
			return;
		}

		Edge flag = src[left];
		int i = left;
		int j = right;

		while (i != j) {
			while (src[j].w >= flag.w && i < j) {
				j--;
			}
			while (src[i].w <= flag.w && i < j) {
				i++;
			}

			if (i < j) {
				swap(src, i, j);
			}
		}

		src[left] = src[i];
		src[i] = flag;

		quickSort(src, left, i - 1);
		quickSort(src, i + 1, right);

	}

	private int getf(int v) {
		if (v == f[v]) {
			return v;
		} else {
			// 压缩路径
			f[v] = getf(f[v]);
			return f[v];
		}
	}

	private boolean merge(int v, int u) {
		int t1 = getf(v);
		int t2 = getf(u);

		if (t1 != t2) {
			f[t2] = t1;
			return true;
		}

		return false;
	}

	private void swap(Edge[] src, int i, int j) {
		Edge tmp = src[i];
		src[i] = src[j];
		src[j] = tmp;
	}
}
