package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;

public class Category extends Observable implements Serializable {

	private static final long serialVersionUID = 459188L;
	private String name;
	private String description;
	private String categoryID;
	
	public Category(String s1, String s2, String s3) {
		
	}
	
	public String getName() {
		return null;
	}
	
	public void setName(String s){
		
	}
	
	public String getDescription() {
		return null;
	}
	
	public void setDescription(String s) {
		
	}
	
	public String getCategoryID() {
		return null;
	}
	
	private void setCategoryID(String s) {
		
	}
	
	public boolean equals(Object o) {
		return false;
	}
	
	public int compareTo(Category c) {
		return 0;
	}
	
	public int hashCode() {
		return 0;
	}
	
	public String toString() {
		return null;
	}
}
