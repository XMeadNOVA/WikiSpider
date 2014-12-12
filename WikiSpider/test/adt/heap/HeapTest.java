/*
 * Copyright (C) 2014 Xan Mead
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package adt.heap;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xan Mead
 */
public class HeapTest {
	
	ArrayList<String> setRepo;
	
	public HeapTest() {
		
		setRepo = new ArrayList<>(40);
		
		String set = "QWERTYUIOPASDFGHJKLZXCVBNM";
		for (int i = 0; i < 40; i++) {
			setRepo.add("" + set.charAt(((int)(Math.random()*set.length()))));
		}
	}

	/**
	 * Test of isEmpty method, of class Heap.
	 */
	@Test
	public void testIsEmpty() throws PriQOverflowException {
		System.out.println("isEmpty");
		Heap instance = new Heap<>(5);
		
		boolean result = instance.isEmpty();
		assertTrue("Heap is empty.", result);
		instance.enqueue("bar");
		
		result = instance.isEmpty();
		assertFalse("Heap is not empty.", result);
	}

	/**
	 * Test of isFull method, of class Heap.
	 */
	@Test
	public void testIsFull() throws PriQOverflowException {
		System.out.println("isFull");
		Heap instance = new Heap<>(5);
		
		boolean result = instance.isFull();
		assertFalse("Heap is empty.", result);
		instance.enqueue("foo");
		instance.enqueue("bar");
		
		result = instance.isFull();
		assertFalse("Heap is not full.", result);
		
		instance.enqueue("Alice");
		instance.enqueue("Bob");
		instance.enqueue("Charles");
		
		result = instance.isFull();
		assertTrue("Heap is full.", result);
	}

	/**
	 * Test of enqueue method, of class Heap.
	 */
	@Test
	public void testEnqueue() throws Exception {
		System.out.println("enqueue");
		
		Heap<String> instance = new Heap<>(40);
		for (String s : setRepo) {
			instance.enqueue(s);
		}
		
		String last = instance.dequeue();
		
		for (int i = 0; i < 40; i++) {
			String item = instance.dequeue();
			assertTrue("This item is greater than or equal to its predecessor.", item.compareTo(last) >= 0);
			last = item;
		}
	}

	/**
	 * Test of dequeue method, of class Heap.
	 */
	@Test
	public void testDequeue() throws Exception {
		System.out.println("dequeue");
		Heap instance = null;
		Object expResult = null;
		Object result = instance.dequeue();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
