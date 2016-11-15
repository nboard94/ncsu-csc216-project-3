package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

import edu.ncsu.csc216.todolist.util.LinkedList;

/**
 * The TaskList is responsible for keeping track for a list of Tasks.
 * @author Christian Byrnes, Nick Board
 *
 */
public class TaskList extends Observable implements Tabular, Serializable {

	/** The serial id */
	private static final long serialVersionUID = 98734509L;
	/** The name of this list */
	private String name;
	/** The next task number for this list */
	private int nextTaskNum;
	/** This task list's id */
	private String taskListID;
	/** The list of tasks held and managed by this tasklist */
	private LinkedList list;
	
	/**
	 * Creates a new TaskList given 
	 * @param name the name of this tasklist
	 * @param taskListID this tasklist's new ID
	 */
	public TaskList(String name, String taskListID) {
		
	}
	
	/**
	 * Gets the name of this TaskList
	 * @return This tasklist's name 
	 */
	public String getName() {
		return null;
	}
	
	/**
	 * Sets the name of this tasklist to the given parameter
	 * @param name the new name to assign to this tasklist
	 */
	public void setName(String name) {
		
	}
	
	/**
	 * Gets this tasklist's ID
	 * @return The ID of this tasklist
	 */
	public String getTaskListID() {
		return null;
	}
	
	/**
	 * Sets this tasklist's ID
	 * @param taskListID the new ID for this tasklist
	 */
	private void setTaskListID(String taskListID) {
		
	}
	
	/**
	 * Gets the next task list number for this list
	 * @return the next ID number for this list, to be assigned to the next task added
	 */
	private int getNextTaskNum() {
		return 0;
	}
	
	/**
	 * Increments the task list number for this list
	 */
	private void incNextTaskNum() {
		
	}
	
	/**
	 * Adds a new Task to this list given the proper Task parameters.
	 * @param title The title of the new task
	 * @param description The new task's description
	 * @param start The start date for this task
	 * @param due The due date for this task
	 * @param c The category this task is a part of
	 * @return True if the task is successfully added to the TaskList
	 */
	public boolean addTask(String title, String description, Date start, Date due, Category c) {
		return false;
	}
		
	/**
	 * Gets the task at the given index in the list
	 * @param idx The index of the task to retrieve
	 * @return The task at the given index in this TaskList
	 */
	public Task getTaskAt(int idx) {
		return null;
	}
	
	/**
	 * Gets the index of a task given its title as a String
	 * @param title The title of the task to retrieve
	 * @return The index of the task with the given title, or -1 if no such task exists.
	 */
	public int indexOf(String title) {
		return 0;
	}
	
	/**
	 * Gets the size of this tasklist
	 * @return the size of this tasklist
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * Checks if this tasklist is empty and returns the results.
	 * @return True if the tasklist is currently empty
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * Removes a task from the TaskList given its index
	 * @param idx The index of the task to remove
	 * @return The Task that has been removed from this TaskList
	 */
	public Task removeTaskAt(int idx) {
		return null;
	}
	
	/**
	 * Removes a task from this list given it's string ID
	 * @param taskID The ID of the task to remove
	 * @return True if the task has been removed
	 */
	public boolean removeTask(String taskID) {
		return false;
	}
	
	/**
	 * Gets a 2D array of all the Tasks in this TaskList
	 * @return A 2D array of all the tasks in this list; each row is a Task, and each column contains the task's data
	 */
	public Object[][] get2DArray() {
		return null;
	}
	
	/**
	 * Updates the TaskList if any changes occurred in any of the tasks inside of it
	 * @param o The Observable to be observed for changes
	 * @param arg The arguments to pass on to notifyObserver()
	 */
	public void update(Observable o, Object arg) {
		
	}
}
