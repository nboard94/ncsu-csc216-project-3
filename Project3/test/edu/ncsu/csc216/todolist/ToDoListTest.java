package edu.ncsu.csc216.todolist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.todolist.model.*;

/**
 * The test cases for the ToDoList class
 * @author Christian Byrnes, Nick Board
 *
 */
public class ToDoListTest {
	
	/** The test object we'll be working with */
	private ToDoList test;
	
	/** The test filename to save to */
	//private String fileName;
	
	// ========================== CATEGORY ==========================
	/** A test category name */
	private String testCatName = "New Category";
	/** A test category description */
	private String testCatDesc = "A new category... for testing. Nya ,':3c";
	
	// ========================== TASK ==========================
	// the task is assigned today, and due on November 11, 2020 at 11:11 PM
	/** The first task's title */
	//private String t1Title = "Task 1";
	/** The first task's details */
	//private String t1Details = "Task 1 details, blagh blah";
	/** The first task's start time */
	//private Date t1StartTime;
	/** The first tasks's end time */
	//private Date t1DueTime;
	/** The first task's year */
	//private int t1Year = 2020;
	/** The first task's month */
	//private int t1Month = 11;
	/** The first task's day */
	//private int t1Day = 11;
	/** The first task's hour */
	//private int t1Hour = 11;
	/** The first tasks's minute */
	//private int t1Minute = 11;
	
	

	/**
	 * Sets up test values for testing the ToDoList
	 * @throws Exception if there is an error during setup
	 */
	@Before
	public void setUp() throws Exception {
		test = new ToDoList();
		test.getCategoryList().addCategory(testCatName, testCatDesc);
	}

//	/**
//	 * Test method for checking if the boolean has changed
//	 */
//	@Test
//	public void testIsChanged() {
//		//at first, ischanged should return false
//		assertFalse(test.isChanged());
//		
//		//change it to true
//		test.setChanged(true);
//		
//		//assert that ischanged returns true
//		assertTrue(test.isChanged());
//	}

	/**
	 * Test method for setting/getting the filename
	 */
	@Test
	public void testSetFilename() {
		//set the file name to the given string, should succeed
		String fileName = "filename";
		test.setFilename(fileName);
		
		//attempt to set the filename to null, should fail
		try {
			test.setFilename(null);
			fail("No null file name");
		} catch (IllegalArgumentException e) {
			assertEquals(fileName, test.getFilename());
		}
		
		//attempt empty filename, should fail
		try {
			test.setFilename("     ");
			fail("No null file name");
		} catch (IllegalArgumentException e) {
			assertEquals(fileName, test.getFilename());
		}
		
		
	}

	/**
	 * Test method for getting the tasklist
	 */
	@Test
	public void testGetTaskList() {
		//make sure that there is one todo list in test right now
		TaskList defaultList = test.getTaskList(0);
		assertTrue(defaultList.isEmpty());
		
		//try negative index, should fail
		try {
			defaultList = test.getTaskList(-1);
			fail("Negative index");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(defaultList.isEmpty());
		}
		
		//try oversized index, should fail
		try {
			defaultList = test.getTaskList(2);
			fail("Oversized index");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(defaultList.isEmpty());
		}
		
		//try index @ size, should fail
		try {
			defaultList = test.getTaskList(1);
			fail("Index = size");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(defaultList.isEmpty());
		}
	}

	/**
	 * Test method for adding a new tasklist
	 */
	@Test
	public void testAddTaskList() {
		ToDoList tDL = new ToDoList();
		tDL.addTaskList();
		assertEquals(2, tDL.getNumTaskLists());
		assertEquals("TL1", tDL.getTaskList(0).getTaskListID());
		
		tDL.addTaskList();
		assertEquals(3, tDL.getNumTaskLists());
		assertEquals("TL2", tDL.getTaskList(1).getTaskListID());
		
		tDL.addTaskList();
		assertEquals(4, tDL.getNumTaskLists());
		assertEquals("TL3", tDL.getTaskList(2).getTaskListID());
		
		tDL.addTaskList();
		assertEquals(5, tDL.getNumTaskLists());
		assertEquals("TL4", tDL.getTaskList(3).getTaskListID());
	}

	/**
	 * Test method for removing a tasklist
	 */
	@Test
	public void testRemoveTaskList() {
		ToDoList tDL = new ToDoList();
		tDL.addTaskList();
		assertEquals(2, tDL.getNumTaskLists());
		assertEquals("TL1", tDL.getTaskList(0).getTaskListID());
		
		tDL.addTaskList();
		assertEquals(3, tDL.getNumTaskLists());
		assertEquals("TL2", tDL.getTaskList(1).getTaskListID());
		
		tDL.removeTaskList(0);
		assertEquals(2, tDL.getNumTaskLists());
		assertEquals("TL2", tDL.getTaskList(0).getTaskListID());
		
		try {
			tDL.removeTaskList(100);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, tDL.getNumTaskLists());
		}
		
		try {
			tDL.removeTaskList(-2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, tDL.getNumTaskLists());
		}
	}

//	/**
//	 * Test method for updating the ToDoList
//	 */
//	@Test
//	public void testUpdate() {
//		try {
//			test.update(null, null);
//		} catch (Exception e) {
//			fail();
//		}
//	}
	
	/**
	 * Test method of saveDateFile
	 */
	@Test
	public void testSaveDataFile() {
		ToDoList tdl = new ToDoList();
		
		CategoryList testCatList = new CategoryList();
		testCatList.addCategory(testCatName, testCatDesc);
		assertEquals(testCatName, testCatList.getCategoryAt(0).getName());
		
		tdl.saveDataFile("test.txt");
	}
	
	/**
	 * Test method of openDateFile
	 */
	@Test
	public void testOpenDataFile() {
		ToDoList tdl = new ToDoList();
		
		CategoryList testCatList = new CategoryList();
		testCatList.addCategory(testCatName, testCatDesc);
		assertEquals(testCatName, testCatList.getCategoryAt(0).getName());
		
		
		tdl.openDataFile("test.txt");
	}

}
