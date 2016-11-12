package edu.ncsu.csc216.todolist.ui;

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

public class TaskEditPane {
	
	private static final long serialVersionUID = 0;
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
	
	public TaskEditPane(CategoryList c) {
		
	}
	
	public TaskEditPane(TaskData t, CategoryList c) {
		
	}
	
	private void init() {
		
	}
	
	private void initView() {
		
	}
	
	JSpinner getTaskStartSpinner() {
		return null;
	}
	
	JSpinner getTaskDueSpinner() {
		return null;
	}
	
	JSpinner getTaskCompletedSpinner() {
		return null;
	}
	
	Date getTaskStart() {
		return null;
	}
	
	Date getTaskDue() {
		return null;
	}
	
	Date getTaskCompleted() {
		return null;
	}
	
	JTextField getTaskID() {
		return null;
	}
	
	JTextField getTaskTitle() {
		return null;
	}
	
	JComboBox<Category> getCategory() {
		return null;
	}
	
	JTextArea getTaskDetails() {
		return null;
	}
	
	JCheckBox getComplete() {
		return null;
	}
	
	void setTaskStart(Date d) {
		
	}
	
	void setTaskDue(Date d) {
		
	}
	
	void setTaskCompleted(Date d) {
		
	}
	
	boolean isAddMode() {
		return false;
	}
	
	boolean isEditMode() {
		return false;
	}
	
	void enableAdd() {
		
	}
	
	void disableAdd() {
		
	}
	
	void enableEdit(TaskData t) {
		
	}
	
	void disableEdit() {
		
	}
	
	boolean fieldsNotEmpty() {
		return false;
	}
	
	void setTaskData(TaskData t) {
		
	}
	
	void addFieldListener(EventListener e) {
		
	}
	
	void fillFields() {
		
	}
	
	void clearFields() {
		
	}
	
	TaskData getFields() {
		return null;
	}
	
	public void update(Observable o1, Object o2) {
		
	}
}
