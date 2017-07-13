package algorithm01.chapter7;

public class HeapSort {

	private int length;

	public HeapSort() {
		length = 0;
	}

	public HeapSort(int length) {
		this.length = length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * 此实现方法需要额外的数组 思考一下，当我们删除堆中一个元素的时候放入新建的数组，那么堆数组就少另一个元素，不如我们
	 * 把删除的元素放在堆尾部，这样删完的同时数组中就是排序要的元素。
	 * 
	 * @param src
	 */
	public void sort(int[] src) {
		int[] result = new int[src.length];
		creat(src);
		for (int i = 1; i < result.length; i++) {
			result[i] = deleteMin(src);
		}
		for (int i = 1; i < result.length; i++) {
			src[i] = result[i];
		}
	}

	/**
	 * 使用最小堆回去的排序是降序的
	 * 
	 * @param src
	 */
	public void sort2(int[] src) {

		creat(src);

		while (length > 1) {
			swap(src, 1, length);
			length--;
			siftdown(src, 1);
		}
	}

	private void creat(int[] src) {
		for (int i = src.length / 2; i >= 1; i--) {
			siftdown(src, i);
		}
	}

	private int deleteMin(int[] src) {
		int result = src[1];

		src[1] = src[length];
		length--;
		siftdown(src, 1);

		return result;
	}

	private void siftdown(int[] src, int i) {
		int flag = 0; // 0 表示需要继续向下调整
		int t = 0;
		while (i * 2 <= length && flag == 0) {
			// 先判断它与作儿子的关系，并用t记录较小节点的编号
			if (src[i] > src[i * 2]) {
				t = i * 2;
			} else {
				t = i;
			}

			if (i * 2 + 1 <= length) {
				// 如果右儿子更小，更新较小的节点的编号
				if (src[t] > src[i * 2 + 1]) {
					t = i * 2 + 1;
				}
			}

			// 如果发现最小的节点不是自己，说明有比如节点更小的点
			if (t != i) {
				swap(src, t, i);
				i = t; // 更新i为刚才与它交换的儿子结点的编号，便于接下来继续向下调整
			} else {
				flag = 1; // 说明当前父节点已经比两个子节点都小，不需要再调整了
			}
		}
	}

	private void swap(int[] src, int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
}
