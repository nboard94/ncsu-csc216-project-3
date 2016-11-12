package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

import edu.ncsu.csc216.todolist.util.LinkedList;

public class TaskList extends Observable implements Tabular, Serializable {

	private static final long serialVersionUID = 98734509L;
	private String name;
	private int nextTaskNum;
	private String taskListID;
	private LinkedList list;
	
	public TaskList(String s1, String s2) {
		
	}
	
	public String getName() {
		return null;
	}
	
	public void setName(String s1) {
		
	}
	
	public String getTaskListID() {
		return null;
	}
	
	private void setTaskListID(String s1) {
		
	}
	
	private int getNextTaskNum() {
		return 0;
	}
	
	private void incNextTaskNum() {
		
	}
	
	public boolean addTask(String s1, String s2, Date d1, Date d2, Category c1) {
		return false;
	}
		
	public Task getTaskAt(int i) {
		return null;
	}
	
	public int indexOf(String s) {
		return 0;
	}
	
	public int size() {
		return 0;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public Task removeTaskAt(int i) {
		return null;
	}
	
	public boolean removeTask(String s) {
		return false;
	}
	
	public Object[][] get2DArray() {
		return null;
	}
	
	public void update(Observable o1, Object o2) {
		
	}
}
