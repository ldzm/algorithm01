package algorithm01.chapter2;

public interface Stack<E> {

	boolean push(E e);
	E pop();
	E peek();
	boolean empty();
}
