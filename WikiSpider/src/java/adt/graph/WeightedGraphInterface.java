/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */
package adt.graph;

/**
 * A class that implements this interface will meet the ADT specifications for
 * a weighted, directed graph.
 * @author Xan Mead
 */
public interface WeightedGraphInterface<T> extends GraphInterface<T> {
	
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
}
