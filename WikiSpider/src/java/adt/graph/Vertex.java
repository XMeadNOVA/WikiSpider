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
package adt.graph;

import adt.bst.RBTree;
import adt.bst.Order;
import adt.queue.Queue;

/**
 *
 * @author Xan Mead
 */
public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {
	
	private T value;
	
	private boolean mark;
	
	private RBTree<Vertex<T>> toVertices;
	
	public Vertex(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public void mark() {
		mark = true;
	}
	
	public void unmark() {
		mark = false;
	}
	
	public boolean isMarked() {
		return mark;
	}
	
	public void addEdgeTo(Vertex other) {
		toVertices.add(other);
	}
	
	public boolean hasEdgeTo(Vertex other) {
		return toVertices.contains(other);
	}
	
	public Queue<Vertex<T>> getToVertices() {
		toVertices.resetTraversalQueue(Order.INORDER);
		return toVertices.getTraversalQueue();
	}
	
	@Override
	public int compareTo(Vertex o) {
		return value.compareTo((T) o.getValue());
	}

}
