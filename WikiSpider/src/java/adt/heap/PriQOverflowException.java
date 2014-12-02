/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */

package adt.heap;

/**
 * This exception is thrown when an enqueue operation
 * is attempted on a full priority queue.
 * @author Xan Mead
 */
public class PriQOverflowException extends Exception {

	/**
	 * Creates a new instance of <code>PriQOverflowException</code> without
	 * detail message.
	 */
	public PriQOverflowException() {
	}

	/**
	 * Constructs an instance of <code>PriQOverflowException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public PriQOverflowException(String msg) {
		super(msg);
	}
}
