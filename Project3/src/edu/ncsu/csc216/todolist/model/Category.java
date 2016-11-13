package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;

/**
 * The Category class represents a Category object, contains
 * a Category's state, has associated getters and setters,
 * and methods for comparison.
 * @author Nicholas Board and Christian Byrnes
 */
public class Category extends Observable implements Serializable {

	/** The Category's serial identification. */
	private static final long serialVersionUID = 459188L;
	/** The Category's name. */
	private String name;
	/** The Category's description. */
	private String description;
	/** The Category's ID. */
	private String categoryID;
	
	/**
	 * Constructor for a Category object.  Calls upon Category's setters to set the new Category's
	 * name, description, and ID.
	 * @param newName The new Category's name.
	 * @param newDescription The new Category's description.
	 * @param newCategoryID The new Category's ID.
	 */
	public Category(String newName, String newDescription, String newCategoryID) {
		this.setName(newName);
		this.setDescription(newDescription);
		this.setCategoryID(newCategoryID);
	}
	
	/**
	 * Gets the Category's name.
	 * @return name The name of the Category.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the Category's name.
	 * @param newName The name to set the Category's name to.
	 * @throws IllegalArgumentException If newName is null or an empty string.
	 */
	public void setName(String newName) throws IllegalArgumentException {
		if (newName == null || newName.equals(newName)) {
			throw new IllegalArgumentException();
		} else {
			name = newName;
		}
	}
	
	/**
	 * Gets the Category's description.
	 * @return description The description of the Category.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the Category's description.
	 * @param newDescription The description to set the Category's description to.
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	/**
	 * Gets the Category's ID.
	 * @return categoryID The ID of the Category.
	 */
	public String getCategoryID() {
		return categoryID;
	}
	
	/**
	 * Sets the Category's ID.
	 * @param newCategoryID The ID to set the Category's ID to.
	 * @throws IllegalArgumentException If newCategoryID is null or an empty string.
	 */
	private void setCategoryID(String newCategoryID) throws IllegalArgumentException {
		if (newCategoryID == null || newCategoryID.equals("")) {
			throw new IllegalArgumentException();
		} else {
			categoryID = newCategoryID;
		}
	}
	
	//TODO
	public boolean equals(Object o) {
		return false;
	}
	
	//TODO
	public int compareTo(Category c) {
		return 0;
	}
	
	//TODO
	public int hashCode() {
		return 0;
	}
	
	//TODO
	public String toString() {
		return null;
	}
}
