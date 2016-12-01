package edu.ncsu.csc216.todolist.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class to test LinkedList class and it's methods.
 * @author Nicholas Board and Christian Byrnes
 */
public class LinkedListTest {

	/**
	 * Tests LinkedList's constructor.
	 */
	@Test
	public void testLinkedList() {
		LinkedList l1 = new LinkedList();
		assertTrue(l1.isEmpty());
		
	}
	
	/**
	 * Tests LinkedList's add method.
	 */
	@Test
	public void testAdd() {
		LinkedList l1 = new LinkedList();
		
		l1.add("Avagantamous");
		assertFalse(l1.isEmpty());
		assertEquals(1, l1.size());
		assertEquals("Avagantamous", l1.get(0));
		
		l1.add("Hydran");
		assertFalse(l1.isEmpty());
		assertEquals(2, l1.size());
		assertEquals("Hydran", l1.get(1));
		
		l1.add("T");
		assertFalse(l1.isEmpty());
		assertEquals(3, l1.size());
		assertEquals("T", l1.get(2));
	
	}
	
	/**
	 * Tests LinkedList's add method with int parameter.
	 */
	@Test
	public void testAddIndex() {
		LinkedList l1 = new LinkedList();
		
		
		try {
			l1.add(null);
			fail();
		} catch (NullPointerException e) {
			assertTrue(l1.isEmpty());
		}
		try {
			l1.add(0, null);
			fail();
		} catch (NullPointerException e) {
			assertTrue(l1.isEmpty());
		}
		
		try {
			l1.add(-1, "Rox");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(l1.isEmpty());
		}
		
		try {
			l1.add(1, "Rox");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(l1.isEmpty());
		}
		
		l1.add(0, "Avagantamous");
		assertFalse(l1.isEmpty());
		assertEquals(1, l1.size());
		assertEquals("Avagantamous", l1.get(0));
		
		l1.add(0, "Hydran");
		assertFalse(l1.isEmpty());
		assertEquals(2, l1.size());
		assertEquals("Hydran", l1.get(0));
		assertEquals("Avagantamous", l1.get(1));
		
		l1.add(2, "T");
		assertFalse(l1.isEmpty());
		assertEquals(3, l1.size());
		assertEquals("T", l1.get(2));
		assertEquals("Hydran", l1.get(0));
		assertEquals("Avagantamous", l1.get(1));
		
		l1.add(1, "Rabi");
		assertFalse(l1.isEmpty());
		assertEquals(4, l1.size());
		assertEquals("T", l1.get(3));
		assertEquals("Hydran", l1.get(0));
		assertEquals("Avagantamous", l1.get(2));
		assertEquals("Rabi", l1.get(1));
	}
	
	/**
	 * Tests LinkedList's contains method.
	 */
	@Test
	public void testContains() {
		LinkedList l1 = new LinkedList();

		l1.add("Hydran");
		assertTrue(l1.contains("Hydran"));
		
		l1.add("T");
		assertTrue(l1.contains("T"));
		
		assertFalse(l1.contains("Rabi"));
		assertFalse(l1.contains("Avagantamous"));
	}
	
	/**
	 * Tests LinkedList's get method.
	 */
	@Test
	public void testGet() {
		LinkedList l1 = new LinkedList();
		l1.add("Hydran");	
		l1.add("T");
		
		try {
			l1.get(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals("Hydran", l1.get(0));
		}
		
		try {
			l1.get(3);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("T", l1.get(1));
		}
	}
	
	/**
	 * Tests LinkedList's indexOf method.
	 */
	@Test
	public void testIndexOf() {
		LinkedList l1 = new LinkedList();
		l1.add("Hydran");	
		l1.add("T");
		
		assertEquals(0, l1.indexOf("Hydran"));
		assertEquals(1, l1.indexOf("T"));
		
		assertEquals(-1, l1.indexOf("Avagantamous"));
	}
	
	/**
	 * Tests LinkedList's remove method.
	 */
	@Test
	public void testRemove() {
		LinkedList l1 = new LinkedList();
		
		try {
			l1.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(l1.isEmpty());
		}
		
		try {
			l1.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(l1.isEmpty());
		}
		
		try {
			l1.remove(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(l1.isEmpty());
		}
		
		l1.add("Hydran");	
		l1.add("T");
		
		try {
			assertEquals("Hydran", l1.remove(0));
			assertEquals("T", l1.get(0));
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}
}
