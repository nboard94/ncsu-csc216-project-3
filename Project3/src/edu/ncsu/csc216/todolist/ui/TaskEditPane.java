package edu.ncsu.csc216.todolist.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import edu.ncsu.csc216.todolist.model.Category;
import edu.ncsu.csc216.todolist.model.CategoryList;

/**
 * Panel for editing Tasks.
 * @author Nicholas Board and Christian Byrnes
 */
public class TaskEditPane extends JPanel implements Serializable {
	
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
		//placeholder date
		Date date = new Date(200000000);
		data = new TaskData("", "", null, date, date, date, false, "");
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
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.black));
		initView();
		fillFields();
	}
	
	/**
	 * Initializes the view.
	 */
	private void initView() {
		//Create a jpanel to add the rows of the edit pane
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		// *** each time you add a new "row" to the editpane, reinitialize the jpanel
		
		//add taskid and task title
		p.add(new JLabel("Task ID: ", SwingConstants.LEFT));
		p.add(getTaskID());
		p.add(new JLabel("Task Title: "), SwingConstants.LEFT);
		p.add(getTaskTitle());
		this.add(p);
		
		//refresh p
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		//add category dropdown
		p.add(new JLabel("Category: ", SwingConstants.LEFT));
		p.add(getCategory());
		this.add(p);
		
		//refresh p
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		//add start date & time
		p.add(new JLabel("Start Date & Time: ", SwingConstants.LEFT));
		p.add(getTaskStartSpinner());
		this.add(p);
		
		//refresh p
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		//add due date & time
		p.add(new JLabel("Due Date & Time: ", SwingConstants.LEFT));
		p.add(getTaskDueSpinner());
		this.add(p);
		
		//refresh p
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		//add completed date & time + checkbox
		p.add(new JLabel("Completed Date & Time: ", SwingConstants.LEFT));
		p.add(getTaskCompletedSpinner());
		p.add(new JLabel("Completed? ", SwingConstants.LEFT));
		p.add(this.getComplete());
		this.add(p);

		//refresh p
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		//add task details label
		p.add(new JLabel("Task Details: ", SwingConstants.LEFT));
		this.add(p);
		
		//refresh p
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		//add task details textarea
		p.add(this.getTaskDetails());
		this.add(p);
		
	}
	
	/**
	 * Returns the spinner for TaskStart.
	 * @return the spinner for TaskStart.
	 */
	JSpinner getTaskStartSpinner() {
		if (taskStart == null) {
			taskStart = new JSpinner();

			SpinnerDateModel model = new SpinnerDateModel();
			taskStart.setModel(model);
			taskStart.setEnabled(false);
		}
		return this.taskStart;
	}
	
	/**
	 * Returns the spinner for TaskDue.
	 * @return the spinner for TaskDue.
	 */
	JSpinner getTaskDueSpinner() {
		if (taskDue == null) {
			taskDue = new JSpinner();
			
			SpinnerDateModel model = new SpinnerDateModel();
			taskDue.setModel(model);
			taskDue.setEnabled(false);
		}
		return this.taskDue;
	}
	
	/**
	 * Returns the spinner for TaskCompleted.
	 * @return the spinner for TaskCompleted.
	 */
	JSpinner getTaskCompletedSpinner() {
		if (taskCompleted == null) {
			taskCompleted = new JSpinner();


			SpinnerDateModel model = new SpinnerDateModel();
			taskCompleted.setModel(model);
			taskCompleted.setEnabled(false);
		}
		return this.taskCompleted;
	}
	
	/**
	 * Returns the task start date.
	 * @return the task start date.
	 */
	Date getTaskStart() {
		return (Date) taskStart.getValue();
	}
	
	/**
	 * Returns the task due date.
	 * @return the task due date.
	 */
	Date getTaskDue() {
		return (Date) taskDue.getValue();
	}
	
	/**
	 * Returns the task completed date.
	 * @return the task completed date.
	 */
	Date getTaskCompleted() {
		return (Date) taskCompleted.getValue();
	}
	
	/**
	 * Returns the text field for taskID.
	 * @return the text field for taskID.
	 */
	JTextField getTaskID() {
		if (taskID == null) {
			//create taskid
			taskID = new JTextField(8);
			
			//set up settings
			taskID.setEditable(false);
			taskID.setVisible(true);
			taskID.setHorizontalAlignment(SwingConstants.LEFT);
			
		}
		return this.taskID;
	}
	
	/**
	 * Returns the text field for taskTitle.
	 * @return the text field for taskTitle.
	 */
	JTextField getTaskTitle() {
		if (taskTitle == null) {
			taskTitle = new JTextField(13);
			taskTitle.setEditable(false);
			taskTitle.setVisible(true);
			taskTitle.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return this.taskTitle;
	}
	
	/**
	 * Returns the combo box for task's categories.
	 * @return the combo box for task's categories.
	 */
	JComboBox<Category> getCategory() {
		if (taskCat == null) {
			taskCat = new JComboBox<Category>();
			
			taskCat.setVisible(true);
			taskCat.setEnabled(false);
		}
		return taskCat;
	}
	
	/**
	 * Returns the text area for the taskDetails.
	 * @return the test area for the taskDetauls.
	 */
	JTextArea getTaskDetails() {
		if (taskDetails == null) {
			taskDetails = new JTextArea();

			taskDetails.setVisible(true);
			taskDetails.setEditable(true);
			taskDetails.setRows(3);
			taskDetails.setColumns(24);
			taskDetails.setBackground(Color.GREEN);
			taskDetails.setForeground(new Color(156, 173, 0));
			taskDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
			
		}
		return this.taskDetails;
	}
	
	/**
	 * Returns the check box for task complete.
	 * @return the check box for task complete.
	 */
	JCheckBox getComplete() {
		if (complete == null) {
			complete = new JCheckBox();

			complete.setEnabled(false);
			complete.setVisible(true);
		}
		return this.complete;
	}
	
	/**
	 * Sets the start date for the Task.
	 * @param d the start date for the Task.
	 */
	void setTaskStart(Date d) {
		this.taskStart.setValue(d);
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
		//wah
	}
	
	/**
	 * Fills the fields with the appropriate text from the CategoryData field.
	 */
	void fillFields() {
		//set task fields
		getTaskID().setText(data.getTaskID());
		getTaskTitle().setText(data.getTitle());
		getTaskDetails().setText(data.getDetails());
		getTaskStartSpinner().setValue(data.getStartDateTime());
		getTaskDueSpinner().setValue(data.getDueDateTime());
		getTaskCompletedSpinner().setValue(data.getCompletedDateTime());
		
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
		//butts
	}
}
