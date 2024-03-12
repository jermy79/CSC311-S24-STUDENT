package com.usman.csudh.csc311.datastructures.impl;

import com.usman.csudh.csc311.datastructures.List;
import com.usman.csudh.csc311.datastructures.ListInvalidIndexException;
/**
 * A linked list implementation of the List interface. Linked list stores its as
 * nodes. Each data item is stored in a separate node. Each node contains a
 * reference to the next node in the list. To get to any particular node, you
 * have to start at the head and follow the next references.
 * 
 * @author Usman Aslam
 * 
 */

public class LinkedList implements List {
	Node head;

	public LinkedList() {
		head = null;
	}

	/**
	 * Adds a new data item to the end of the list
	 * 
	 * @param item the data item to add to the list
	 */
	@Override
	public void add(int item) {
		// Create a new node, which should be added to the end of the list
		Node newNode = new Node(item);

		// Find the tail of the list
		Node tail = findTail();

		/*If the list is empty, then this node will become the first item (HEAD)
		 else this node will be added to the end of the current TAIL, effectively
		 becoming the new TAIL 
		 */
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}

	}

	
	/**
	 * Copies an array of items to the list 
	 * 
	 * @param item the data item to add to the list
	 */
	@Override
	public void add(int[] items) {
		for (int item: items) {
			add(item);
		}

	}
	/**
	 * Inserts a new data item at a specific location in the list. This will involve
	 * traversing through the list, finding the spot where it should be inserted and
	 * then updating the links to add the new node
	 * 
	 * @param item the data item to add to the list
	 * @param loc  the location to add the data item
	 * @throws Exception if the list is empty
	 */

	@Override
	public void insert(int loc, int item) throws ListInvalidIndexException {

		// Find the node at the specified location
		Node current =(loc==0?head:findNode(loc-1));
		if (current == null) {
			throwInvalidIndexException();
		}
		// Create a new node with data item
		Node newNode = new Node(item);

		
		//head is is always node 0. So if loc is 0, then newNode will be the new head
		if(loc==0) { 
			newNode.next = head;
			head=newNode;
			
		}
		else {			
			// Update links to add new node
			newNode.next = current.next;
			current.next = newNode;			
		}
	}

	/**
	 * Updates the data item at a specific location in the list
	 * 
	 * @param loc the location to update the data item
	 * @param item  the new value for the data item
	 * @throws Exception if the list is empty
	 */
	@Override
	public void put(int loc, int item) throws ListInvalidIndexException {
		// Find the node at the specified location
		Node current =(loc==0?head:findNode(loc-1));

		// Node not found
		if (current == null||current.next==null) throwInvalidIndexException();
		
		//Create a new node with data item
		Node newNode = new Node(item);
		
		if(loc==0) {
            newNode.next = head.next;
            head = newNode;
        }
        else {
			newNode.next = current.next.next;
			current.next = newNode;
		}
        
	}

	/**
	 * Deletes a data item from a specific location in the list and returns the deleted value. This will involve
	 * traversing through the list, finding the spot where it should be deleted and
	 * then updating the links to remove the node
	 * 
	 * @param loc the location to delete the data item
	 * @throws Exception if the list is empty
	 */
	@Override
	public int remove(int loc) throws ListInvalidIndexException {
		if(loc>=size()) throwInvalidIndexException();
		// Find the node one before the one that is to be deleted
		Node n = (loc==0?head:findNode(loc - 1));

		// Node not found
		if (n == null)
			throwInvalidIndexException();

		
		int data;
		
		// If the node to be deleted is the head
		if(loc==0) {
			data=head.data;
			head = head.next;
		}
		else {
			data = n.next.data;
			n.next = n.next.next;
		}
		
		return data;
	}

	@Override
	public int get(int loc) throws ListInvalidIndexException {
		// Find the node at specified location
		Node n = findNode(loc);

		// Node not found
		if (n == null)
			throwInvalidIndexException();

		// return the data from the node
		return n.data;
	}

	@Override
	public int size() {
		//list with no head is empty list
		int size=0;
		if (head == null) return size;
		
		//traverse the list to count nodes	
		Node current = head;
		while (current != null) {
			current = current.next;
			size++;
		}
		return size;
	}

	@Override
	public void clear() {
		//will remove the head and all the nodes will be garbage collected
		head = null;

	}

	@Override
	public boolean isEmpty() {
		//list with no head is empty list
		return head == null;
	}

	
	@Override
	public String toString() {
		Node current = head;
		String result = "";
		while (current != null) {
			result += current.data + " ";
			current = current.next;
		}
		return result;
	}

	// Returns the node at the specified location
	private Node findNode(int loc) throws ListInvalidIndexException {
		// if the location is invalid then throw an exception
		if (loc < 0 || (head == null && loc > 0))
			throwInvalidIndexException();

		// Start at the head of the list
		Node current = head;
		int idx = 0;

		// Traverse the list until the specified location is found
		while (current != null) {

			// If the location is found, return the nodes
			if (idx == loc)
				return current;

			// Move to the next node
			current = current.next;

			// Increment the index
			idx++;
		}
		return null;
	}

	// Returns the tail of the list
	private Node findTail() {
		if (head == null) {
			return null;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	private void throwInvalidIndexException() throws ListInvalidIndexException {
		throw new ListInvalidIndexException("Invalid index");
	}

	// Private inner class Node
	private class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

	}
}
