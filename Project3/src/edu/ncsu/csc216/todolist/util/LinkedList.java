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
		head = new Node(null, null);
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
     * @throws IllegalArgumentException if the item given is null
     */
	@Override
	public boolean add(Object o) {
		//check if the object is null, throw exception if bad
		if (o == null) throw new IllegalArgumentException();
		
		//otherwise, add this to the end of the list
		add(this.size(), o);
		
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
     */
	@Override
	public void add(int index, Object element) {
		//check if the object is null, throw exception if it is
		if (element == null) throw new IllegalArgumentException();
		//also, if the index is greater than size throw an index out of bounds exception
		if (index > this.size() || index < 0) throw new IndexOutOfBoundsException();
		
		//otherwise, we'll throw this to the insertAt method, giving it the index, the element, and front
		this.insertAt(index, element, head);
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
		//base case, if index = 0
		if (index == 0) {
			//create the new node
			Node newNode = new Node(element, node.next);
			//set the given node's next to this new node
			node.next = newNode;
			//return the new node
			return newNode;
		}
		//otherwise, we'll pass it down
		else {
			return this.insertAt(index - 1, element, node.next);
		}
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
		//if the list is empty return false
		if (this.isEmpty()) return false;
		
		//else, lets roll through the list
		Node current = head.next;
		
		while (current != null) {
			if (current.value.equals(o)) return true;
			current = current.next;
		}
		
		//if you're out here, the whole list didn't contain the object
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
		//if the index is illegal have a fit
		if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();
		
		//goes through the list until the item is retrieved
		Node current = head.next;
		
		for (int i = 0; i < index; i ++) {
			current = current.next;
		}
		
		return current.value;
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
		//if the list is empty then we'll always return -1
		if (this.isEmpty()) return -1;
		
		//otherwise, we're going to use a private recursive method
		return this.indexOf(o, head.next, 0);
		
	}

	/**
	 * Recursive private method used to search the list for a certain object value
	 * @param obj the object to search for
	 * @param node the node to check the value of
	 * @param idx the current index
	 * @return the index of the object, if there is one.
	 */
	private int indexOf(Object obj, Node node, int idx) {
		//first check if this node contains the value we're looking for
		if (node.value.equals(obj)) return idx;
		
		//if this node doesn't contain the value we're looking for and there are no more
		//nodes left, we'll return -1
		if (node.next == null) return -1;
		
		//otherwise then we're going to move forward with node.next, adding one to the index
		return this.indexOf(obj, node.next, idx + 1);
	}
	
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
	@Override
	public boolean isEmpty() {
		if (head.next == null) return true;
		else return false;
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
		//check the index, have a hissy fit if it's illegal
		if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();
		
		//toss this bad boy to the R&R- recursive remove method
		return remove(index, head).value;
	}
	
	/**
	 * A recursive method that takes an index and a node- if the index given is 0, then
	 * this node's next is the one to be removed from the list
	 * @param idx the index of the node to be removed
	 * @param n the node to check
	 * @return the 
	 */
	private Node remove(int idx, Node n) {
		//base case, index = 0
		if (idx == 0) {
			//grab the old node, then set it's next to the current node's next
			Node oldNode = n.next;
			n.next = oldNode.next;
			return oldNode;
		}
		
		//otherwise, lets dance down the list
		return remove(idx - 1, n.next);
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
		return size(head);
	}
	
	/**
	 * Calls itself recursively to count the Nodes and return the LinkedList size.
	 * @param n The next node in the list.
	 * @return The size of the LinkedList.
	 */
	private int size(Node n) {
		if (n.next == null) return 0;
		else return size(n.next) + 1;
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
