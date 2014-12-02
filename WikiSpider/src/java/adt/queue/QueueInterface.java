/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.queue;


public interface QueueInterface<T> {
	
	/**
	 * Adds the element to the end of the list. 
	 * @param element Element to be added to the queue.
	 */
	void enqueue(T element);
	
	/**
	 * Removes and returns the first element in the queue.
	 * @return The removed element.
	 */
	T dequeue() throws QueueUnderflowException;
	
	/** @return true if the queue is empty, false if it is not. */
	boolean isEmpty();
}
