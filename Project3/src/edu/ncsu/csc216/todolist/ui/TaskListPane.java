package edu.ncsu.csc216.todolist.ui;

import java.util.Observable;

import javax.swing.JTable;

import edu.ncsu.csc216.todolist.model.TaskList;

public class TaskListPane {

	private static final long serialVersionUID = 0;
	private TaskList tasks;
	private TaskTableModel ttm;
	private JTable table;
	private int[] coldWidths;
	
	public TaskListPane(TaskList t) {
		
	}
	
	public TaskTableModel getTaskTableModel() {
		return null;
	}

	public JTable getTable() {
		return null;
	}
	
	private void initView() {
		
	} 
	
	public void clearSelection() {
		
	}
	
	public void update(Observable o1, Object o2) {
		
	}
}
