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
	 * @throws IllegalArgumentException if the name or id are null or empty
	 */
	public TaskList(String name, String taskListID) {
		//check for rotten apples
		if (name == null || taskListID == null ||
				name.trim().equals("") || taskListID.trim().equals("")) throw new IllegalArgumentException();
		
		//plant the strings!
		setName(name);
		setTaskListID(taskListID);
		
		//initialize the nextTaskNum and list
		nextTaskNum = 1;
		list = new LinkedList();
	}
	
	/**
	 * Gets the name of this TaskList
	 * @return This tasklist's name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of this tasklist to the given parameter
	 * @param name the new name to assign to this tasklist
	 * @throws IllegalArgumentException if the name is null or empty
	 */
	public void setName(String name) {
		if (name == null || name.trim().equals("")) throw new IllegalArgumentException();
		this.name = name;
	}
	
	/**
	 * Gets this tasklist's ID
	 * @return The ID of this tasklist
	 */
	public String getTaskListID() {
		return taskListID;
	}
	
	/**
	 * Sets this tasklist's ID
	 * @param taskListID the new ID for this tasklist
	 */
	private void setTaskListID(String taskListID) {
		this.taskListID = taskListID;
	}
	
	/**
	 * Gets the next task list number for this list
	 * @return the next ID number for this list, to be assigned to the next task added
	 */
	private int getNextTaskNum() {
		return nextTaskNum;
	}
	
	/**
	 * Increments the task list number for this list
	 */
	private void incNextTaskNum() {
		nextTaskNum++;
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
		//check for illegal values
		if (	title == null || title.trim().equals("") ||
				description == null || description.trim().equals("") ||
				start == null || due == null || c == null) return false;
		
		//if we're all clear, lets turn the given data into a task!
		String nextID = this.getNextTaskNum() + "-T";
		Task newTask = new Task(title, description, start, due, c, nextID);
		
		//if this is the first task we're adding, lets just add it directly
		if (list.isEmpty()) {
			list.add(newTask);
			this.incNextTaskNum();
			return true;
		}
			
		//the list is sorted by due date, with the soonest due date at the beginning of the list.
		//once we find a task due date that's later than the one we've been given, we'll insert our
		//task into the list before that one.
		boolean spotFound = false;
		int spotIdx = 0;
		
		//iterate through the list until a spot is found
		while (!spotFound) {
			
			//if the spotIdx is equal to size, we'll be adding the task to the end of the list
			if (spotIdx == list.size()) {
				list.add(newTask);
				this.incNextTaskNum();
				return true;
			}
			
			//if it's not equal to size, we'll roll through the list till we're good
			Task current = (Task) list.get(spotIdx);
			//compare current and newtask
			int compare = current.compareTo(newTask);
			
			//if compare is greater than or equal to zero, insert into list at this index,figure out if this needs to be reverse
			if (compare >= 0) {
				list.add(spotIdx, newTask);
				this.incNextTaskNum();
				return true;
			}
			
			//if that compare didn't work, increment the spotIdx before restarting this loop
			spotIdx++;
		} 
		
		//you shouldn't end out here, i don't think.. but just in case return false
		return false;
	}
		
	/**
	 * Gets the task at the given index in the list
	 * @param idx The index of the task to retrieve
	 * @return The task at the given index in this TaskList
	 */
	public Task getTaskAt(int idx) {
		return (Task) list.get(idx);
	}
	
	/**
	 * Gets the index of a task given its title as a String
	 * @param title The title of the task to retrieve
	 * @return The index of the task with the given title, or -1 if no such task exists.
	 */
	public int indexOf(String title) {
		
		//search the list for the given title
		for (int i = 0; i < list.size(); i++) {
			Task current = (Task) list.get(i);
			if (current.getTitle().equals(title)) return i;
		}
		
		//if you're out here the title isn't in the list
		return -1;
	}
	
	/**
	 * Gets the size of this tasklist
	 * @return the size of this tasklist
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Checks if this tasklist is empty and returns the results.
	 * @return True if the tasklist is currently empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Removes a task from the TaskList given its index
	 * @param idx The index of the task to remove
	 * @return The Task that has been removed from this TaskList
	 */
	public Task removeTaskAt(int idx) {
		return (Task) list.remove(idx);
	}
	
	/**
	 * Removes a task from this list given it's string ID
	 * @param taskID The ID of the task to remove
	 * @return True if the task has been removed
	 */
	public boolean removeTask(String taskID) {
		//search the list for the task id
		for (int i = 0; i < list.size(); i++) {
			Task current = (Task) list.get(i);
			
			if (current.getTaskID().equals(taskID)) {
				list.remove(i);
				return true;
			}
		}
		
		//if you're out here the given ID wasn't in the list
		return false;
	}
	
	/**
	 * Gets a 2D array of all the Tasks in this TaskList
	 * @return A 2D array of all the tasks in this list; each row is a Task, and each column contains the task's data
	 */
	public Object[][] get2DArray() {
		//the 2d array we'll return at the end
		Object[][] array;
		
		//if the list is currently empty, then return an empty array
		if (this.isEmpty()) return new Object[0][0];
		
		//otherwise, we'll fill 'em up
		//size() rows, 8 columns.
		array = new Object[size()][8];
		
		for (int i = 0; i < size(); i++) {
			Task current = (Task) list.get(i);
			array[i][0] = current.getTaskID();
			array[i][1] = current.getTitle();
			array[i][2] = current.getCategory();
			array[i][3] = current.getStartDateTime();
			array[i][4] = current.getDueDateTime();
			array[i][5] = current.getCompletedDateTime();
			array[i][6] = current.isCompleted();
			array[i][7] = current.getDetails();
		}
		
		//return it once it's all filled out!
		return array;
	}
	
	/**
	 * Updates the TaskList if any changes occurred in any of the tasks inside of it
	 * @param o The Observable to be observed for changes
	 * @param arg The arguments to pass on to notifyObserver()
	 */
	public void update(Observable o, Object arg) {
		boolean hasCategory = false;
		//the observable item in question should be category, so make sure it's a category
		try {
			Task c = (Task) o;
			if (list.contains(c)) hasCategory = true;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		if (!hasCategory) throw new IllegalArgumentException();
		
		this.notifyObservers(arg); //TODO: Do we need to do anything else here?
		
	}
}
