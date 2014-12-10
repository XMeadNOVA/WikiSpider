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
public class AVLTree<T extends Comparable<T>> implements Iterable<T> {
	
	/** Root node of this tree. */
	private AVLNode<T> root;
	
	private Order order;
	
	private Queue<T> traversalQueue;
	
	/** Number of nodes in the tree. */
	private int size;
	
	public AVLTree() {
		root = new AVLNode<>();
		size = 0;
		resetTraversalQueue(Order.INORDER);
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(T query) {
		return root.contains(query);
	}
	
	public T get(T query) {
		return root.get(query);
	}
	
	public AVLNode<T> getNode(T nodeValue) {
		return root.getNode(nodeValue);
	}
	
	public void add(T value) {
		
	}
	
	public Queue<T> getTraversalQueue() {
		return traversalQueue;
	}
	
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
	
	private void preorder(AVLNode<T> node) {
		if (node != null) {
			traversalQueue.enqueue(node.getValue());
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	private void inorder(AVLNode<T> node) {
		if (node != null) {
			inorder(node.getLeft());
			traversalQueue.enqueue(node.getValue());
			inorder(node.getRight());
		}
	}
	
	private void postorder(AVLNode<T> node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			traversalQueue.enqueue(node.getValue());
		}
	}

	@Override
	public Iterator<T> iterator() {
		return traversalQueue.iterator();
	}
}
