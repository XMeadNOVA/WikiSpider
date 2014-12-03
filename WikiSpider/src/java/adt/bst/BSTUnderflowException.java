package adt.bst;

/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

/**
 * Exception to be thrown when there are too few elements in a binary search
 * tree to perform an operation.
 * @author Xan Mead
 */
public class BSTUnderflowException extends Exception {

	/**
	 * Creates a new instance of <code>BSTUnderflowException</code> without
	 * detail message.
	 */
	public BSTUnderflowException() {
	}

	/**
	 * Constructs an instance of <code>BSTUnderflowException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public BSTUnderflowException(String msg) {
		super(msg);
	}
}
