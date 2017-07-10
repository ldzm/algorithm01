package algorithm01.chapter2;

public class LinkList<E> implements List<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public LinkList() {
		super();

		head = null;
		tail = null;
		size = 0;
	}

	public void add(E e) {
		if (null == head) {
			head = tail = new Node<E>(e);
		} else {
			Node<E> next = new Node<E>(e);

			tail.setNext(next);
			tail = tail.getNext();
		}
		size++;
	}

	public boolean insert(int index, E e) {

		if (index > size) {
			return false;
		}
		if (index == size) {
			add(e);
			return true;
		}

		final Node<E> newNode = new Node<E>(e);

		if (0 == index) {
			final Node<E> h = head;
			head = newNode;
			head.setNext(h);

		} else {
			Node<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			final Node<E> next = current.getNext();
			current.setNext(newNode);
			newNode.setNext(next);
		}

		size++;

		return true;
	}

	public E remove(int index) {
		if (index >= size) {
			return null;
		}

		if (0 == index) {
			Node<E> current = head;
			head = current.getNext();
			if (index == size - 1) {
				tail = head;
			}
			E result = current.getData();
			current = null;
			size--;

			return result;
		} else {
			Node<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			Node<E> next = current.getNext();
			current.setNext(next.getNext());
			if (index == size - 1) {
				tail = current;
			}

			E result = next.getData();
			next = null;
			size--;

			return result;
		}
	}

	public E get(int index) {

		if (index > size - 1) {
			return null;
		}

		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String result = "";
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result = result + " " + current.getData();
			current = current.getNext();
		}

		return result;
	}
}
