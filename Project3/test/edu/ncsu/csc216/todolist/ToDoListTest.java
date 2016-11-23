package edu.ncsu.csc216.todolist;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.todolist.model.Category;

/**
 * The test cases for the ToDoList class
 * @author Christian Byrnes, Nick Board
 *
 */
public class ToDoListTest {
	
	/** The test object we'll be working with */
	private ToDoList test;
	
	/** The test filename to save to */
	private String fileName;
	
	// ========================== CATEGORY ==========================
	/** A test category name */
	private String testCatName = "New Category";
	/** A test category description */
	private String testCatDesc = "A new category... for testing. Nya ,':3c";
	
	// ========================== TASK ==========================
	// the task is assigned today, and due on November 11, 2020 at 11:11 PM
	/** The first task's title */
	private String t1Title = "Task 1";
	/** The first task's details */
	private String t1Details = "Task 1 details, blagh blah";
	/** The first task's start time */
	private Date t1StartTime;
	/** The first tasks's end time */
	private Date t1DueTime;
	/** The first task's year */
	private int t1Year = 2020;
	/** The first task's month */
	private int t1Month = 11;
	/** The first task's day */
	private int t1Day = 11;
	/** The first task's hour */
	private int t1Hour = 11;
	/** The first tasks's minute */
	private int t1Minute = 11;
	
	

	/**
	 * Sets up test values for testing the ToDoList
	 * @throws Exception if there is an error during setup
	 */
	@Before
	public void setUp() throws Exception {
		test = new ToDoList();
		test.getCategoryList().addCategory(testCatName, testCatDesc);
	}

	/**
	 * Test method for checking if the boolean has changed
	 */
	@Test
	public void testIsChanged() {
		fail("Not yet implemented");
		// TODO: Work on update before working on this
	}

	/**
	 * Test method for setting/getting the filename
	 */
	@Test
	public void testSetFilename() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getting the tasklist
	 */
	@Test
	public void testGetTaskList() {
		fail("Not yet implemented");
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
	}

	/**
	 * Test method for saving a data file
	 */
	@Test
	public void testSaveDataFile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for opening a data file
	 */
	@Test
	public void testOpenDataFile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for updating the ToDoList
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
		//TODO: get all of the updates to work
	}

}
