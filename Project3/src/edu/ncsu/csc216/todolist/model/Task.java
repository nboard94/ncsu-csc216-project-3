package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * The Task class represents a Task object, contains
 * a Task's state, has associated getters and setters,
 * and methods for comparison.
 * @author Nicholas Board and Christian Byrnes
 */
public class Task extends Observable implements Serializable {

	/** The Task's serial identification. */
	private static final long serialVersionUID = 7459L;
	/** The Task's title. */
	private String title;
	/** The Task's details. */
	private String details;
	/** The Task's start date and time. */
	private Date startDateTime;
	/** The Task's due date and time. */
	private Date dueDateTime;
	/** The Task's completion date and time. */
	private Date completedDateTime;
	/** The Task's completion state. */
	private boolean completed;
	/** The Task's ID. */
	private String taskID;
	/** The Task's category. */
	private Category category;
	
	/**
	 * Constructor for a Task object.  Calls upon Task's setters to set the new Task's
	 * title, details, startDateTime, dueDateTime, category, and taskID.
	 * @param newTitle The new Task's title.
	 * @param newDetails The new Task's details.
	 * @param newStartDateTime The new Task's startDateTime.
	 * @param newDueDateTime The new Task's dueDateTime.
	 * @param newCategory The new Task's category.
	 * @param newTaskID The new Task's taskID.
	 */
	public Task(String newTitle, String newDetails, Date newStartDateTime, Date newDueDateTime, Category newCategory, String newTaskID) {
		this.setTitle(newTitle);
		this.setDetails(newDetails);
		this.setStartDateTime(newStartDateTime);
		this.setDueDateTime(newDueDateTime);
		this.setCategory(newCategory);
		this.setTaskID(newTaskID);
		this.setCompleted(false);
	}
	
	/**
	 * Gets the Task's title.
	 * @return title The Task's title.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the Task's title.
	 * @param newTitle The new title to set Task's title to.
	 * @throws IllegalArgumentException If newTitle is null or an empty string.
	 */
	public void setTitle(String newTitle) throws IllegalArgumentException {
		if (newTitle == null || newTitle.equals("")) {
			throw new IllegalArgumentException();
		} else {
			title = newTitle;
		}
	}
	
	/**
	 * Gets the Task's details.
	 * @return details The Task's details.
	 */
	public String getDetails() {
		return details;
	}
	
	/**
	 * Sets the Task's details.
	 * @param newDetails The new details to set Task's details to.
	 * @throws IllegalArgumentException If newDetails is null or an empty string.
	 */
	public void setDetails(String newDetails) throws IllegalArgumentException {
		if (newDetails == null || newDetails.equals("")) {
			throw new IllegalArgumentException();
		} else {
			details = newDetails;
		}
	}
	
	/**
	 * Gets the Task's start date and time.
	 * @return startDateTime The date and time the Task was started on.
	 */
	public Date getStartDateTime() {
		return startDateTime;
	}
	
	/**
	 * Sets the Task's startDateTime.
	 * @param newStartDateTime The date to set Task's StartDateTime to.
	 */
	public void setStartDateTime(Date newStartDateTime) throws IllegalArgumentException {
		if (newStartDateTime == null) {
			throw new IllegalArgumentException();
		} else {
			startDateTime = newStartDateTime;
		}
	}
	
	/**
	 * Gets the Task's due date and time.
	 * @return dueDateTime The date and time the Task was due on.
	 */
	public Date getDueDateTime() {
		return dueDateTime;
	}
	
	/**
	 * Sets the Task's dueDateTime.
	 * @param newDueDateTime The date to set Task's dueDateTime to.
	 */
	public void setDueDateTime(Date newDueDateTime) throws IllegalArgumentException {
		if (newDueDateTime == null) {
			throw new IllegalArgumentException();
		} else {
			dueDateTime = newDueDateTime;
		}
		
	}
	
	/**
	 * Gets the Task's completion date and time.
	 * @return completedDateTime The date and time the Task was completed on.
	 */
	public Date getCompletedDateTime() {
		return completedDateTime;
	}
	
	/**
	 * Sets the Task's completedDateTime.
	 * @param newCompletedDateTime The date to set Task's completedDateTime to.
	 */
	public void setCompletedDateTime(Date newCompletedDateTime) {
		completedDateTime = newCompletedDateTime;
	}
	
	/**
	 * Gets the Task's completion state.
	 * @return completed
	 */
	public boolean isCompleted() {
		return completed;
	}
	
	/**
	 * Sets the Task's completion state.
	 * @param newCompleted The boolean to set Task's completion state to.
	 */
	public void setCompleted(boolean newCompleted) {
		completed = newCompleted;
	}
	
	/**
	 * Gets the Task's category.
	 * @return category The Task's category.
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * Sets the Task's category.
	 * @param newCategory The category to set the Task's category to.
	 * @throws IllegalArgumentException If newCategory is null.
	 */
	public void setCategory(Category newCategory) throws IllegalArgumentException {
		if (newCategory == null) {
			throw new IllegalArgumentException();
		} else {
			category = newCategory;
		}
	}
	
	/**
	 * Gets the Task's taskID.
	 * @return taskID The Task's taskID.
	 */
	public String getTaskID() {
		return taskID;
	}
	
	/**
	 * Sets the Task's taskID.
	 * @param newTaskID The string to set taskID to.
	 * @throws IllegalArgumentException If newTaskID is null or an empty string.
	 */
	private void setTaskID(String newTaskID) throws IllegalArgumentException {
		if (newTaskID == null || newTaskID.trim().equals("")) {
			throw new IllegalArgumentException();
		} else {
			taskID = newTaskID;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taskID == null) ? 0 : taskID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!taskID.equals(((Task) obj).getTaskID())) {
			return false;
		}
		
		return true;
				
	}
	
	/**
	 * Compares this task to another given task. Compared and ordered based on their dueDate time.
	 * @param otherTask the other task to compare to.
	 * @return A value less than 0 if otherTask goes before this one, 0 if otherTask is equal to this one, and a value greater than one if this task goes before otherTask
	 */
	public int compareTo(Task otherTask) {
		return dueDateTime.compareTo(otherTask.getDueDateTime());
	}
}
