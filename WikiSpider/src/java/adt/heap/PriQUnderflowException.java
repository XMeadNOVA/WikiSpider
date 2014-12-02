/*
 * Xan Mead 2014
 * CSC 202/73N * 
 */

package heap;

/**
 * This exception is thrown when an empty priority queue attempts to dequeue.
 * @author Xan Mead
 */
public class PriQUnderflowException extends Exception {

	/**
	 * Creates a new instance of <code>PriQUnderflowException</code> without
	 * detail message.
	 */
	public PriQUnderflowException() {
	}

	/**
	 * Constructs an instance of <code>PriQUnderflowException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public PriQUnderflowException(String msg) {
		super(msg);
	}
}
