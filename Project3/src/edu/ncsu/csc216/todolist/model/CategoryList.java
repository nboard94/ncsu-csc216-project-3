package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;

import edu.ncsu.csc216.todolist.util.ArrayList;

public class CategoryList extends Observable implements Tabular, Serializable {

	private static final long serialVersionUID = 984509L;
	private String name;
	private int nextCategoryNum;
	private ArrayList list;
	
	public CategoryList() {
		
	}
	
	public String getName() {
		return null;
	}
	
	public boolean addCategory(String s1, String s2) {
		return false;
	}
	
	public Category getCategoryAt(int i) {
		return null;
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
	
	public boolean isEmpty() {
		return false;
	}
	
	public Category removeCategoryAt(int i) {
		return null;
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
