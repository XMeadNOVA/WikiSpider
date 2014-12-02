/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.linked_list;

import java.io.Serializable;

public class LLNode<T> implements Serializable {
	private T value;
	private LLNode<T> link;
	
	public LLNode(T value) {
		this.value = value;
	}
		
	public LLNode<T> getLink() {
		return link;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setLink(LLNode<T> other) {
		link = other;
	}
	
	public void setValue(T other) {
		value = other;
	}
	
	public String toString() {
		return value.toString();
	}
	
	public boolean equals(Object other) {
		return (other instanceof LLNode<?> && ((LLNode<T>)other).getValue().equals(this.getValue()));
	}
}

