package algorithm01.chapter2;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<E> implements Queue<E> {

	public final static int QUEUE_SIZE = 10;
	private List<E> data;

	private int head;
	private int tail;
	private int size;

	public ArrayQueue() {
		super();
		data = new ArrayList<E>(QUEUE_SIZE);
		head = tail = size = 0;
	}

	public ArrayQueue(int queueSize) {
		super();
		data = new ArrayList<E>(queueSize);
		head = tail = size = 0;
	}
	
	public boolean offer(E e) {
		if (size >= QUEUE_SIZE) {
			return false;
		}

		// set(i,e)是替换元素，如果元素没有被添加，则返回异常；
		// 由于我们循环使用数组，所以在元素大于QUEUE_SIZE个的时候，之后的offer操作
		// 需要替换之前的元素，不能再用add添加元素。
		// 但是在list中没有元素的时候使用set会产生异常，我们通过异常来判断是
		// 前QUEUE_SIZE次造作
		try {
			data.set(tail, e);
		} catch(Exception exception) {
			data.add(e);
		}
		
		tail = (tail + 1) % QUEUE_SIZE;
		size++;

		return true;
	}

	public E poll() {

		if (size <= 0) {
			return null;
		}

		E result = data.get(head);
		head = (head + 1) % QUEUE_SIZE;
		size--;

		return result;
	}

	public E peek() {

		if (size <= 0) {
			return null;
		}

		E result = data.get(head);

		return result;
	}

}
