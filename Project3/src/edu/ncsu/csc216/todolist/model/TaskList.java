package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.todolist.util.LinkedList;

/**
 * The TaskList is responsible for keeping track for a list of Tasks.
 * @author Christian Byrnes, Nick Board
 *
 */
public class TaskList extends Observable implements Observer, Tabular, Serializable {

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
		this.setChanged();
		this.notifyObservers(this);
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
		this.setChanged();
		this.notifyObservers(this);
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
	

	public boolean addTask(String newTitle, String newDescription, Date newStart, Date newDue, Category newCat) {
		
		String newID = this.taskListID + "-T" + this.getNextTaskNum();
		Task newTask = new Task(newTitle, newDescription, newStart, newDue, newCat, newID);
		
		if (list.isEmpty()) {
			list.add(newTask);
			this.incNextTaskNum();
			this.setChanged();
			this.notifyObservers(this);
			return true;
		} 
		else {
			for (int i = 0; i < list.size(); i++) {
				if (((Task) list.get(i)).compareTo(newTask) < 0) {
					list.add(i, newTask);
					this.incNextTaskNum();
					this.setChanged();
					this.notifyObservers(this);
					return true;
				}
			}
		}
		
		return false;
	} 
		
		
//		for (int i = 0; i < list.size(); i++) {
//			Task currentTask = (Task) list.get(i);
//			int compare = currentTask.compareTo(newTask);
//	
//			if (compare < 0) {
//				list.add(i, newTask);
//				newTask.addObserver(this);
//				this.incNextTaskNum();
//				this.setChanged();
//				this.notifyObservers(this);
//				return true;
//			}
//			else if (i == size() - 1){
//				list.add(list.size(), newTask);
//				newTask.addObserver(this);
//				this.incNextTaskNum();
//				this.setChanged();
//				this.notifyObservers(this);
//				return true;
//			}
//		}
//
//
//		//you shouldn't end out here, i don't think.. but just in case return false
//		return false;
//	}
	

		
	/**
	 * Gets the task at the given index in the list
	 * @param idx The index of the task to retrieve
	 * @return The task at the given index in this TaskList
	 */
	public Task getTaskAt(int idx) {
		return (Task) list.get(idx);
	}
	
	/**
	 * Gets the index of a task given its id as a String
	 * @param id The id of the task to retrieve
	 * @return The index of the task with the given id, or -1 if no such task exists.
	 */
	public int indexOf(String id) {
		
		//maybe null check
		//maybe switch equals
		//search the list for the given title
		for (int i = 0; i < list.size(); i++) {
			Task current = (Task) list.get(i);
			if (current.getTaskID().equals(id)) 
				return i;
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
		Task t = (Task) list.remove(idx);
		t.deleteObserver(this);
		this.setChanged();
		this.notifyObservers(this);
		return t;
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
				Task t = (Task) list.remove(i);
				t.deleteObserver(this);
				this.setChanged();
				this.notifyObservers(this);
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
		if (list.contains(o)) {
			this.setChanged();
			this.notifyObservers(arg);
		}
	}
}
