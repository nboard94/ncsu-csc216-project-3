package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Category class
 * @author Christian Byrnes, Nick Board
 *
 */
public class CategoryTest {

	/**
	 * Tests the Category constructor.
	 */
	@Test
	public void testCategory() {
		Category c1 = new Category("ID1", "Name1", "Desc1");
		assertEquals("Name1", c1.getName());
		assertEquals("Desc1", c1.getDescription());
		assertEquals("ID1", c1.getCategoryID());
		
		Category c2 = null;
		try {
			c2 = new Category("ID1", null, "Desc1");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c2);
		}
		
		try {
			c2 = new Category("ID1", "", "Desc1");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c2);
		}
		
		try {
			c2 = new Category(null, "Name1", "Desc1");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c2);
		}
		
		try {
			c2 = new Category("", "Name1", "Desc1");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c2);
		}
	}
	
	/**
	 * Tests the Category's compareTo() method.
	 */
	@Test
	public void testCompareTo() {
		Category c1 = new Category("Apple", "Name1", "Desc1");
		Category c2 = new Category("Banana", "Name1", "Desc1");
		Category c3 = new Category("Cherry", "Name1", "Desc1");
		
		assertEquals(0, c2.compareTo(c2));
		assertEquals(-1, c2.compareTo(c3));
		assertEquals(1, c2.compareTo(c1));
	}
	
	/**
	 * Tests Category's equals method.
	 */
	@Test
	public void testEquals() {
		Category c1 = new Category("Apple", "Name1", "Desc1");
		Category c2 = new Category("Apple", "Name1", "Desc1");
		Category c3 = new Category("Cherry", "Name1", "Desc1");
		
		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));
	}
	
	/**
	 * Test's Category's hashcode method.
	 */
	@Test
	public void testHashCode() {
		Category c1 = new Category("Apple", "Name1", "Desc1");
		Category c2 = new Category("Apple", "Name1", "Desc1");
		Category c3 = new Category("Cherry", "Name1", "Desc1");
		
		assertTrue(c1.hashCode() == c2.hashCode());
		assertFalse(c1.hashCode() == c3.hashCode());
		
	}
	
	/**
	 * Tests Category's toString() method.
	 */
	@Test
	public void testToString() {
		Category c1 = new Category("Apple", "Name1", "Desc1");
		assertEquals(c1.toString(), "Name1");
	}
}
