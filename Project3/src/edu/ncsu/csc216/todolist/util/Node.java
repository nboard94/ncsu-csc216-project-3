package edu.ncsu.csc216.todolist.util;

import java.io.Serializable;

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
	Object value;
	/** The next Node in the LinkedList. */
	private Node next;
	
	/**
	 * @param newValue The value for the new Node.
	 * @param newNext The next Node in the LinkedList.
	 */
	public Node (Object newValue, Node newNext) {
		value = newValue;
		next = newNext;
	}
}
