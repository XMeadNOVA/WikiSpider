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
public class RBNode<T extends Comparable<T>> {
	
	/** Parent of this node. */
	private RBNode<T> parent;
	
	/** Child whose value is less than that of this node. */
	private RBNode<T> left;
	
	/** Child whose value is greater than that of this node. */
	private RBNode<T> right;
	
	/** Value of this node. */
	private T value;
	
	private boolean isRed;
	
	public static final boolean RED = true;
	
	public static final boolean BLACK = false;
	
	public RBNode(T value) {
		this.parent = null;
		this.value = value;
		this.left = null;
		this.right = null;
		this.isRed = RED;
	}
	
	public RBNode(RBNode<T> parent, T value) {
		this.parent = parent;
		this.value = value;
		this.left = null;
		this.right = null;
		this.isRed = RED;
	}
	
	/** @return Parent of this node. */
	public RBNode<T> parent() {return parent;}
	
	/** @return Left child of this node. */
	public RBNode<T> left() {return left;}
	
	/** @return Right child of this node. */
	public RBNode<T> right() {return right;}
	
	/** @return Value of this node. */
	public T value() {return value;}
	
	public boolean isRed() {return isRed;}
	
	// Predcondition: parent is not null
	public RBNode<T> sibling() {
		if (parent.right() == this) {
			return parent.left();
		}
		else {
			return parent.right();
		}
	}
	
	// Precondition: parent is not null
	public boolean isRightChild() {
		return parent.right() == this;
	}
	
	// Precondition: parent is not null
	public boolean isLeftChild() {
		return parent.left() == this;
	}
	
	public void setRight(RBNode<T> n) {
		right = n;
		right.setParent(this);
	}
	
	public void setLeft(RBNode<T> n) {
		left = n;
		left.setParent(this);
	}
	
	public void setParent(RBNode<T> n) {
		parent = n;
	}
	
	public void setColor(boolean color)	{
		isRed = color;
	}
}