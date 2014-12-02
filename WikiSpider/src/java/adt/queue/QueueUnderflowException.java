/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package adt.queue;

/**
 * To be thrown when an empty Queue is asked to dequeue.
 * @author Xan Mead
 */
public class QueueUnderflowException extends Exception {

	/**
	 * Creates a new instance of <code>QueueUnderflowException</code> without
	 * detail message.
	 */
	public QueueUnderflowException() {
	}

	/**
	 * Constructs an instance of <code>QueueUnderflowException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public QueueUnderflowException(String msg) {
		super(msg);
	}
}
