package algorithm01.chapter2;

import java.util.ArrayList;
import java.util.List;

import algorithm01.chapter2.ArrayQueue;
import algorithm01.chapter2.Queue;
import junit.framework.TestCase;

public class ArrayQueueTest extends TestCase {

	public final static int QUEUE_SIZE = 10;
	
    public void testOffer()
    {
    	Queue<Integer> queue = new ArrayQueue<Integer>();
    	
    	for(int i = 0; i < QUEUE_SIZE; i++) {
    		assertTrue(queue.offer(i));
    	}
    	
    	assertFalse(queue.offer(11));
    }
    
    public void testPoll()
    {
    	Queue<Integer> queue = new ArrayQueue<Integer>();
    	assertNull(queue.poll());
    	
    	assertTrue(queue.offer(10));
    	assertTrue(queue.poll().equals(10));
    	
    	assertNull(queue.poll());
    	
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i < QUEUE_SIZE; i++) {
    		list.add(i);
    		assertTrue(queue.offer(i));
    	}
    	assertFalse(queue.offer(11));
    	
    	for(int i = 0; i < QUEUE_SIZE; i++) {
    		assertTrue(queue.poll().equals(list.get(i)));
    	}
    	
    	assertNull(queue.poll());
    	
    	assertTrue(queue.offer(10));
    	assertTrue(queue.poll().equals(10));
    }
    
    public void testPeek()
    {
    	Queue<Integer> queue = new ArrayQueue<Integer>();
    	assertNull(queue.peek());
    	assertTrue(queue.offer(10));
    	assertTrue(queue.peek().equals(10));
    	assertTrue(queue.peek().equals(10));
    	
    	assertTrue(queue.offer(12));
    	assertTrue(queue.peek().equals(10));
    	
    	assertTrue(queue.poll().equals(10));
    	assertTrue(queue.peek().equals(12));
    	assertTrue(queue.poll().equals(12));
    	assertNull(queue.peek());
    }
    
    public void testAll()
    {
    	Queue<Integer> queue = new ArrayQueue<Integer>();
    	assertNull(queue.poll());
    	
    	assertTrue(queue.offer(10));
    	assertTrue(queue.poll().equals(10));
    	
    	assertNull(queue.poll());
    	
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i < QUEUE_SIZE; i++) {
    		list.add(i);
    		assertTrue(queue.offer(i));
    	}
    	assertFalse(queue.offer(11));
    	
    	for(int i = 0; i < QUEUE_SIZE; i++) {
    		assertTrue(queue.poll().equals(list.get(i)));
    	}
    	
    	assertNull(queue.poll());
    	
    	assertTrue(queue.offer(10));
    	assertTrue(queue.poll().equals(10));
    	
    	assertTrue(queue.offer(10));
    	assertTrue(queue.poll().equals(10));
    	
    	assertNull(queue.poll());
    	
    	for(int i = 0; i < QUEUE_SIZE; i++) {
    		list.add(i);
    		assertTrue(queue.offer(i));
    	}
    	assertFalse(queue.offer(11));
    	
    	for(int i = 0; i < QUEUE_SIZE; i++) {
    		assertTrue(queue.poll().equals(list.get(i)));
    	}
    	
    	assertNull(queue.poll());
    	
    	assertTrue(queue.offer(10));
    	assertTrue(queue.poll().equals(10));

    	assertNull(queue.peek());
    	assertTrue(queue.offer(10));
    	assertTrue(queue.peek().equals(10));
    	assertTrue(queue.peek().equals(10));
    	
    	assertTrue(queue.offer(12));
    	assertTrue(queue.peek().equals(10));
    	
    	assertTrue(queue.poll().equals(10));
    	assertTrue(queue.peek().equals(12));
    	assertTrue(queue.poll().equals(12));
    	assertNull(queue.peek());
    }
}
