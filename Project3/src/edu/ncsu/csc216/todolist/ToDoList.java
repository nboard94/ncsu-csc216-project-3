package edu.ncsu.csc216.todolist;

import java.io.*;
import java.util.*;

import edu.ncsu.csc216.todolist.model.CategoryList;
import edu.ncsu.csc216.todolist.model.TaskList;

/**
 * The main class for the ToDoList program.  Holds references to the top-level 
 * data structures that contain Task and Category objects and acts as the controller
 * between the model and the GUI presentation view.
 * 
 * @author David Wright
 * @version 1.0
 * 
 */
public class ToDoList extends Observable implements Serializable, Observer {
	
	// ===== VARIABLES =====
	/** The todo list's serial ID */
	private static final long serialVersionUID = 34992L;
	/** Increment for increasing the capacity of the array of TaskLists */
	private static final int RESIZE = 3;
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
		
	}
	
	/**
	 * Returns if the todo list has been changed or not
	 * @return The current changed value.
	 */
	public boolean isChanged() {
		return false;
	}
	
	/**
	 * Sets the 'changed' variable to the given parameter
	 * @param b the value to set 'changed' to
	 */
	public void setChanged(boolean b) {
		
	}
	
	/**
	 * Gets this todo list's file name
	 * @return The name of the file for this list
	 */
	public String getFilename() {
		return null;
	}
	
	/**
	 * Sets the file name for this list to the given parameter
	 * @param s The new file name
	 */
	public void setFilename(String s) {
		
	}
	
	/**
	 * Gets the next task list number
	 * @return The next number in the task list
	 */
	private int getNextTaskListNum() {
		return 0;
	}
	
	/**
	 * Increments the task list number
	 */
	private void incNextTaskListNum() {
		
	}
	
	/**
	 * Gets the number of task lists in this todo list
	 * @return The total number of task lists inside of this todo list
	 */
	public int getNumTaskLists() {
		return 0;
	}
	
	/**
	 * Gets the task list at the given index inside this todo list
	 * @param idx The index of the task list to retrieve
	 * @return The task list at the given index
	 */
	public TaskList getTaskList(int idx) {
		return null;
	}
	
	/**
	 * Gets the list of categories inside this todo list
	 * @return The list of categories as a CategoryList
	 */
	public CategoryList getCategoryList() {
		return null;
	}
	
	/**
	 * TODO: Find out how this adds new task lists?
	 * @return the index of the newly added tasklist
	 */
	public int addTaskList() {
		return 0;
	}
	
	/**
	 * Removes a tasklist from this todo list given it's index in the array
	 * @param idx the index of the tasklist to remove
	 */
	public void removeTaskList(int idx) {
		
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

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
	
}