package edu.ncsu.csc216.todolist.util;

import java.io.Serializable;

/**
 * A custom implementation of the LinkedList.  Featuring the
 * standard methods implemented from List.
 * @author Nicholas Board and Christian Byrnes
 */
public class LinkedList  implements List, Serializable {

	/** The LinkedList's serial identification. */
	private static final long serialVersionUID = 349987L;
	/** The LinkedList's head Node. */
	private Node head;
	
	/**
	 * The standard constructor for a LinkedList.
	 */
	public LinkedList() {
		
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
     * @return True if the object is successfully added to the list
     */
	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		return false;
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
     */
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Inserts the specific element at the specified position in this list
	 * and attached the specified Node as the next Node.  Shifts elements to
	 * the right.
	 * 
	 * @param index The position to add the specified element.
	 * @param element The element to add to the LinkedList at index.
	 * @param node The node to attached as the next Node.
	 * @return The newly attached node.
	 */
	private Node insertAt(int index, Object element, Node node) {
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	private int indexOf(Object o, Node n, int i) {
		return 0;
	}
	
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
     */
	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Node remove(int i, Node n) {
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Calls itself recursively to count the Nodes and return the LinkedList size.
	 * @param n The next node in the list.
	 * @return The size of the LinkedList.
	 */
	private int size(Node n) {
		return 0;
	}
	
	/**
	 * The Category Node class represents a Node object.
	 * A Node in a LinkedList contains a value, and
	 * a reference to the next Node in the LinkedList.
	 * @author Nicholas Board and Christian Byrnes
	 */
	public class Node implements Serializable {

		/** The Category's serial identification. */
		private static final long serialVersionUID = 484909840L;
		/** The Node's value. */
		protected Object value;
		/** The next Node in the LinkedList. */
		@SuppressWarnings("unused")
		private Node next;
		
		/**
		 * Constructor for a Node object.
		 * @param newValue The value for the new Node.
		 * @param newNext The next Node in the LinkedList.
		 */
		public Node (Object newValue, Node newNext) {
			value = newValue;
			next = newNext;
		}
	}

}
