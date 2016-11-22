package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * TaskTest validates the behavior of the
 * Task class and all of its methods.
 * @author Nicholas Board and Christian Byrnes
 */
public class TaskTest {
	
	
	/**
	 * The category used when creating test Tasks.
	 */
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
	 * Sets up the StartTime and DueTime for both test Tasks.
	 */
	@Before
	public void beforeTest() {
		Calendar dateFetch = Calendar.getInstance();
		t1StartTime = dateFetch.getTime();
		t2StartTime = dateFetch.getTime();
		
		dateFetch.set(t1Year, t1Month, t1Day, t1Hour, t1Minute);
		t1DueTime = dateFetch.getTime();
		
		dateFetch.set(t2Year, t2Month, t2Day, t2Hour, t2Minute);
		t2DueTime = dateFetch.getTime();
	}
	
	/**
	 * Tests the Task constructor.
	 */
	@Test
	public void testTask() {
		Task t1 = null;
		
		try {
			t1 = new Task(null, t1Details, t1StartTime, t1DueTime, testCat, "t1id");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task("", t1Details, t1StartTime, t1DueTime, testCat, "t1id");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task(t1Title, null, t1StartTime, t1DueTime, testCat, "t1id");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task(t1Title, "", t1StartTime, t1DueTime, testCat, "t1id");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task(t1Title, t1Details, null, t1DueTime, testCat, "t1id");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task(t1Title, t1Details, t1StartTime, null, testCat, "t1id");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, null, "t1id");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		try {
			t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(t1);
		}
		
		t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "t1id");
		assertEquals(t1Title, t1.getTitle());
		assertEquals(t1Details, t1.getDetails());
		assertEquals(t1StartTime, t1.getStartDateTime());
		assertEquals(t1DueTime, t1.getDueDateTime());
		assertEquals(testCat, t1.getCategory());
		assertEquals("t1id", t1.getTaskID());
		assertFalse(t1.isCompleted());
	}
	
	/**
	 * Tests Task's setCompletedDateTime method.
	 */
	@Test
	public void testSetCompletedDateTime() {
		Task t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "t1id");
		t1.setCompletedDateTime(t1DueTime);
		assertEquals(t1DueTime, t1.getDueDateTime());
	}
	
	/**
	 * Tests Task's setCompleted method.
	 */
	@Test
	public void testSetCompleted() {
		Task t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "t1id");
		t1.setCompleted(true);
		assertTrue(t1.isCompleted());
	}
	
	/**
	 * Tests Task's completed method.
	 */
	@Test
	public void testEquals() {
		Task t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "t1id");
		Task t2 = new Task(t2Title, t2Details, t2StartTime, t2DueTime, testCat, "t1id");
		Task t3 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "t3id");
		
		assertTrue(t1.equals(t2));
		assertTrue(t2.equals(t1));
		
		assertFalse(t1.equals(t3));
		assertFalse(t3.equals(t1));
	}
	
	/**
	 * Tests Task's hashCode method.
	 */
	@Test
	public void testHashCode() {
		Task t1 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "t1id");
		Task t2 = new Task(t2Title, t2Details, t2StartTime, t2DueTime, testCat, "t1id");
		Task t3 = new Task(t1Title, t1Details, t1StartTime, t1DueTime, testCat, "t3id");
		
		assertTrue(t1.hashCode() == t2.hashCode());
		assertFalse(t1.hashCode() == t3.hashCode());
	}
}
