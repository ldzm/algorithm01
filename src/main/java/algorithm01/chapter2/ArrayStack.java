package algorithm01.chapter2;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {

	public final static int STACK_SIZE = 10;
	private List<E> data;

	private int head;

	public ArrayStack() {
		super();
		data = new ArrayList<E>(STACK_SIZE);
		head = 0;
	}

	public boolean push(E e) {

		if (head >= STACK_SIZE) {
			return false;
		}
		data.add(e);
		head++;

		return true;
	}

	public E pop() {

		if (head <= 0) {
			return null;
		}
		head--;
		E result = data.get(head);
		data.remove(head);

		return result;
	}

	public E peek() {
		if (head <= 0) {
			return null;
		}
		E result = data.get(head - 1);

		return result;
	}

	public boolean empty() {

		return head == 0;
	}
}
