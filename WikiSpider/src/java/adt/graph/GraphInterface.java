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

import adt.queue.Queue;

/**
 *
 * @author Xan Mead
 */
public interface GraphInterface<T> {
	
	/** @return true if this graph has no vertices; otherwise, returns false. */
	boolean isEmpty();
	
	/** @return true if the graph is full; otherwise, returns false. */
	boolean isFull();
	
	/**
	 * Adds a vertex to the graph.
	 * @param vertex Element to be added as a vertex.
	 */
	void addVertex(T vertex);
	
	/**
	 * Check if an object is a vertex in this graph.
	 * @param vertex Object to search for.
	 * @return true if the object is a vertex; otherwise, returns false.
	 */
	boolean hasVertex(T vertex);
	
	/**
	 * Returns a queue of each vertex adjacent to {@code vertex}.
	 * @param vertex Vertex for which to check adjacencies.
	 * @return Queue of all adjacencies.
	 */
	Queue<T> getToVertices(T vertex);
	
	/** Sets the mark on each vertex to false. */
	void clearMarks();
	
	/**
	 * Sets the mark on vertex to true.
	 * @param vertex Vertex to be marked.
	 */
	void markVertex(T vertex);
	
	/**
	 * Tells whether a vertex is marked or not.
	 * @param vertex Vertex to check.
	 * @return true if the vertex is marked; false if it is not.
	 */
	boolean isMarked(T vertex);
	
}
