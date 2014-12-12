/*
 * Copyright (C) 2014 Xan Mead
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package adt.bst;

import adt.queue.Queue;
import java.util.Iterator;

/**
 *
 * @author Xan Mead
 */
public class RBTree<T extends Comparable<T>> implements Iterable<T> {
	
	/** Root node of this tree. */
	private RBNode<T> root;
	
	private Order order;
	
	private Queue<T> traversalQueue;
	
	/** Number of nodes in the tree. */
	private int size;
	
	public RBTree() {
		root = null;
		size = 0;
		resetTraversalQueue(Order.INORDER);
	}
	
	/** @return The number of elements in this tree. */
	public int size() {
		return size;
	}
	
	/**
	 * Tells whether a value exists in the tree.
	 * @param query Value to search for in the tree.
	 * @return True if the value exists in the tree; otherwise, returns false.
	 */
	public boolean contains(T query) {
		boolean found = false;
		RBNode<T> next = root;
		while (!found && next != null) {
			if (query.compareTo(next.value()) == 0) {
				found = true;
			}
			else if (query.compareTo(next.value()) > 0) {
				next = next.right();
			}
			else {
				next = next.left();
			}
		}
		return found;
	}
	
	/**
	 * Returns the value in the tree equal to the query.
	 * @param query Value to search for in the tree.
	 * @return The value as represented in the tree, if it exists; otherwise returns null;
	 */
	public T get(T query) {
		RBNode<T> next = root;
		while(next != null) {
			if (query.compareTo(next.value()) == 0) {
				return next.value();
			}
			else if (query.compareTo(next.value()) > 0) {
				next = next.right();
			}
			else {
				next = next.left();
			}
		}
		return null;
	}
	
	/**
	 * Retrieves the first node in this tree to contain the argument's value.
	 * @param nodeValue Value to search for in the nodes.
	 * @return The node containing this value, if it exists; otherwise returns null.
	 */
	public RBNode<T> getNode(T nodeValue) {
		RBNode<T> next = root;
		while(next != null) {
			if (nodeValue.compareTo(next.value()) == 0) {
				return next;
			}
			else if (nodeValue.compareTo(next.value()) > 0) {
				next = next.right();
			}
			else {
				next = next.left();
			}
		}
		return null;
	}
	
	/**
	 * Adds a value to the tree, then adjusts the tree to maintain balance.
	 * After this operation,the properties of a Red-Black Tree will be maintained.
	 * @param value Value to be added to the tree.
	 */
	public void add(T value) {
		if (root == null) {
			root = new RBNode<>(value);
		}
		RBNode<T> next = root;
		boolean added = false;
		do {
			int comp = value.compareTo(next.value());
			if (comp >= 0) {
				if (next.right() == null) {
					next.setRight(new RBNode<>(value));
					size++;
					added = true;
				}
				next = next.right();
			}
			else {
				if (next.left() == null) {
					next.setLeft(new RBNode<>(value));
					size++;
					added = true;
				}
				next = next.left();
			}
		} while (!added);
		
		// Adjust tree to conform to rules of the Red-Black Tree
		adjustAfterInsertion(next);
	}
	
	/**
	 * Performs adjustments on the tree after insertion to maintain the Red-Black Tree properties.
	 * This involves either recoloring nodes or rotating trees.
	 * @param node Node to be adjusted.
	 */
	private void adjustAfterInsertion(RBNode<T> node) {
		/* 1) Ensure node is red */
		node.setColor(RBNode.RED);
		
		/* 2) Check for red violations; correct if they exist */
		if (node.parent() != null && node.parent().isRed()) {
			/* 2a) Uncle is red
			 * Recolor, proceed to grandparent */
			if (node.parent().sibling().isRed()) {
				
				// Color parent
				node.parent().setColor(RBNode.BLACK);
				
				// Color uncle
				RBNode<T> uncle = node.parent().sibling();
				if (uncle != null) {
					uncle.setColor(RBNode.BLACK);
				}
				
				// Color grandparent
				RBNode<T> grand = node.parent().parent();
				if (grand != null) {
					grand.setColor(RBNode.RED);
					// Continue adjustment
					adjustAfterInsertion(grand);
				}
			}
			
			/* 2b) Uncle is black, parent is left child.
			 * One right rotation if node is also left child,
			 * otherwise left-right rotation. */
			else if (node.parent().isLeftChild()) {
				if (node.isLeftChild()) {
					rotateLeft(node.parent());
				}
				node.parent().setColor(RBNode.BLACK);
				node.parent().parent().setColor(RBNode.RED);
				rotateRight(node.parent().parent());
			}
			
			/* 2b) Uncle is black, parent is right child.
			 * One left rotation if node is also right child,
			 * otherwise right-left rotation. */
			else if (node.parent().isRightChild()) {
				
			}
		}
		
		// 3) Color Root black
		root.setColor(RBNode.BLACK); // I see a red node and I want to paint it black.
	}
	
	private void rotateLeft(RBNode<T> node) {
		
	}
	
	private void rotateRight(RBNode<T> node) {
		
	}
	
	/**
	 * The queue returned will only be accurate immediately after a call to {@code resetTraversalQueue()}.
	 * The order will reflect the order set in that call.
	 * @return A queue of all the elements in the tree as of the last call to {@code resetTraversalQueue()}.
	 */
	public Queue<T> getTraversalQueue() {
		return traversalQueue;
	}
	
	/**
	 * Replaces the current traversal queue with a new one in the order specified.
	 * @param order Order in which to traverse the tree for filling the queue.
	 */
	public void resetTraversalQueue(Order order) {
		this.order = order;
		traversalQueue = new Queue<>();
		if (order == Order.INORDER) {
			inorder(root);
		}
		else if (order == Order.POSTORDER) {
			postorder(root);
		}
		else {
			preorder(root);
		}
	}
	
	/**
	 * Recursive method for propagating the traversal queue in preorder (root first).
	 * @param node Root of the preorder traversal.
	 */
	private void preorder(RBNode<T> node) {
		if (node != null) {
			traversalQueue.enqueue(node.value());
			preorder(node.left());
			preorder(node.right());
		}
	}
	
	/**
	 * Recursive method for propagating the traversal queue in inorder (root middle).
	 * @param node Root of the inorder traversal.
	 */
	private void inorder(RBNode<T> node) {
		if (node != null) {
			inorder(node.left());
			traversalQueue.enqueue(node.value());
			inorder(node.right());
		}
	}
	
	/**
	 * Recursive method for propagating the traversal queue in postorder (root last).
	 * @param node Root of the postorder traversal.
	 */
	private void postorder(RBNode<T> node) {
		if (node != null) {
			postorder(node.left());
			postorder(node.right());
			traversalQueue.enqueue(node.value());
		}
	}

	@Override
	public Iterator<T> iterator() {
		return traversalQueue.iterator();
	}
}
