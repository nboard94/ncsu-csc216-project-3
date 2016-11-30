package edu.ncsu.csc216.todolist.ui;

import java.io.Serializable;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * TaskTableModel is a wrapper for the information in TaskList that 
 * can be used by a JTable. 
 * @author Nicholas Board and Christian Byrnes
 */
public class TaskTableModel extends AbstractTableModel implements Serializable, TableModel {

	/** Serial version UID */
	private static final long serialVersionUID = 5954551753060998701L;
	/** Names for each of the columns in the TableModel */
	private String[] colNames = {"ID", "Task Name", "Task Description"};
	/** Array of CategoryList information */
	private Object[][] data;
	
	/**
	 * Creates the model from the given data.
	 * @param data the data to populate the TableModel
	 */
	public TaskTableModel(Object[][] data) {
		super();
		this.data = data;
	}
	
	/**
	 * Returns the number of rows in the data.
	 * @return the number of rows in the data
	 */
	public int getRowCount() {
		return data.length;
	}
	
	/**
	 * Returns the number of columns in the data.
	 * @return the number of columns in the data 
	 */
	public int getColumnCount() {
		return colNames.length;
	}
	
	/**
	 * Returns the column name at the given index.
	 * @param col the index for finding the column name
	 * @return the column name at the given index
	 */
	public String getColumnName(int col) {
		return colNames[col];
	}
	
	/**
	 * Returns the value at the given cell in the TableModel.
	 * @param row the index for the row
	 * @param col the index for the column
	 * @return the value in the data at the given row and col
	 */
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	/**
	 * Sets the value to the given cell in the TableModel.
	 * @param value the value to set
	 * @param row the index for the row
	 * @param col the index for the column
	 */
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);	
	}
	
	/**
	 * Returns the TaskData object associated with the given
	 * row in the TableModel.
	 * @param row the TaskData to return
	 * @return the TaskData for the given row
	 */
	public TaskData getTaskRowData(int row) {
		return null;
	}
	
	/**
	 * Sets the given row with the provided TaskData.
	 * @param d TaskyData to set in the row
	 * @param row the row to set
	 */
	public void setTaskRowRata(int d, TaskData row) {
		
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
}
