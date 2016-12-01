package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the CategoryList class
 * @author Christian Byrnes, Nick Board
 *
 */
public class CategoryListTest {
	
	CategoryList cl;
	
	@Before
	public void beforeTest() {
		cl = new CategoryList();
		cl.addCategory("Overwatch", "A very addictive videogame");
		cl.addCategory("Harry Potter", "Wizards and Wands");
		cl.addCategory("Barack Obama", "President");
	}
	
	@Test
	public void testCategoryList() {
		assertEquals("Categories", cl.getName());
	}
	
	@Test
	public void testAddCategory() {
		assertEquals("C1", cl.getCategoryAt(0).getCategoryID());
		assertEquals("Overwatch", cl.getCategoryAt(0).getName());
		assertEquals("A very addictive videogame", cl.getCategoryAt(0).getDescription());

		assertEquals("C2", cl.getCategoryAt(1).getCategoryID());
		assertEquals("Harry Potter", cl.getCategoryAt(1).getName());
		assertEquals("Wizards and Wands", cl.getCategoryAt(1).getDescription());
		
		assertEquals("C3", cl.getCategoryAt(2).getCategoryID());
		assertEquals("Barack Obama", cl.getCategoryAt(2).getName());
		assertEquals("President", cl.getCategoryAt(2).getDescription());
		
		assertFalse(cl.addCategory(null, null));
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(0, cl.indexOf("C1"));
		assertEquals(1, cl.indexOf("C2"));
		assertEquals(2, cl.indexOf("C3"));
		
		assertEquals(0, cl.indexOf("Elephant"));
	}
	
	@Test
	public void testIndexOfName() {
		assertEquals(0, cl.indexOfName("Overwatch"));
		assertEquals(1, cl.indexOfName("Harry Potter"));
		assertEquals(2, cl.indexOfName("Barack Obama"));
		
		assertEquals(0, cl.indexOfName("Elephant"));

	}
	
	@Test
	public void testSize() {
		assertEquals(3, cl.size());
	}
	
	@Test
	public void testIsEmpty() {
		CategoryList c2 = new CategoryList();
		assertTrue(c2.isEmpty());
		assertFalse(cl.isEmpty());
	}
	
	@Test
	public void testRemoveCategoryAt() {
		cl.removeCategoryAt(1);
		assertEquals(2, cl.size());
		assertEquals("C1", cl.getCategoryAt(0).getCategoryID());
		assertEquals("C3", cl.getCategoryAt(1).getCategoryID());
		
		cl.removeCategoryAt(1);
		assertEquals(1, cl.size());
		assertEquals("C1", cl.getCategoryAt(0).getCategoryID());
		
		cl.removeCategoryAt(0);
		assertTrue(cl.isEmpty());
	}
	
	@Test
	public void testRemoveCategory() {
		cl.removeCategory("C2");
		assertEquals(2, cl.size());
		assertEquals("C1", cl.getCategoryAt(0).getCategoryID());
		assertEquals("C3", cl.getCategoryAt(1).getCategoryID());
		
		cl.removeCategory("C3");
		assertEquals(1, cl.size());
		assertEquals("C1", cl.getCategoryAt(0).getCategoryID());
		
		cl.removeCategory("C1");
		assertTrue(cl.isEmpty());
		
		assertFalse(cl.removeCategory("Elephant"));
	}
	
	@Test
	public void testGet2DArray() {
 		Object[][] arr = cl.get2DArray();
 		
 		assertEquals(arr[0][0], "C1");
 		assertEquals(arr[0][1], "Overwatch");
 		assertEquals(arr[0][2], "A very addictive videogame");
 		
 		assertEquals(arr[1][0], "C2");
 		assertEquals(arr[1][1], "Harry Potter");
 		assertEquals(arr[1][2], "Wizards and Wands");

 		assertEquals(arr[2][0], "C3");
 		assertEquals(arr[2][1], "Barack Obama");
 		assertEquals(arr[2][2], "President");

	}
	
	@Test
	public void testUpdate() {
		try {
			//test non-task update
			cl.update(null, null);
			fail("No!");
		} catch (Exception e) {
			//good keep goin
		}
		
		//test a task or w/e
		Category category = new Category("C1", "Overwatch", "A very addictive videogame");
		cl.update(category, null);
	}
}
