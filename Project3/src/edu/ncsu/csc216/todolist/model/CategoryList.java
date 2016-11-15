package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;

import edu.ncsu.csc216.todolist.util.ArrayList;

public class CategoryList extends Observable implements Tabular, Serializable {

	/** The CategoryList's serial identification. */
	private static final long serialVersionUID = 984509L;
	/** The CategoryList's name. */
	private String name = "Categories";
	//TODO
	/** Something. */
	private int nextCategoryNum;
	/** The CategoryList's internal list. */
	private ArrayList list;
	
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
	
	public boolean addCategory(String name, String desc) {
		return false;
	}
	
	public Category getCategoryAt(int index) { 
		return (Category) list.get(index);
	}
	
	public int indexOf(String s) {
		return 0;
	}
	
	public int indexOfName(String s) {
		return 0;
	}
	
	public int size() {
		return 0;
	}
	
	/**
	 * Indicates whether or not CategoryList is empty.
	 * @return True if the CategoryList is empty.
	 */
	public boolean isEmpty() {
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Removes a Category from the CategoryList.
	 * @param index The index from which to remove a Category.
	 * @return The removed Category.
	 */
	public Category removeCategoryAt(int index) {
		return (Category) list.remove(index);
	}
	
	
	public boolean removeCategory(String s) {
		return false;
	}
	
	private int getNextCategoryAt() {
		return 0;
	}
	
	private void incNextCategoryNum() {
		
	}
	
	public Object[][] get2DArray() {
		return null;
	}
	
	public void update(Observable o1, Object o2) {
		
	}
}
