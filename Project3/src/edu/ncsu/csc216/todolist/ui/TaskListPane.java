package edu.ncsu.csc216.todolist.ui;

import java.awt.Component;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import edu.ncsu.csc216.todolist.model.CategoryList;
import edu.ncsu.csc216.todolist.model.TaskList;

/**
 * Maintains a list of Tasks.
 * @author Nicholas Board and Christian Byrnes
 */
public class TaskListPane extends Component implements Observer, Serializable {

	/** Serial version UID */
	private static final long serialVersionUID = -2210716111020406799L;
	/** List of tasks to display */
	private TaskList taskList;
	/** TaskTableModel which displays the list of tasks */
	private TaskTableModel taskTableModel;
	/** Table for the tasks */
	private JTable table;
	/** Width of columns */
	private int[] colWidths = {50, 250, 750};
	
	
	/**
	 * Creates the TaskListPane that shows the TaskData in a table.
	 * @param taskList TaskList of Task objects.
	 */
	public TaskListPane(TaskList taskList) {
		super();
		this.taskList = taskList;
		
		this.taskList.addObserver(this);
		taskTableModel = new TaskTableModel(taskList.get2DArray());
		initView();
	}
	
	/**
	 * Returns the TaskTableModel.
	 * @return the TaskTableModel
	 */
	public TaskTableModel getTaskTableModel() {
		return taskTableModel;
	}

	/**
	 * Returns the JTable
	 * @return the JTable
	 */
	public JTable getTable() {
		return table;
	}
	
	/**
	 * Initializes the view by creating the JTable (that is wrapped in JScrollPane)
	 * and associating the JTable with the TaskTableModel.
	 */
	private void initView() {
		table = new JTable(taskTableModel);

		
		for (int i = 0; i < colWidths.length; i++) {
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(colWidths[i]);
		}
		
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(false);
		//setViewportView(table);
	} 
	
	/**
	 * Clears the selection.
	 */
	public void clearSelection() {
		table.clearSelection();
	}
	
	/**
	 * This method is called by the observed object, whenever the observed object
	 * is changed.  In this case, the observed object is the TaskList. Any changes 
	 * to the TaskList will lead to an update of the TaskTableModel.
	 * @param o the observable object
	 * @param arg any additional information needed about the change.
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof CategoryList) {
			CategoryList cl = (CategoryList)o;
			//If there is a different number of rows, create a show new CategoryTableModel.
			if (cl.size() != taskTableModel.getRowCount()) {
				 taskTableModel = new TaskTableModel(cl.get2DArray());
				 table.setModel(taskTableModel);
			} else {
				//Otherwise, just update the values directly.
				Object[][] arr = cl.get2DArray();
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < taskTableModel.getColumnCount(); j++) {
						taskTableModel.setValueAt(arr[i][j], i, j);
					}
				}
			}
		}
	}
}
