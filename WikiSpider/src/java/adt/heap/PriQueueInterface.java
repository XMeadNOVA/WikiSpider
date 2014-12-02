/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */

package adt.heap;

/**
 * A priority queue is a collection in which only the highest priority element
 * can be accessed, via the dequeue method.
 * @author Xan Mead
 * @param <T> Type of object to be stored in the Priority.
 */
public interface PriQueueInterface<T extends Comparable<T>> {
	/** @return true if this priority queue is empty, false otherwise. */
	boolean isEmpty();
	
	/** @return true if this priority queue is full, false otherwise. */
	boolean isFull();
	
	/**
	 * Throws PriQOverflowException if this priority queue is full;
	 * otherwise, adds element to this priority queue.
	 * @param element Element to be added to the collection.
	 * @throws heap.PriQOverflowException
	 */
	void enqueue(T element)throws PriQOverflowException;
	
	/**
	 * Throws PriQUnderflowException if this priority queue is empty;
	 * otherwise, removes element with highest priority from this
	 * priority queue and returns it.
	 * @return highest priority element in the collection.
	 * @throws heap.PriQUnderflowException 
	 */
	T dequeue() throws PriQUnderflowException;
}