package algorithm01.chapter2;

import java.util.ArrayList;
import java.util.List;

import algorithm01.chapter2.ArrayStack;
import algorithm01.chapter2.Stack;
import junit.framework.TestCase;

public class ArrayStackTest extends TestCase {

	public final static int STACK_SIZE = 10;

	public void testPush() {
		Stack<Integer> stack = new ArrayStack<Integer>();

		for (int i = 0; i < STACK_SIZE; i++) {
			assertTrue(stack.push(i));
		}

		assertFalse(stack.push(11));
	}

	public void testPop() {
		Stack<Integer> stack = new ArrayStack<Integer>();
		assertNull(stack.pop());

		assertTrue(stack.push(10));
		assertTrue(stack.pop().equals(10));

		assertNull(stack.pop());

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < STACK_SIZE; i++) {
			list.add(i);
			assertTrue(stack.push(i));
		}

		assertFalse(stack.push(11));

		for (int i = 0; i < STACK_SIZE; i++) {
			assertTrue(stack.pop().equals(list.get(STACK_SIZE - i - 1)));
		}

		assertNull(stack.pop());

		assertTrue(stack.push(10));
		assertTrue(stack.pop().equals(10));
	}

	public void testPeek() {
		Stack<Integer> stack = new ArrayStack<Integer>();
		assertNull(stack.peek());
		assertTrue(stack.push(10));
		assertTrue(stack.peek().equals(10));
		assertTrue(stack.peek().equals(10));

		assertTrue(stack.push(12));
		assertTrue(stack.peek().equals(12));

		assertTrue(stack.pop().equals(12));
		assertTrue(stack.peek().equals(10));
		assertTrue(stack.pop().equals(10));
		assertNull(stack.peek());
	}

	public void testEmpty() {
		Stack<Integer> stack = new ArrayStack<Integer>();
		assertTrue(stack.empty());
		assertTrue(stack.push(10));
		assertFalse(stack.empty());

		stack.pop();
		assertTrue(stack.empty());
	}
}