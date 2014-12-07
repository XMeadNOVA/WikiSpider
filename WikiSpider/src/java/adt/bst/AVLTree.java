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

/**
 *
 * @author Xan Mead
 */
public class AVLTree<T extends Comparable<T>> {
	
	/** Root node of this tree. */
	private AVLNode<T> root;
	
	private Order order;
	
	private Queue<T> traversalQueue;
	
	/** Number of nodes in the tree. */
	private int size;
	
	public boolean contains(T query) {
		return root.contains(query);
	}
	
	public T get(T query) {
		return root.get(query);
	}
	
	public AVLNode<T> getNode(T nodeValue) {
		return root.getNode(nodeValue);
	}
}
