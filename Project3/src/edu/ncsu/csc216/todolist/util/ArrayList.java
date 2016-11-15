package edu.ncsu.csc216.todolist.util;

import java.io.Serializable;

/**
 * A custom implementation of the ArrayList.  Featuring the
 * standard methods implemented from List.
 * @author Nicholas Board and Christian Byrnes
 */
public class ArrayList implements List, Serializable {
	
	/** The ArrayList's serial identification. */
	private static final long serialVersionUID = 28592L;
	/** The ArrayList's RESIZE value. */
	private static final int RESIZE = 2;
	/** The ArrayList's internal list. */
	private Object[] list;
	/** The ArrayList's size. */
	private int size;
	
	/**
	 * Standard constructor for the ArrayList.
	 * Sets the list's initial size to 1.
	 */
	public ArrayList() {
		list = new Object[2];
	}
	
	/**
	 * @param i
	 */
	public ArrayList(int i) throws IllegalArgumentException {
		if (i < 1) {
			throw new IllegalArgumentException();
		}
		
		list = new Object[i];
	}
	
    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param o element to be appended to this list
     * @return true (as specified by {@link Collection#add})
     */
	@Override
	public boolean add(Object o) {
		if (size() == list.length) {
			resize();
		}
		
		list[size()] = o;
		size++;
		return true;
	}
	
    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws NullPointerException if the specified element is null and
     *         this list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     */
	@Override
	public void add(int index, Object element) throws NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (element == null) {
			throw new NullPointerException();
		}
		
//TODO
//		if (something) {
//			throw new IllegalArgumentException();
//		}
			
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (size() == list.length) {
			resize();
		}
		
		for (int i = size(); i > index; i--) {
			this.list[i] = this.list[i-1];
		}
		
		this.list[index] = element;
		size++;
	}

	/**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains
     * at least one element e such that
     * (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size(); i++) {
			if (this.list[i].equals(o)) {
				return true;
			}
		}
		
		return false;
	}

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index >= size())
     */
	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		return this.list[index];
	}

	/**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))),
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (this.list[i].equals(o)) {
				return i;
			}
		}
		
		return -1;
	}

	/**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
	@Override
	public boolean isEmpty() {
		if (size > 0) {
			return false;
		} else {
			return true;
		}
	}

	 /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index >= size())
     */
	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Object removed = this.list[index];
		for (int i = index; i < this.list.length - 1; i++) {
			this.list[i] = this.list[i + 1];
		}
		
		size--;
		return removed;
		
	}
	
    /**
     * Returns the number of elements in this list.  If this list contains
     * more than Integer.MAX_VALUE elements, returns
     * Integer.MAX_VALUE.
     *
     * @return the number of elements in this list
     */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Resizes the Array if it is too small.
	 */
	private void resize() {
		Object[] newList = new Object[size()*RESIZE];
		
		for (int i = 0; i < size(); i++) {
			newList[i] = list[i];
		}
		
		list = newList;
	}
}
