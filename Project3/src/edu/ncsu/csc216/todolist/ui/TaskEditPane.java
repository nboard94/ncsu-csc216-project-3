package edu.ncsu.csc216.todolist.ui;

import java.awt.Color;
import java.awt.Component;
import java.io.Serializable;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.ncsu.csc216.todolist.model.Category;
import edu.ncsu.csc216.todolist.model.CategoryList;

/**
 * Panel for editing Tasks.
 * @author Nicholas Board and Christian Byrnes
 */
public class TaskEditPane extends Component implements Serializable {
	
	/** Serial version UID */
	private static final long serialVersionUID = 5479139338455751629L;
	/** The categories that tasks can be in */
	private CategoryList categories;
	/** Text field for taskID */
	private JTextField taskID;
	/** Text field for taskTitle */
	private JTextField taskTitle;
	/** Combo box for task's category */
	private JComboBox<Category> taskCat;
	/** Text area for task details */
	private JTextArea taskDetails;
	/** Spinner for start date */
	private JSpinner taskStart;
	/** Spinner for due date */
	private JSpinner taskDue;
	/** Spinner for completed date */
	private JSpinner taskCompleted;
	/** Checkbox for completed */
	private JCheckBox complete;
	/** Represents in the add state */
	private boolean add;
	/** Represents in the edit state */
	private boolean edit;
	/** TaskData data */
	private TaskData data;
	
	/**
	 * Constructor for a task edit panel.
	 * @param c CategoryList used to populate the pane
	 */
	public TaskEditPane(CategoryList c) {
		super();
		categories = c;
		add = false;
		edit = false;
		init();
	}
	
	/**
	 * Constructor for a task edit panel.
	 * @param t TaskData used the populate the pane
	 * @param c CategoryList used to populate the pane
	 */
	public TaskEditPane(TaskData t, CategoryList c) {
		super();
		categories = c;
		data = t;
		add = false;
		edit = false;
		init();
	}
	
	/**
	 * Initializes the GUI.
	 */
	private void init() {
		initView();
		fillFields();
	}
	
	/**
	 * Initializes the view.
	 */
	private void initView() {
		
	}
	
	/**
	 * Returns the spinner for TaskStart.
	 * @return the spinner for TaskStart.
	 */
	JSpinner getTaskStartSpinner() {
		return this.taskStart;
	}
	
	/**
	 * Returns the spinner for TaskDue.
	 * @return the spinner for TaskDue.
	 */
	JSpinner getTaskDueSpinner() {
		return this.taskDue;
	}
	
	/**
	 * Returns the spinner for TaskCompleted.
	 * @return the spinner for TaskCompleted.
	 */
	JSpinner getTaskCompletedSpinner() {
		return this.taskCompleted;
	}
	
	/**
	 * Returns the task start date.
	 * @return the task start date.
	 */
	Date getTaskStart() {
		return this.data.getStartDateTime();
	}
	
	/**
	 * Returns the task due date.
	 * @return the task due date.
	 */
	Date getTaskDue() {
		return this.data.getDueDateTime();
	}
	
	/**
	 * Returns the task completed date.
	 * @return the task completed date.
	 */
	Date getTaskCompleted() {
		return this.data.getCompletedDateTime();
	}
	
	/**
	 * Returns the text field for taskID.
	 * @return the text field for taskID.
	 */
	JTextField getTaskID() {
		return this.taskID;
	}
	
	/**
	 * Returns the text field for taskTitle.
	 * @return the text field for taskTitle.
	 */
	JTextField getTaskTitle() {
		return this.taskTitle;
	}
	
	/**
	 * Returns the combo box for task's categories.
	 * @return the combo box for task's categories.
	 */
	JComboBox<Category> getCategory() {
		return taskCat;
	}
	
	/**
	 * Returns the text area for the taskDetails.
	 * @return the test area for the taskDetauls.
	 */
	JTextArea getTaskDetails() {
		return this.taskDetails;
	}
	
	/**
	 * Returns the check box for task complete.
	 * @return the check box for task complete.
	 */
	JCheckBox getComplete() {
		return this.complete;
	}
	
	/**
	 * Sets the start date for the Task.
	 * @param d the start date for the Task.
	 */
	void setTaskStart(Date d) {
		this.taskStart.setValue(d);;
	}
	
	/**
	 * Sets the due date for the Task.
	 * @param d the due date for the Task.
	 */
	void setTaskDue(Date d) {
		this.taskDue.setValue(d);
	}
	
	/**
	 * Sets the completed date for the Task.
	 * @param d the completed date for the Task.
	 */
	void setTaskCompleted(Date d) {
		this.taskCompleted.setValue(d);
	}
	
	/**
	 * Returns true if in add mode.
	 * @return true if in add mode
	 */
	boolean isAddMode() {
		return add;
	}
	
	/**
	 * Returns true if in edit mode.
	 * @return true if in edit mode.
	 */
	boolean isEditMode() {
		return edit;
	}
	
	/**
	 * Enables add mode and disables edit.
	 */
	void enableAdd() {
		add = true;
		disableEdit();
	}
	
	/**
	 * Disables add mode.
	 */
	void disableAdd() {
		add = false;
	}
	
	/**
	 * Enables edit mode and disables add.
	 * @param t TaskData to populate the edit area with.
	 */
	void enableEdit(TaskData t) {
		edit = true;
		disableAdd();
		
		this.setTaskData(t);
	}
	
	/**
	 * Disables edit mode.
	 */
	void disableEdit() {
		edit = false;
		clearFields();
	}
	
	/**
	 * Returns true if the required fields are not empty.
	 * @return true if the required fields are not empty.
	 */
	boolean fieldsNotEmpty() {
		return false;
	}
	
	/**
	 * Initializes the TaskData to the given value.
	 * @param t new TaskData
	 */
	void setTaskData(TaskData t) {
		data = t;
	}
	
	/**Adds the given EventListner to the txtTaskName and
	 * txtTaskDescription text fields.
	 * @param e EventListner to add to text fields.
	 */
	void addFieldListener(EventListener e) {
		
	}
	
	/**
	 * Fills the fields with the appropriate text from the CategoryData field.
	 */
	void fillFields() {
//		/** Combo box for task's category */
//		private JComboBox<Category> taskCat;
		
		//set task fields
		taskID.setText(data.getTaskID());
		taskTitle.setText(data.getTitle());
		taskDetails.setText(data.getDetails());
		taskStart.setValue(data.getStartDateTime());
		taskDue.setValue(data.getDueDateTime());
		taskCompleted.setValue(data.getCompletedDateTime());
		
		//grab the array of categories, then set the combobox
		taskCat = new JComboBox<Category>();
		for (int i = 0; i < categories.size(); i++) {
			taskCat.addItem(categories.getCategoryAt(i));
		}
	}
	
	/**
	 * Clears the fields by setting data to null.
	 */
	void clearFields() {
		data = null;
	}
	
	/**
	 * Returns the fields as a TaskData object.
	 * @return the fields as a TaskData object.
	 */
	TaskData getFields() {
		return data;
	}
	
	/**
	 * This method is called by the observed object, whenever the observed object
	 * is changed.  In this case, the observed object is the TaskPane. Any changes 
	 * to the TaskPane will lead to an update of the TaskTableModel.
	 * @param o the observable object
	 * @param args any additional information needed about the change.
	 */
	public void update(Observable o, Object args) {
		
	}
}
