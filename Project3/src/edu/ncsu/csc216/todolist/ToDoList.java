package edu.ncsu.csc216.todolist;

import java.io.*;
import java.util.*;

import edu.ncsu.csc216.todolist.model.Category;
import edu.ncsu.csc216.todolist.model.CategoryList;
import edu.ncsu.csc216.todolist.model.Task;
import edu.ncsu.csc216.todolist.model.TaskList;

/**
 * The main class for the ToDoList program.  Holds references to the top-level 
 * data structures that contain Task and Category objects and acts as the controller
 * between the model and the GUI presentation view.
 * 
 * @author David Wright, Christian Byrnes, Nick Board
 * @version 1.0
 * 
 */
public class ToDoList extends Observable implements Serializable, Observer {
	
	// ===== VARIABLES =====
	/** The todo list's serial ID */
	private static final long serialVersionUID = 34992L;
	/** Increment for increasing the capacity of the array of TaskLists */
	private static final int RESIZE = 10;
	/** The array of TaskLists in this todo list */
	private TaskList[] tasks;
	/** The number of lists inside this todo list */
	private int numLists;
	/** The list of categories in this list */
	private CategoryList categories;
	/** The name of the file this todo list is saved to */
	private String filename;
	/** Says if the todo list has been changed or not */
	private boolean changed;
	/** The number ID for the next task to be added to this list */
	private int nextTaskListNum;
	
	/**
	 * Constructs a new ToDoList
	 */
	public ToDoList() {
		//initalize the task list... list...?
		tasks = new TaskList[3];
		numLists = 0;
		
		//construct the categorylist
		categories = new CategoryList();
		categories.addObserver(this);
		
		//add a new list to the tasklist
		nextTaskListNum = 1;
		this.addTaskList();
		
		//initialize everythin else

		changed = false;
		
	}
	
	/**
	 * Returns if the todo list has been changed or not
	 * @return The current changed value.
	 */
	public boolean isChanged() {
		return changed;
	}
	
	/**
	 * Sets the 'changed' variable to the given parameter
	 * @param b the value to set 'changed' to
	 */
	public void setChanged(boolean b) {
		changed = b;
	}
	
	/**
	 * Gets this todo list's file name
	 * @return The name of the file for this list
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the file name for this list to the given parameter
	 * @param filename The new file name
	 * @throws IllegalArgumentException If the name is null or empty
	 */
	public void setFilename(String filename) {
		if (filename == null || filename.trim().equals("")) throw new IllegalArgumentException();
		this.filename = filename;
	}
	
	/**
	 * Gets the next task list number
	 * @return The next number in the task list
	 */
	private int getNextTaskListNum() {
		return nextTaskListNum;
	}
	
	/**
	 * Increments the task list number
	 */
	private void incNextTaskListNum() {
		nextTaskListNum++;
	}
	
	/**
	 * Gets the number of task lists in this todo list
	 * @return The total number of task lists inside of this todo list
	 */
	public int getNumTaskLists() {
		return numLists;
	}
	
	/**
	 * Gets the task list at the given index inside this todo list
	 * @param idx The index of the task list to retrieve
	 * @return The task list at the given index
	 * @throws IndexOutOfBoundsException if the index is less than zero or greater than or equal to size
	 */
	public TaskList getTaskList(int idx) {
		if (idx < 0 || idx >= getNumTaskLists()) throw new IndexOutOfBoundsException();
		
		return tasks[idx];
	}
	
	/**
	 * Gets the list of categories inside this todo list
	 * @return The list of categories as a CategoryList
	 */
	public CategoryList getCategoryList() {
		return categories;
	}
	
	/**
	 * Creates and adds a brand new tasklist to the todo list
	 * @return the index of the newly added tasklist
	 */
	public int addTaskList() {
		//create the new tasklist, increment the task list number
		TaskList newList = new TaskList("New List", "TL" + getNextTaskListNum());
		incNextTaskListNum();
		
		
		//if the array of tasklists is full, it's time to increase the size
		if (tasks.length == numLists) {
			
			//create the new array of tasklists, which should be the current size + 3
			TaskList[] oldArray = tasks;
			oldArray = null;
			oldArray = tasks;
	
			tasks = new TaskList[oldArray.length + RESIZE];
			
			//add all the old items to the new list
			for (int i = 0; i < oldArray.length; i++) {
				tasks[i] = oldArray[i];
			}
		}
		
		//add the new task list to the list
		tasks[numLists] = newList;
		tasks[numLists].addObserver(this);
		
		//grab the value, increment the numLists, then return the new list's index
		int index = numLists;
		numLists++;
		this.setChanged();
		this.notifyObservers(this);
		return index;
	}
	
	/**
	 * Removes a tasklist from this todo list given it's index in the array
	 * @param idx the index of the tasklist to remove
	 * @throw IndexOutOfBoundsException if the index is less than 0 or greater than/equal to size
	 */
	public void removeTaskList(int idx) {
		if (tasks[0] == null && idx == 0) {
			throw new IndexOutOfBoundsException();
		}
		
		//check for bad boiz
		if (idx < 0 || idx >= tasks.length) 
			throw new IndexOutOfBoundsException();
		
		//look this for loop over is things get rocky, it's probably this that's breaking...
		for (int i = idx; i < tasks.length; i++) {
			if (i + 1 == tasks.length) tasks[i] = null;
			else tasks[i] = tasks[i + 1];
		}
		
		numLists--;
	}
	
	/**
	 * Saves the CategoryList and the array of TaskLists to the given file using 
	 * object serialization.  
	 * @param fname filename to save ToDoList information to.
	 */
	public void saveDataFile(String fname) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fname);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for (int i = 0; i < numLists; i++) {
				out.writeObject(tasks[i]);
			}
			out.writeObject(categories);
			out.writeObject(filename);
			out.writeInt(nextTaskListNum);
			changed = false;
			out.close();
			fileOut.close();
		}
		catch (IOException e) {
			System.err.println("An error occurred while saving file " + fname);
			e.printStackTrace(System.err);
		}
	}
	
	/**
	 * Opens a data file with the given name and creates the data structures from 
	 * the serialized objects in the file.
	 * @param fname filename to create ToDoList information from.
	 */
	public void openDataFile(String fname) {
		if (changed) {
			saveDataFile(filename);
		}
		try {
			FileInputStream fileIn = new FileInputStream(fname);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<TaskList> temp = new ArrayList<TaskList>();
			Object tl = in.readObject();
			while (tl instanceof TaskList) {
				TaskList l = (TaskList)tl;
				l.addObserver(this);
				temp.add(l);
				tl = in.readObject();
			}
			tasks = new TaskList[RESIZE];
			tasks = temp.toArray(tasks);
			numLists = temp.size();
			categories = (CategoryList)tl;
			categories.addObserver(this);
			filename = (String)in.readObject();
			nextTaskListNum = (int)in.readInt();
			changed = false;
			in.close();
			fileIn.close();
			
		}
		catch (IOException e) {
			System.err.println("An error occurred while reading file " + fname);
			e.printStackTrace(System.err);
		}
		catch (ClassNotFoundException c) {
			System.err.println("Error reconstructing ToDoList from file " + fname);
			c.printStackTrace(System.err);
		}
	}

	/**
	 * Updates the TodoList given any updates in the observable object
	 * @param o the Observable object to watch for changes
	 * @param arg the arguments to pass up to notifyObservers()
	 */
	public void update(Observable o, Object arg) {
		if (o.equals(categories)) {
			changed = true;
			this.setChanged(true);
			this.notifyObservers();
		}
		else {
			for (int i = 0; i < tasks.length; i++) {
				if (o.equals(tasks[i])) {
					changed = true;
					this.setChanged(true);
					this.notifyObservers();
				}
			}
		}
	}
	
}