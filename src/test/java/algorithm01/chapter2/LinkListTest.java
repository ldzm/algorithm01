package algorithm01.chapter2;

import junit.framework.TestCase;

public class LinkListTest extends TestCase {

	public void testAdd() {
		List<Integer> list = new LinkList<Integer>();
		
		list.add(10);
		list.add(11);
		assertEquals(2, list.size());
	}
	
	public void testInsert() {
		List<Integer> list = new LinkList<Integer>();
		
		assertTrue(list.insert(0, 1));
		list.add(10);
		assertTrue(list.insert(0, 2));
		list.add(11);
		assertTrue(list.insert(1, 3));
		assertTrue(list.insert(5, 4));
		assertEquals(6, list.size());
	}
	
	public void testRemove() {
		List<Integer> list = new LinkList<Integer>();
		
		assertTrue(list.insert(0, 1));
		list.add(10);
		assertTrue(list.insert(0, 2));
		list.add(11);
		assertTrue(list.insert(1, 3));
		assertTrue(list.insert(5, 4));
		assertEquals(6, list.size());
		
		assertTrue(list.remove(0).equals(2));
		assertEquals(5, list.size());
		
		assertTrue(list.remove(1).equals(1));
		assertEquals(4, list.size());
		
		assertTrue(list.remove(2).equals(11));
		assertEquals(3, list.size());
		
		list.add(10);
		assertTrue(list.get(3).equals(10));
	}
	
	public void testGet() {
		List<Integer> list = new LinkList<Integer>();
		
		list.add(10);
		assertTrue(list.get(0).equals(10));
	}
	
	public void testAll() {
		List<Integer> list = new LinkList<Integer>();
		
		assertTrue(list.insert(0, 1));
		list.add(10);
		assertTrue(list.insert(0, 2));
		list.add(11);
		assertTrue(list.insert(1, 3));
		assertTrue(list.insert(5, 4));
		assertEquals(6, list.size());
		
		assertTrue(list.remove(0).equals(2));
		assertEquals(5, list.size());
		
		assertTrue(list.remove(1).equals(1));
		assertEquals(4, list.size());
		
		assertTrue(list.remove(2).equals(11));
		assertEquals(3, list.size());
		assertTrue(list.remove(2).equals(4));
		
		list.add(10);
		assertTrue(list.get(2).equals(10));
		
		assertTrue(list.insert(0, 15));
		assertTrue(list.insert(1, 2));
		assertTrue(list.insert(5, 16));
		
		int [] array = {15, 2, 3, 10, 10, 16};
		for(int i = 0; i < list.size(); i++) {
			assertTrue(list.get(i).equals(array[i]));
		}
	}
}
