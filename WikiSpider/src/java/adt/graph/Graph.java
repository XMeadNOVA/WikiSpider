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
import adt.queue.Queue;

/**
 * 
 * @author Xan Mead
 * @param <T>
 */
public class Graph<T extends Comparable<T>> implements GraphInterface<T> {
	
	private RBTree<Vertex<T>> vertices;
	
	@Override
	public boolean isEmpty() {
		return vertices.size() > 0;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void addVertex(T vertexValue) {
		vertices.add(new Vertex<>(vertexValue));
	}

	@Override
	public boolean hasVertex(T vertexValue) {
		return vertices.contains(new Vertex<>(vertexValue));
	}

	public Queue<Vertex<T>> getAdjacentVertices(T vertex) {
		return vertices.get(new Vertex<>(vertex)).getToVertices();
	}
	
	@Override
	public Queue<T> getToVertices(T vertex) {
		Queue<T> vertexValues = new Queue<>();
		for (Vertex<T> v : getAdjacentVertices(vertex)) {
			vertexValues.enqueue(v.getValue());
		}
		return vertexValues;
	}

	@Override
	public void clearMarks() {
		for (Vertex v : vertices) {
			v.unmark();
		}
	}

	@Override
	public void markVertex(T vertex) {
		vertices.get(new Vertex<>(vertex)).mark();
	}

	@Override
	public boolean isMarked(T vertex) {
		return vertices.get(new Vertex<>(vertex)).isMarked();
	}
	
}
