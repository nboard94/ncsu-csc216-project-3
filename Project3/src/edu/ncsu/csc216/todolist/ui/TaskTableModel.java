package edu.ncsu.csc216.todolist.ui;

import java.io.Serializable;

public class TaskTableModel implements Serializable {

	private static final long serialVersionUID = 5954551753060998701L;
	private String[] colNames;
	private Object[][] data;
	
	public TaskTableModel(Object[][] o) {
		
	}
	
	public int getRowCount() {
		return 0;
	}
	
	public int getColumnCount() {
		return 0;
	}
	
	public String getColumnName(int i) {
		return null;
	}
	
	public Object getValueAt(int i1, int i2) {
		return null;
	}
	
	public void setValueAt(Object i, int i1, int i2) {
		
	}
	
	public TaskData getTaskRowData(int i) {
		return null;
	}
	
	public void setTaskRowRata(int i, TaskData t) {
		
	}
}
