package algorithm01.chapter1;

public class Sort {

	public void bucketSort(int[] src) {

		// the default value is 0
		int[] bucket = new int[10];

		for (int i : src) {
			bucket[i] += 1;
		}

		int j = 0;
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] != 0) {
				for (int k = 0; k < bucket[i]; k++) {
					src[j++] = i;
				}
			}
		}
	}

	public void bubbleSort(int[] src) {

		for (int i = 0; i < src.length - 1; i++) {
			for (int j = 0; j < src.length - i - 1; j++) {
				if (src[j] > src[j + 1]) {
					swap(src, j, j + 1);
				}
			}
		}
	}

	public void quickSort(int[] src, int left, int right) {

		if (left > right) {
			return;
		}

		int flag = src[left];
		int i = left;
		int j = right;

		while (i != j) {
			while (src[j] >= flag && i < j) {
				j--;
			}
			while (src[i] <= flag && i < j) {
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

	/**
	 * @param src
	 * @param s
	 * @param len
	 *            每次归并有序集合的长度
	 */
	public void mergeSort(int[] src, int s, int len) {

		int size = src.length;
		int mid = size / (len << 1);
		int c = size & ((len << 1) - 1);

		// 归并到只剩一个有序集合时结束算法
		if (0 == mid) {
			return;
		}
		// 进行一趟归并排序
		for (int i = 0; i < mid; ++i) {
			s = i * 2 * len;
			merge(src, s, s + len, (len << 1) + s - 1);
		}
		// 将剩下的数和倒数一个有序集合归并
		if (0 != c) {
			merge(src, size - c - 2 * len, size - c, size - 1);
		}
		mergeSort(src, 0, 2 * len);
	}

	/**
	 * 
	 * 
	 * <pre>
	 * 　　二路归并
	 * 　　原理：将两个有序表合并和一个有序表
	 * 
	 * </pre>
	 * 
	 * @param a
	 * @param s
	 *            第一个有序表的起始下标
	 * @param m
	 *            第二个有序表的起始下标
	 * @param t
	 *            第二个有序表的结束小标 *
	 */
	private static void merge(int[] a, int s, int m, int t) {
		int[] tmp = new int[t - s + 1];
		int i = s, j = m, k = 0;
		while (i < m && j <= t) {
			if (a[i] <= a[j]) {
				tmp[k] = a[i];
				k++;
				i++;
			} else {
				tmp[k] = a[j];
				j++;
				k++;
			}
		}
		while (i < m) {
			tmp[k] = a[i];
			i++;
			k++;
		}
		while (j <= t) {
			tmp[k] = a[j];
			j++;
			k++;
		}
		System.arraycopy(tmp, 0, a, s, tmp.length);
	}

	private void swap(int[] src, int i, int j) {
		int tmp = src[i];
		src[i] = src[j];
		src[j] = tmp;
	}

	public static void main(String[] args) {
		int[] array = { 5, 3, 5, 2, 8, 3 };

		Sort sort = new Sort();
		sort.quickSort(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
