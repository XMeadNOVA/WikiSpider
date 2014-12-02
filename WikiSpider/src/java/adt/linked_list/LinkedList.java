/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.linked_list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>, Serializable {
	private LLNode<T> head;
	private LLNode<T> foot;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.foot = null;
		this.size = 0;
	}
	
	public LLNode<T> getHead() {
		return head;
	}
	
	public int size() {
		return size;
	}
	
	public void add(T value) {
		LLNode<T> node = new LLNode<T>(value);
		if (size == 0) {
			head = node;
		}
		else if (size == 1) {
			head.setLink(node);
			foot = node;
		}
		else {
			foot.setLink(node);
			foot = node;
		}
		size++;
	}
		
	public void addToFront(T value) {
		LLNode<T> node = new LLNode<T>(value);
		LLNode<T> other = head.getLink();
		head = node;
		head.setLink(other);
		size++;
	}
		
	public T get(T query) {
		LLNode<T> currentNode = head;
		while (currentNode != null) {
			if (currentNode.getValue().equals(query)) {
				return currentNode.getValue();
			}
			currentNode = currentNode.getLink();
		}
		return null;
	}
		
	/**
	 * Removes the first node in the LinkedList equal to target.
	 * @param target Value of the node to be searched for and deleted.
	 * @return Returns the value of the deleted node if the node is found. Otherwise, returns null.
	 */
	public T remove(T target) {
		LLNode<T> lastNode = null;
		LLNode<T> currentNode = head;
		// traverse to end
		while (currentNode != null) {
			T value = currentNode.getValue();
			if (value.equals(target)) {
				// Remove node from list
				if (currentNode.equals(head)) {
					head = head.getLink();
				}
				else if (currentNode.equals(foot)) {
					foot = lastNode;
					foot.setLink(null);
				}
				else {
					lastNode.setLink(currentNode.getLink());
				}
				size--;
				return value;
			}
			// "increment"
			lastNode = currentNode;
			currentNode = currentNode.getLink();
		}
		return null;
	}
	
	public T removeFirst() {
		T value = head.getValue();
		head = head.getLink();
		size--;
		return value;
	}
	
	public T[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (T e : this) {
			result[i] = e;
		}
		return (T[])result;
	}
	
	public ArrayList<T> toArrayList() {
		ArrayList<T> result = new ArrayList<T>(size);
		for (T e : this) {
			result.add(e);
		}
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		String result = "";
		LLNode<T> currentNode = head;
		while (currentNode != null) {
			result += currentNode.toString();
			result += "\n";
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator it = new Iterator() {
			LLNode<T> currentNode = head;
			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public Object next() {
				T result = currentNode.getValue();
				currentNode = currentNode.getLink();
				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}
			
		};
		return it;
	}
	
	@Override
	public boolean equals(Object other) {
		LinkedList<T> aList = (LinkedList)other;
		Iterator it1 = this.iterator();
		Iterator it2 = aList.iterator();
		while(it1.hasNext() && it2.hasNext()) {
			if (!it1.next().equals(it2.next())) {
				return false;
			}
		}
		if (it1.hasNext() != it2.hasNext()) {
			return false;
		}
		return true;
	}
}
