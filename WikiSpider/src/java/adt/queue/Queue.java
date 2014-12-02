/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package adt.queue;

import java.util.Iterator;
import adt.linked_list.LinkedList;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue<T> implements QueueInterface<T>, Iterable<T> {
	
	private LinkedList<T> list;
	
	public Queue() {
		list = new LinkedList<T>();
	}
	
	public Queue(T[] set) {
		list = new LinkedList<T>();
		for (T e : set) {
			enqueue(e);
		}
	}

	@Override
	public synchronized void enqueue(T element) {
		list.add(element);
	}
	
	@Override
	public synchronized T dequeue() throws QueueUnderflowException {
		try {
			return list.removeFirst();
		} catch(NoSuchElementException nse) {
			throw new QueueUnderflowException();
		}
	}
	
	public LinkedList<T> getList() {
		return list;
	}
	
	public T[] toArray() {
		return list.toArray();
	}
	
	public ArrayList<T> toArrayList() {
		return list.toArrayList();
	}
	
	@Override
	public synchronized boolean isEmpty() {
		return list.isEmpty();
	}
	
	public synchronized int size() {
		return list.size();
	}
	
	@Override
	public synchronized Iterator<T> iterator() {
		return list.iterator();
	}
	
	
	@Override
	public boolean equals(Object other) {
		return list.equals(((Queue)other).getList());
	}
}

