package edu.ncsu.csc216.todolist.ui;

import java.awt.Component;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;

import edu.ncsu.csc216.todolist.model.TaskList;

/**
 * Maintains a list of Tasks.
 * @author Nicholas Board and Christian Byrnes
 */
public class TaskListPane extends Component implements Observer, Serializable {

	/** Serial version UID */
	private static final long serialVersionUID = -2210716111020406799L;
	/** List of tasks to display */
	private TaskList tasks;
	/** TaskTableModel which displays the list of tasks */
	private TaskTableModel ttm;
	/** Table for the tasks */
	private JTable table;
	/** Width of columns */
	private int[] coldWidths;
	
	
	/**
	 * Creates the TaskListPane that shows the TaskData in a table.
	 * @param taskList TaskList of Task objects.
	 */
	public TaskListPane(TaskList taskList) {
		
	}
	
	/**
	 * Returns the TaskTableModel.
	 * @return the TaskTableModel
	 */
	public TaskTableModel getTaskTableModel() {
		return null;
	}

	/**
	 * Returns the JTable
	 * @return the JTable
	 */
	public JTable getTable() {
		return null;
	}
	
	/**
	 * Initializes the view by creating the JTable (that is wrapped in JScrollPane)
	 * and associating the JTable with the TaskTableModel.
	 */
	private void initView() {
		
	} 
	
	/**
	 * Clears the selection.
	 */
	public void clearSelection() {
		
	}
	
	/**
	 * This method is called by the observed object, whenever the observed object
	 * is changed.  In this case, the observed object is the TaskList. Any changes 
	 * to the TaskList will lead to an update of the TaskTableModel.
	 * @param o the observable object
	 * @param arg any additional information needed about the change.
	 */
	public void update(Observable o, Object arg) {
		
	}
}
