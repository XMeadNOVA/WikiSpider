/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */
package adt.graph;

import adt.queue.Queue;

/**
 * Implementation of the Graph ADT.
 * This graph is directed and weighted.
 * Edge values are integers.
 * The {@code equals} method of vertices is used throughout.
 * General precondition: Vertices passed as arguments to non-additive or
 * non-interrogative methods exist in the graph.
 * @author Xan Mead
 */
public class WeightedGraph<T> implements WeightedGraphInterface<T> {
	
	/** Special value indicating an undefined edge. */
	public static final int NULL_EDGE = -1;
	
	/** Current number of vertices in the graph. */
	private int numVertices;
	
	/** Maximum number of vertices allowed in this instance. */
	private int maxVertices;
	
	/** Array of the vertices in this graph. */
	private T[] vertices;
	
	/**
	 * Array parallel to {@code vertices}.
	 * Indicates if a vertex has been "visited" in the current traversal.
	 */
	private boolean[] marks;
	
	/** Denotes the weight of the edge between [fromIndex] and [toIndex]. */
	private int[][] edges;
	
	/**
	 * Creates an empty graph.
	 * @param maxVertices Maximum number of vertices in this graph.
	 */
	public WeightedGraph(int maxVertices) {
		this.maxVertices = maxVertices;
		this.numVertices = 0;
		this.vertices = (T[]) new Object[maxVertices];
		this.marks = new boolean[maxVertices];
		this.edges = new int[maxVertices][maxVertices];
	}
	
	/** @return Maximum number of vertices allowed in this instance. */
	public int getMaxVertices() { return maxVertices; }
	
	@Override
	public boolean isEmpty() {
		return (numVertices == 0);
	}
	
	@Override
	public boolean isFull() {
		return (numVertices == maxVertices);
	}
	
	/**
	 * {@inheritDoc}
	 * Preconditions:
	 *	The vertex is not null.
	 *	The vertex does not already exist in the graph.
	 *	The graph is not full.
	 */
	@Override
	public void addVertex(T vertex) {
		vertices[numVertices] = vertex;
		for (int i = 0; i <= numVertices; i++) {
			edges[i][numVertices] = NULL_EDGE;
			edges[numVertices][i] = NULL_EDGE;
		}
		numVertices++;
	}
	
	/**
	 * {@inheritDoc}
	 * Precondition: {@code vertex} must not be null.
	 * This implementation uses the vertices' {@code equals} method.
	 */
	@Override
	public boolean hasVertex(T vertex) {
		for (int i = 0; i < numVertices; i++) {
			if (vertices[i].equals(vertex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * Precondition: Weight is positive.
	 */
	@Override
	public void addEdge(T fromVertex, T toVertex, int weight) {
		int from;
		int to;
		
		from = indexOf(fromVertex);
		to = indexOf(toVertex);
		
		edges[from][to] = weight;
	}

	@Override
	public int weightIs(T fromVertex, T toVertex) {
		int row = indexOf(fromVertex);
		int column = indexOf(toVertex);
		
		return edges[row][column];
	}

	@Override
	public Queue<T> getToVertices(T vertex) {
		Queue<T> adj = new Queue<>();
		int fromIndex = indexOf(vertex);
		for (int toIndex = 0; toIndex < numVertices; toIndex++) {
			if (edges[fromIndex][toIndex] != NULL_EDGE) {
				adj.enqueue(vertices[toIndex]);
			}
		}
		return adj;
	}

	@Override
	public void clearMarks() {
		for (int i = 0; i < maxVertices; i++) {
			marks[i] = false;
		}
	}

	@Override
	public void markVertex(T vertex) {
		int index = indexOf(vertex);
		marks[index] = true;
	}

	@Override
	public boolean isMarked(T vertex) {
		int index = indexOf(vertex);
		return marks[index];
	}
	
	/**
	 * Finds the index of a vertex.
	 * @param vertex Vertex to find.
	 * @return index of the vertex.
	 */
	private int indexOf(T vertex) {
		int index = 0;
		while (!vertex.equals(vertices[index])) {
			index++;
		}
		return index;
	}
}
