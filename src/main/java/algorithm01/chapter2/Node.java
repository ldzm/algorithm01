package algorithm01.chapter2;

public class Node <E> {

	private Node<E> next = null;
	private E data = null;
	
	public Node() {
		super();
	}
	public Node(E data) {
		super();
		this.data = data;
	}
	
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	

	
}
