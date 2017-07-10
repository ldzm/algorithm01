package algorithm01.chapter2;

public interface Queue<E> {

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions. When using a
	 * capacity-restricted queue, this method is generally preferable to
	 * {@link #add}, which can fail to insert an element only by throwing an
	 * exception.
	 *
	 * @param e
	 *            the element to add
	 * @return {@code true} if the element was added to this queue, else
	 *         {@code false}
	 * @throws ClassCastException
	 *             if the class of the specified element prevents it from being
	 *             added to this queue
	 * @throws NullPointerException
	 *             if the specified element is null and this queue does not
	 *             permit null elements
	 * @throws IllegalArgumentException
	 *             if some property of this element prevents it from being added
	 *             to this queue
	 */
	boolean offer(E e);

	/**
	 * Retrieves and removes the head of this queue, or returns {@code null} if
	 * this queue is empty.
	 *
	 * @return the head of this queue, or {@code null} if this queue is empty
	 */
	E poll();

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns
	 * {@code null} if this queue is empty.
	 *
	 * @return the head of this queue, or {@code null} if this queue is empty
	 */
	E peek();
}
