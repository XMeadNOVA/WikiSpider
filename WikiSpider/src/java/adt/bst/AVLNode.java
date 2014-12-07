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

/**
 *
 * @author Xan Mead
 */
public class AVLNode<T extends Comparable<T>> {
	
	/** Parent of this node. */
	private AVLNode<T> parent;
	
	/** Child whose value is less than that of this node. */
	private AVLNode<T> left;
	
	/** Child whose value is greater than that of this node. */
	private AVLNode<T> right;
	
	/** Value of this node. */
	private T value;
	
	/** [Height of left subtree] - [Height of right subtree] */
	private int balanceFactor;
	
	/** Denotes whether this node is the terminal root of a tree. */
	private boolean isRoot;
	
	/** Denotes whether this node does or does not have children. */
	private boolean isLeaf;
	
	/* - START GETTERS - */
	
	/** @return Parent of this node. */
	public AVLNode<T> getParent() {return parent;}
	
	/** @return Left child of this node. */
	public AVLNode<T> getLeft() {return left;}
	
	/** @return Right child of this node. */
	public AVLNode<T> getRight() {return right;}
	
	/** @return Value of this node. */
	public T getValue() {return value;}
	
	/** @return Balance factor of this node. */
	public int getBalanceFactor() {return balanceFactor;}
	
	/** @return true if this node is a terminal root; otherwise returns false. */
	public boolean isRoot() {return isRoot;}
	
	/** @return true if this node has no children; otherwise returns false. */
	public boolean isLeaf() {return isLeaf;}
	
	/* - END GETTERS - */
	
	/**
	 * Tells whether a value is contained in the subtree.
	 * @param query Value to be found.
	 * @return true if the value is present in this subtree; otherwise, false.
	 */
	public boolean contains(T query) {
		if (value == null || query == null) {
			return false;
		}
		int comp = query.compareTo(value);
		if (comp == 0) {
			return true;
		}
		if (comp < 0 && left != null) {
			return left.contains(query);
		}
		if (comp > 0 && right != null) {
			return right.contains(query);
		}
		return false;
	}
	
	/**
	 * Precondition: {@code query} exists in the subtree.
	 * @param query Value to be retrieved.
	 * @return The value as it stored in the tree.
	 */
	public T get(T query) {
		int comp = query.compareTo(value);
		if (comp == 0) {
			return value;
		}
		if (comp < 0) {
			return left.get(query);
		}
		return right.get(query);
	}
	
	/**
	 * Precondition: {@code: nodeValue} exists in the subtree.
	 * @param nodeValue Value of the node to be retrieved.
	 * @return The node containing {@code nodeValue}
	 */
	public AVLNode<T> getNode(T nodeValue) {
		int comp = nodeValue.compareTo(value);
		if (comp == 0) {
			return this;
		}
		if (comp < 0) {
			return left.getNode(nodeValue);
		}
		return right.getNode(nodeValue);
	}
}
