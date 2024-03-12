package com.usman.csudh.csc311.datastructures;

/**
 * Interface for for a list data structure. Contains key operations
 * that a list data structure should support.
 * 
 * @author Usman Aslam
 */
public interface List {

	/**
	 * Add an element to the list
	 * @param data the element to add to the list
	 */
	public void add(int data);
	
	
	/**
	 * Copies a whole array of items to the list 
	 * @param data the element to add to the list
	 */
	public void add(int[] data);


	/**
	 * Insert an element into the list at a specific index
	 * 
	 * @param data  the element to insert into the list
	 * @param index the index to insert the element at
	 * @throws ListInvalidIndexException if the index is invalid
	 */
	public void insert(int index, int data) throws ListInvalidIndexException;

	/**
	 * Delete an element from the list at a specific index and returns the delete item
	 * this has been an improved version of the delete method
	 * 
	 * @param index the index to delete the element from
	 * @throws ListInvalidIndexException if the index is invalid
	 */
	public int remove(int index) throws ListInvalidIndexException;


	/**
	 * Get the element at a specific index
	 * 
	 * @param index the index to get the element from
	 * @return the element at the specified index
	 * @throws ListInvalidIndexException if the index is invalid
	 */
	public int get(int index) throws ListInvalidIndexException;

	/**
	 * Update the element at a specific index
	 * 
	 * @param index the index to update the element at
	 * @param data  the new value for the element
	 * @throws ListInvalidIndexException if the index is invalid
	 */	
	public void put(int index, int data) throws ListInvalidIndexException;
	
	/**
	 * Get sie of the list
	 * 
	 * @return size of the list
	 * @throws ListInvalidIndexException if the index is invalid
	 */
	public int size();
	
	/**
	 * Clear the list
	 */
	public void clear();
	
	/**
	 * Check if the list is empty
	 * 
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty();
	
}
