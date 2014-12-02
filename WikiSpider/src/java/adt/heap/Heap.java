/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */

package heap;

import java.util.ArrayList;

/**
 * This is an array-based binary tree implementation of the priority queue.
 * @author Xan Mead
 */
public class Heap <T extends Comparable<T>> implements PriQueueInterface<T> {
	
	/** Elements in the priority queue.*/
	private ArrayList<T> elements;
	
	/** Index of the last element in the collection.*/
	private int lastIndex;
	
	/** Largest allowed index in the collection.*/
	private int maxIndex;
	
	/**
	 * Creates an empty heap.
	 * @param maxSize maximum number of elements allowed in the heap.
	 */
	public Heap(int maxSize) {
		this.elements = new ArrayList<>(maxSize);
		this.lastIndex = -1;
		this.maxIndex = maxSize - 1;
	}

	@Override
	public boolean isEmpty() {
		return lastIndex == -1;
	}

	@Override
	public boolean isFull() {
		return lastIndex == maxIndex;
	}

	@Override
	public void enqueue(T element) throws PriQOverflowException {
		if (lastIndex == maxIndex) {
			throw new PriQOverflowException("Queue is full!");
		}
		else {
			lastIndex++;
			elements.add(lastIndex, element);
			reheapUp(element);
		}
	}
	
	@Override
	public T dequeue() throws PriQUnderflowException {
		T result;
		T toMove;
		
		if (lastIndex == -1) {
			throw new PriQUnderflowException("Queue is empty!");
		}
		else {
			result = elements.get(0);
			toMove = elements.remove(lastIndex);
			lastIndex--;
			if (lastIndex > -1) {
				reheapDown(toMove);
			}
			return result;
		}
	}
	
	/**
	 * Adds an element to the heap such that the order property is maintained.
	 * Used by {@link #enqueue(java.lang.Comparable)}
	 * @precondition Heap must not be full.
	 * @param element Element to be inserted.
	 */
	private void reheapUp(T element) {
		int hole = lastIndex;
		while (hole > 0 && element.compareTo(elements.get((hole - 1)/2)) > 0) {
			elements.set(hole, elements.get((hole - 1)/2));
			hole = (hole - 1)/2;
		}
		elements.set(hole, element);
	}
	
	/**
	 * Adds an element to the heap such that the order property is maintained.
	 * Used by {@link #dequeue()}.
	 * @precondition Root must be empty.
	 * @param element 
	 */
	private void reheapDown(T element) {
		int hole = 0;
		int nextHole;
		
		nextHole = nextHole(hole, element);
		while (nextHole != hole) {
			elements.set(hole, elements.get(nextHole));
			hole = nextHole;
			nextHole = nextHole(hole, element);
		}
		elements.set(hole, element);
	}
	
	/**
	 * Returns the index of whichever of the current hole's children has the
	 * greatest value. If neither of the children are greater than the element,
	 * the index of the current hole is returned.
	 * @param hole Current index of the hole.
	 * @param element Element to be inserted.
	 * @return index of the new hole.
	 */
	private int nextHole(int hole, T element) {
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		
		
		T leftElm;
		T rightElm;
		
		if (left > lastIndex) {
			// The hole has no children!
			return hole;
		}
		
		leftElm = elements.get(left);
		
		if (left == lastIndex) {
			// hole has only one child
			// compare left and hole
			if (leftElm.compareTo(element) > 0) {
				return left;
			}
			else {
				return hole;
			}
		}
		
		// If this point is reached, the hole has two children
		
		rightElm = elements.get(right);
		
		if (leftElm.compareTo(rightElm) < 0) {
			// right element could be greater
			if (rightElm.compareTo(element) <= 0) {
				// current hole is satisfactory
				return hole;
			}
			else {
				// right child has a greater value than element
				return right;
			}
		}
		else {
			// left element could be greater
			if (leftElm.compareTo(element) <= 0) {
				// current hole is satisfactory
				return hole;
			}
			else {
				// left child has a greater value than element
				return left;
			}
		}
	}
}