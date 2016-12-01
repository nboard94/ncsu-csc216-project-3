package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;

import edu.ncsu.csc216.todolist.util.ArrayList;

/**
 * A CategoryList holds and manages a list of Categories.
 * @author Christian Byrnes, Nick Board
 *
 */
public class CategoryList extends Observable implements Tabular, Serializable {

	/** The CategoryList's serial identification. */
	private static final long serialVersionUID = 984509L;
	/** The CategoryList's name. */
	private String name = "Categories";
	/** The value that will be appended to the next Category added to the CategoryList. */
	private int nextCategoryNum;
	/** The CategoryList's internal list. */
	private ArrayList list;
	
	/**
	 * Constructs a new CategoryList
	 */
	public CategoryList() {
		list = new ArrayList();
		nextCategoryNum = 1;
	}
	
	/**
	 * Gets the CategoryList's name.
	 * @return name The CategoryList's name.
	 */
	public String getName() { 
		return name;
	}
	
	/**
	 * Adds a new category to the CategoryList given a name and description
	 * @param newName The name of the new category
	 * @param newDesc The new category's description
	 * @return True if the category is successfully added
	 */
	public boolean addCategory(String newName, String newDesc) {
		try {
			list.add(new Category("C" + getNextCategoryAt(), newName, newDesc));
			incNextCategoryNum();
			this.notifyObservers();
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	/**
	 * Gets the category at the given index
	 * @param index the index of the category to fetch
	 * @return The category at the given index
	 */
	public Category getCategoryAt(int index) { 
		return (Category) list.get(index);
	}
	
	/**
	 * Returns the index of a category given that category's id
	 * @param id the name of the category
	 * @return The index of the category, or -1 if no category exists with that id
	 */
	public int indexOf(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (this.getCategoryAt(i).getCategoryID().equals(id)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of a category given that category's name
	 * @param name the name of the category
	 * @return The index of the category, or -1 if no category exists with that name
	 */
	public int indexOfName(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (this.getCategoryAt(i).getName().equals(name)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Gets the size of this CategoryList
	 * @return the total number of categories in this CategoryList
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Indicates whether or not CategoryList is empty.
	 * @return True if the CategoryList is empty.
	 */
	public boolean isEmpty() {
		if (list.size() == 0) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Removes a Category from the CategoryList.
	 * @param index The index from which to remove a Category.
	 * @return The removed Category.
	 */
	public Category removeCategoryAt(int index) {
		this.notifyObservers();
		return (Category) list.remove(index);
	}
	
	/**
	 * Removes a category from this list given the category id
	 * @param id the string id of the category to be removed
	 * @return true if the category is successfully removed
	 */
	public boolean removeCategory(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (this.getCategoryAt(i).getCategoryID().equals(id)) {
				list.remove(i);
				this.notifyObservers();
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Gets the next category id number
	 * @return the next category id number
	 */
	private int getNextCategoryAt() {
		return nextCategoryNum;
	}
	
	/**
	 * Increments the next category number
	 */
	private void incNextCategoryNum() {
		nextCategoryNum++;
	}
	
	/**
	 * Gets a 2D array of all the categories in this category list
	 * @return a 2d array of all the categories in this list. Each row is a category, while each column is data from that category
	 */
	public Object[][] get2DArray() {
		Object[][] arr = new Object[list.size()][3];
		
		for (int i = 0; i < list.size(); i++) {
			arr[i][0] = this.getCategoryAt(i).getCategoryID();
			arr[i][1] = this.getCategoryAt(i).getName();
			arr[i][2] = this.getCategoryAt(i).getDescription();
		}
		
		return arr;
	}
	
	/**
	 * Updates the category list to 
	 * @param o the Observable object to be accessed
	 * @param arg The argument to pass to notifyObservers()
	 */
	public void update(Observable o, Object arg) {
		Category c = (Category) o;
		if (list.contains(c)) {
			this.hasChanged();
			this.notifyObservers(this);
		}
	}
}
