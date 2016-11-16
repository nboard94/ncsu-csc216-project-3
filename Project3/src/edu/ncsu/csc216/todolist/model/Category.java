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
		if (newName == null || newName.equals("")) {
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
	
	/**
	 * Compares two Category objects based on their ID.
	 * Delegates to String's compareTo() methods.
	 * @param c The Category to compare to this Category.
	 * @return 0 if the same, -1 if this Category comes first, 1 if the arg Category is first.
	 */
	public int compareTo(Category c) {
		return this.getCategoryID().compareTo(c.getCategoryID());
	}
	
	/**
	 * Checks if this object is equal to the one provided in the parameters
	 * @param obj the object to compare to this one
	 * @return True if the object is equal to this one
	 */
	@Override
	public boolean equals(Object obj) {
		if (!categoryID.equals(((Category) obj).getCategoryID())) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the Category's hashcode
	 * @return int the hashcode for for this Category
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
		return result;
	}
	
	/**
	 * Returns this Category represented as a string value
	 * @return This Category represented as a String value
	 */
	public String toString() {
		return this.getCategoryID() + ", " + this.getName() + ", " + this.getDescription();
	}
}
