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
	
	
	private static final long serialVersionUID = 34992L;
	
	
	/**
	 * Increment for increasing the capacity of the array of TaskLists
	 */
	private static final int RESIZE = 3;
	
	
	private TaskList[] tasks;
	
	private int numLists;
	
	private CategoryList categories;
	
	private String filename;
	
	private boolean changed;
	
	private int nextTaskListNum;
	
	public ToDoList() {
		
	}
	
	public boolean isChanged() {
		return false;
	}
	
	public void setChanged(boolean b) {
		
	}
	
	public String getFilename() {
		return null;
	}
	
	public void setFilename(String s) {
		
	}
	
	private int getNextTaskListNum() {
		return 0;
	}
	
	private void incNextTaskListNum() {
		
	}
	
	public int getNumTaskLists() {
		return 0;
	}
	
	public TaskList getTaskList(int i) {
		return null;
	}
	
	public CategoryList getCategoryList() {
		return null;
	}
	
	public int addTaskList() {
		return 0;
	}
	
	public void removeTaskList(int i) {
		
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