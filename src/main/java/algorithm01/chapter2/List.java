package algorithm01.chapter2;

public interface List<E> {
	
	void add(E e);
	boolean insert(int index, E e);
	E remove(int index);
	E get(int index);
	int size();
}
