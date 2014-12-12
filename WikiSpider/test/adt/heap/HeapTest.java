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
	
	private Heap<String> testHeap;
	
	ArrayList<String> setRepo;
	
	public HeapTest() {
		
		testHeap = new Heap<>(50);
		
		String set = "QWERTYUIOPASDFGHJKLZXCVBNM";
		for (int i = 0; i < 40; i++) {
			try {
				testHeap.enqueue("" + set.charAt(((int)(Math.random()*set.length()))));
			} catch (PriQOverflowException ex) {
				Logger.getLogger(HeapTest.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/**
	 * Test of isEmpty method, of class Heap.
	 */
	@Test
	public void testIsEmpty() {
		System.out.println("isEmpty");
		Heap instance = null;
		boolean expResult = false;
		boolean result = instance.isEmpty();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of isFull method, of class Heap.
	 */
	@Test
	public void testIsFull() {
		System.out.println("isFull");
		Heap instance = null;
		boolean expResult = false;
		boolean result = instance.isFull();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of enqueue method, of class Heap.
	 */
	@Test
	public void testEnqueue() throws Exception {
		System.out.println("enqueue");
		Object element = null;
		Heap instance = null;
		instance.enqueue(element);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
