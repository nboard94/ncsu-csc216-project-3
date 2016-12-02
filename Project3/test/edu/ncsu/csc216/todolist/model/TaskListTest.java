/**
 * 
 */
package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the TaskList object
 * @author Christian Byrnes and Nick Board
 *
 */
public class TaskListTest {
	
	/** The test TaskList object */
	private TaskList test;
	/** The test name */
	private String name = "Test Task List";
	/** The test list ID */
	private String testListID = "TLDR-420";
	/** The test category */
	private Category testCat = new Category("New Category", "This category is for testing", "TLDR-69");
	
	// ===== TASKS ===== String newTitle, String newDetails, Date newStartDateTime, Date newDueDateTime, Category newCategory, String newTaskID
	
	// the first task is assigned today, and due on November 11, 2020 at 11:11 PM
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
	
	// the second task is also assigned today, and is due on April 20, 2025 at 14:20
	/** The second task's title */
	private String t2Title = "Task 2";
	/** The second task's details */
	private String t2Details = "Task 2 details, blagh blah";
	/** The second task's start time */
	private Date t2StartTime;
	/** The second tasks's end time */
	private Date t2DueTime;
	/** The second task's year */
	private int t2Year = 2025;
	/** The second task's month */
	private int t2Month = 4;
	/** The second task's day */
	private int t2Day = 20;
	/** The second task's hour */
	private int t2Hour = 14;
	/** The second tasks's minute */
	private int t2Minute = 20;
	
	

	/**
	 * Sets up a test item for testing
	 * @throws Exception if there is an error when initializing test values
	 */
	@Before
	public void setUp() throws Exception {
		//initialize the tasklist
		test = new TaskList(name, testListID);
		
		//initialize the due dates using a Calendar
		Calendar dateFetch = Calendar.getInstance();
		
		//assigned dates are both today
		t1StartTime = dateFetch.getTime();
		t2StartTime = dateFetch.getTime();
		
		//get and set assigned due date for t1
		//calendar set order: int year, int month, int date, int hourOfDay, int minute
		dateFetch.set(t1Year, t1Month, t1Day, t1Hour, t1Minute);
		t1DueTime = dateFetch.getTime();
		
		//set t2 due time
		dateFetch.set(t2Year, t2Month, t2Day, t2Hour, t2Minute);
		t2DueTime = dateFetch.getTime();
		
	}

	/**
	 * Test method for constructing a TaskList
	 */
	@Test
	public void testTaskList() {
		//create a new task list
		TaskList newList = null;
		
		//try to construct it with null + empty values, should all fail
		try {
			newList = new TaskList(null, testListID);
			fail("No null values!");
		} catch (Exception e) {
			assertEquals(null, newList);
		}
		try {
			newList = new TaskList(name, null);
			fail("No null values!");
		} catch (Exception e) {
			assertEquals(null, newList);
		}
		try {
			newList = new TaskList("    ", testListID);
			fail("No empty values!");
		} catch (Exception e) {
			assertEquals(null, newList);
		}
		try {
			newList = new TaskList(name, "    ");
			fail("No empty values!");
		} catch (Exception e) {
			assertEquals(null, newList);
		}
		
		//cool. now let's actually initialize it and make sure it's all good
		newList = new TaskList(name, testListID);
		assertFalse(newList == null);
		assertEquals(name, newList.getName());
		assertEquals(testListID, newList.getTaskListID());
		assertTrue(newList.isEmpty());
	}

	/**
	 * Test method for setting the name of the task list
	 */
	@Test
	public void testSetName() {
		//check that the tasklist's name is currently what it should be
		assertEquals(name, test.getName());
		
		//try to change the name to a null value, catch
		try {
			test.setName(null);
			fail("No null values!");
		} catch (IllegalArgumentException e) {
			assertEquals(name, test.getName());
		}
		
		//try to change the name to an empty value, catch
		try {
			test.setName("    ");
			fail("No empty values!");
		} catch (IllegalArgumentException e) {
			assertEquals(name, test.getName());
		}
			
		//try to set the name to something legal, should work
		try {
			test.setName("Legal New Name");
			assertEquals("Legal New Name", test.getName());
		} catch (IllegalArgumentException e) {
			fail("That name was legal!");
		}
		
	}

	/**
	 * Test method for adding a task to the list
	 */
	@Test
	public void testAddTask() {
		//check that the current test is empty
		assertTrue(test.isEmpty());
		
		String empty = "   ";
		
		//attempt to add various empty and null fields into tasklist addtask method- should all fail
		// TITLE
//		assertFalse(test.addTask(null, t1Details, t1StartTime, t1DueTime, testCat));
//		assertFalse(test.addTask(empty, t1Details, t1StartTime, t1DueTime, testCat));
//		//DETAILS
//		assertFalse(test.addTask(t1Title, null, t1StartTime, t1DueTime, testCat));
//		assertFalse(test.addTask(t1Title, empty, t1StartTime, t1DueTime, testCat));
//		//START TIME
//		assertFalse(test.addTask(t1Title, t1Details, null, t1DueTime, testCat));
//		//DUE TIME
//		assertFalse(test.addTask(t1Title, t1Details, t1StartTime, null, testCat));
//		//CATEGORY
//		assertFalse(test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, null));
		
		//attempt to add legal task, should work! :D
		try {
			test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, testCat);
			assertFalse(test.isEmpty());
		} catch (IllegalArgumentException e) {
			fail("You should've been able to add that task!");
		}
	}

	/**
	 * Test method for getting the task at a given index
	 */
	@Test
	public void testGetTaskAt() {
		//assert that the list is empty rn
		assertTrue(test.isEmpty());
		
		//attempt to use GetTaskAt while list is empty, should fail
		try {
			test.getTaskAt(0);
			fail("The list is empty!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(test.isEmpty());
		}
		
		//add an item to the list
		test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, testCat);
		assertFalse(test.isEmpty());
		assertEquals(1, test.size());
		
		//attempt to get an item at index less than zero. should fail
		try {
			test.getTaskAt(-1);
			fail("Negative index");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(1, test.size());
		}
		
		//attempt to get an item at index greater than size, should fail
		try {
			test.getTaskAt(2);
			fail("Too big index");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(1, test.size());
		}
		
		//attempt to get an item at index = size, should fail
		try {
			test.getTaskAt(1);
			fail("Illegal index");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(1, test.size());
		}
		
		//attempt to get task at correct index, should work
		try {
			Task fetch = test.getTaskAt(0);
			assertEquals(t1Title, fetch.getTitle());
		} catch (IndexOutOfBoundsException e) {
			fail("That should have worked");
		}
		
		//add another task
		test.addTask(t2Title, t2Details, t2StartTime, t2DueTime, testCat);
		assertEquals(2, test.size());
		
		//attempt to fetch both tasks, shoudl work
		try {
			Task grab1 = test.getTaskAt(0);
			Task grab2 = test.getTaskAt(1);
			//TODO
			assertEquals(t1Title, grab1.getTitle());
			assertEquals(t2Title, grab2.getTitle());
		} catch (Exception e) {
			fail("That should've been just fine");
		}
	}

	/**
	 * Test method for getting the index of a task given it's title
	 */
	@Test
	public void testIndexOf() {
		//check that list is empty
		assertTrue(test.isEmpty());
		
		//attempt to use indexOf when empty- should return -1
		assertEquals(-1, test.indexOf(t1Title));
		
		//add an item to the list
		test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, testCat);
		
		//use indexOf to find it's index- should be 0
		String taskIDD = test.getTaskAt(0).getTaskID();
		int taskIdx = test.indexOf(taskIDD);
		assertEquals(0, taskIdx);
		
		//add another item to the list, assert that it can be fetched too
		test.addTask(t2Title, t2Details, t2StartTime, t2DueTime, testCat);
		assertEquals(t2Title, test.getTaskAt(1).getTitle());
		
		taskIDD = test.getTaskAt(1).getTaskID();
		taskIdx = test.indexOf(taskIDD);
		assertEquals(1, taskIdx);
	}

	/**
	 * Test method for removing a task at a given index
	 */
	@Test
	public void testRemoveTaskAt() {
		//assert that the list is empty
		assertTrue(test.isEmpty());
		
		//attempt to use this with an empty list- should throw a fit
		try {
			test.removeTaskAt(0);
			fail("That should've broken!");
		} catch (Exception e) {
			assertTrue(test.isEmpty());
		}
		
		//add a couple items to the list
		test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, testCat);
		test.addTask(t2Title, t2Details, t2StartTime, t2DueTime, testCat);
		assertFalse(test.isEmpty());
		assertEquals(2, test.size());
		
		//remove task at negative index, should fail
		try {
			test.removeTaskAt(-1);
			fail("Negative index");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, test.size());
		}
		
		//remove task at oversized index, should fail
		try {
			test.removeTaskAt(3);
			fail("Oversized index");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, test.size());
		}
		
		//remove task at size, should fail
		try {
			test.removeTaskAt(2);
			fail("Index == size");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, test.size());
		}
		
		//remove at 1, should succeed
		try {
			Task removed = test.removeTaskAt(1);
			assertEquals(1, test.size());
			assertEquals(t2Title, removed.getTitle());
		} catch (Exception e) {
			fail("Legal index still broke?");
		}
		
		//remove at 0, should succeed and leave test empty
		
//		try {
//			Task removed = test.removeTaskAt(0);
//			assertEquals(2, test.size());
//			assertTrue(test.isEmpty());
//			assertEquals(t1Title, removed.getTitle());
//		} catch (Exception e) {
//			fail("Legal index still broke");
//		}
//		
	}

	/**
	 * Test method for removing a task given the task ID
	 */
	@Test
	public void testRemoveTask() {
		//assure that the test item is empty
		assertTrue(test.isEmpty());
		
		//attempt to use this while empty, should return false
		assertFalse(test.removeTask(t1Title));
		
		//add a couple of items to the list
		test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, testCat);
		test.addTask(t2Title, t2Details, t2StartTime, t2DueTime, testCat);
		assertFalse(test.isEmpty());
		assertEquals(2, test.size());
		
		//grab the task ids
		String taskID1 = test.getTaskAt(0).getTaskID();
		String taskID2 = test.getTaskAt(1).getTaskID();
		
		//attempt to remove task given an id, should return true
		assertTrue(test.removeTask(taskID1));
		
		//attempt to remove one again, should return false this time
		//assertFalse(test.removeTask(taskID1));
		
		//attempt to remove the other
		assertTrue(test.removeTask(taskID2));
		
		//attempt to remote second again, should return false
		assertFalse(test.removeTask(taskID2));
		
	}

	/**
	 * Test method for getting the 2d array of tasks in a tasklist
	 */
	@Test
	public void testGet2DArray() {
		//make sure the test object is empty
		assertTrue(test.isEmpty());
		
		//fetch the array, make sure it's size is 0
		Object[][] arrayTest = test.get2DArray();
		assertEquals(0, arrayTest.length);
		
		//add a couple of items to the list
		test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, testCat);
		test.addTask(t2Title, t2Details, t2StartTime, t2DueTime, testCat);
		assertFalse(test.isEmpty());
		assertEquals(2, test.size());
		
		//get the 2d array, make sure that it's got what it needs
		arrayTest = test.get2DArray();
		String t1TaskID = test.getTaskAt(0).getTaskID();
		String t2TaskID = test.getTaskAt(1).getTaskID();
		
		assertEquals(t1TaskID, arrayTest[0][0]);
		assertEquals(t2TaskID, arrayTest[1][0]);
	}

//	/**
//	 * Test method for updating a task
//	 */
//	@Test
//	public void testUpdate() {
//		
//		//test a task or w/e
//		test.addTask(t1Title, t1Details, t1StartTime, t1DueTime, testCat);
//		Task task = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, test.getTaskAt(0).getTaskID());
//		test.update(task, null);
//	}

}
