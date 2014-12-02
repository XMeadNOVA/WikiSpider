/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */
package graph;

import queue.Queue;

/**
 * A class that implements this interface will meet the ADT specifications for
 * a weighted, directed graph.
 * @author Xan Mead
 */
public interface WeightedGraphInterface<T> {
	
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
	 * Adds a weighted edge from one vertex to another.
	 * @param fromVertex Origin of the edge.
	 * @param toVertex Terminus of the edge.
	 * @param weight Weight of the edge.
	 */
	void addEdge(T fromVertex, T toVertex, int weight);
	
	/**
	 * Returns the weight of an edge.
	 * @param fromVertex Origin of the desired edge.
	 * @param toVertex Terminus of the desired edge.
	 * @return If the desired edge is found, the weight of that edge; otherwise, a specified "null-edge" value.
	 */
	int weightIs(T fromVertex, T toVertex);
	
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
