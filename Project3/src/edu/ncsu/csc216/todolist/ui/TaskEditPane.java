package edu.ncsu.csc216.todolist.ui;

import java.awt.Component;
import java.io.Serializable;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;

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
	private CategoryList categories;
	private JTextField taskID;
	private JTextField taskTitle;
	private JComboBox<Category> taskCat;
	private JTextArea taskDetails;
	private JSpinner taskStart;
	private JSpinner taskDue;
	private JSpinner taskCompleted;
	private JCheckBox complete;
	private boolean add;
	private boolean edit;
	private TaskData data;
	
	/**
	 * @param c
	 */
	public TaskEditPane(CategoryList c) {
		
	}
	
	public TaskEditPane(TaskData t, CategoryList c) {
		
	}
	
	/**
	 * Initializes the GUI.
	 */
	private void init() {
		
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
		return null;
	}
	
	/**
	 * Returns the spinner for TaskDue.
	 * @return the spinner for TaskDue.
	 */
	JSpinner getTaskDueSpinner() {
		return null;
	}
	
	/**
	 * Returns the spinner for TaskCompleted.
	 * @return the spinner for TaskCompleted.
	 */
	JSpinner getTaskCompletedSpinner() {
		return null;
	}
	
	/**
	 * Returns the task start date.
	 * @return the task start date.
	 */
	Date getTaskStart() {
		return null;
	}
	
	/**
	 * Returns the task due date.
	 * @return the task due date.
	 */
	Date getTaskDue() {
		return null;
	}
	
	/**
	 * Returns the task completed date.
	 * @return the task completed date.
	 */
	Date getTaskCompleted() {
		return null;
	}
	
	/**
	 * Returns the text field for taskID.
	 * @return the text field for taskID.
	 */
	JTextField getTaskID() {
		return null;
	}
	
	/**
	 * Returns the text field for taskTitle.
	 * @return the text field for taskTitle.
	 */
	JTextField getTaskTitle() {
		return null;
	}
	
	/**
	 * Returns the combo box for task's categories.
	 * @return the combo box for task's categories.
	 */
	JComboBox<Category> getCategory() {
		return null;
	}
	
	/**
	 * Returns the text area for the taskDetails.
	 * @return the test area for the taskDetauls.
	 */
	JTextArea getTaskDetails() {
		return null;
	}
	
	/**
	 * Returns the check box for task complete.
	 * @return the check box for task complete.
	 */
	JCheckBox getComplete() {
		return null;
	}
	
	/**
	 * Sets the start date for the Task.
	 * @param d the start date for the Task.
	 */
	void setTaskStart(Date d) {
		
	}
	
	/**
	 * Sets the due date for the Task.
	 * @param d the due date for the Task.
	 */
	void setTaskDue(Date d) {
		
	}
	
	/**
	 * Sets the completed date for the Task.
	 * @param d the completed date for the Task.
	 */
	void setTaskCompleted(Date d) {
		
	}
	
	/**
	 * Returns true if in add mode.
	 * @return true if in add mode
	 */
	boolean isAddMode() {
		return false;
	}
	
	/**
	 * Returns true if in edit mode.
	 * @return true if in edit mode.
	 */
	boolean isEditMode() {
		return false;
	}
	
	/**
	 * Enables add mode and disables edit.
	 */
	void enableAdd() {
		
	}
	
	/**
	 * Disables add mode.
	 */
	void disableAdd() {
		
	}
	
	/**
	 * Enables edit mode and disables add.
	 * @param t TaskData to populate the edit area with.
	 */
	void enableEdit(TaskData t) {
		
	}
	
	/**
	 * Disables edit mode.
	 */
	void disableEdit() {
		
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
		
	}
	
	/**
	 * Clears the fields by setting data to null.
	 */
	void clearFields() {
		
	}
	
	/**
	 * Returns the fields as a TaskData object.
	 * @return the fields as a TaskData object.
	 */
	TaskData getFields() {
		return null;
	}
	
	public void update(Observable o1, Object o2) {
		
	}
}
