/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.bst;

/**
 * While all nodes of a binary search tree are by definition BSTs themselves,
 * the BSTNode is basic, and lacks the high level operations of the full ADT.
 * @author Xan Mead
 * @param <T> Type of object to be stored in the value field that must be comparable.
 */
public class BSTNode<T extends Comparable> {
	/** Value of type T contained within this node.*/
	private T value;
	
	/** Node whose value will always be less than the value of this.*/
	private BSTNode<T> left;
	
	/** Node whose value will always be greater than the value of this.*/
	private BSTNode<T> right;
		
	/**
	 * Creates an empty node.
	 * Following instantiation, the value should be set as soon as possible.
	 */
	public BSTNode() {
		this.value = null;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Creates a node and sets the value to the argument.
	 * @param value value to which this node is to be initialized.
	 */
	public BSTNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	/** @return value of this node.*/
	public T getValue() {
		return value;
	}
	
	/** @return BSTNode to the right of this node.*/
	public BSTNode<T> getRight() {
		return right;
	}
	
	/** @return BSTNode to the right of this node.*/
	public BSTNode<T> getLeft() {
		return left;
	}
		
	/** @param value new value for the node.*/
	public void setValue(T value) {
		this.value = value;
	}
	
	/** @param right new right node.*/
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	
	/** @param left new left node.*/
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	/** @return true if the node has no children, otherwise false. */
	public boolean isLeaf() {
		return (right == null) && (left == null);
	}
	
	/** @return number of nodes the right + number of nodes to the left + 1*/
	public int size() {
		int size = 1;
		if (right != null) {
			size += right.size();
		}
		if (left != null) {
			size +=  left.size();
		}
		return size;
	}
	
	/**
	 * Tells whether a given element is present in a node or its children.
	 * @param element element to be searched for.
	 * @return true if the element is present, otherwise false.
	 */
	public boolean contains(T element) {
		int comp = value.compareTo(element);
		if (comp == 0) {
			return true;
		}
		else if (comp > 0 && right != null) {
			return right.contains(element);
		}
		else if (comp < 0 && left != null) {
			return left.contains(element);
		}
		return false;
	}
	
	/**
	 * Retrieves a given element.
	 * @param element element to be retrieved.
	 * @return If it is found, the queried element, otherwise null;
	 */
	public T get(T element) {
		if (value == null) {
			return null;
		}
		if (value.compareTo(element) == 0) {
			return value;
		}
		BSTNode<T> next;
		if (value.compareTo(element) < 0) {
			next = left;
		}
		else {
			next = right;
		}
		if (next != null) {
			return next.get(element);
		}
		return null;
	}
	
	/**
	 * Attempts to insert the given element such that the BSTNode remains ordered.
	 * @param element value to be inserted.
	 */
	public void insert(T element) {
		if (value == null) {
			value = element;
		}
		else if (value.compareTo(element) > 0) {
			if (left == null) {
				left = new BSTNode<T>();
				left.setValue(element);
			}
			else {
				left.insert(element);
			}
		}
		else {
			if (right == null) {
				right = new BSTNode<T>();
				right.setValue(element);
			}
			else {
				right.insert(element);
			}
		}
	}
		
	@Override
	public boolean equals(Object other) {
		return this.value.equals(((BSTNode)other).getValue());
	}
}