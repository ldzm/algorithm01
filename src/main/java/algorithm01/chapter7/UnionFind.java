package algorithm01.chapter7;

public class UnionFind {

	private int n; // 强盗的个数
	private int m; // 证据的个数
	private int[] f;

	public UnionFind() {
		n = 0;
		m = 0;
	}

	public UnionFind(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public int unionFind(int[] v, int[] u) {

		init();
		int sum = 0;

		for (int i = 0; i < m; i++) {
			merge(v[i], u[i]);
		}

		for (int i = 1; i <= n; i++) {
			if (i == f[i]) {
				sum++;
			}
		}
		return sum;
	}

	private void init() {
		f = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			f[i] = i;
		}
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

	private void merge(int v, int u) {
		int t1 = getf(v);
		int t2 = getf(u);

		if (t1 != t2) {
			f[t2] = t1;
		}
	}
}
