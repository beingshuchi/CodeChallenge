package com.paypay.exercise.immutablequeuetest;

import org.junit.Assert;
import org.junit.Test;

import com.paypay.exercise.exception.ImmutableQueueException;
import com.paypay.exercise.immutablequeue.ImmutableQueue;
import com.paypay.exercise.immutablequeue.Queue;

import junit.framework.TestCase;

public class ImmutableQueueTest extends TestCase {
	/**
	 * Test Enqueue:
	 * To test if there is any addition in the queue
	 * It can be checked by asserting false isEmpty method
	 * Also, it can be checked by comparing the head with expected value
	 **/
	@SuppressWarnings("unchecked")
	@Test
	public void testEnQueue() throws ImmutableQueueException {
		
		Queue<String> q=ImmutableQueue.getInstance();
		q=q.enQueue("ABC");
		q=q.enQueue("DEF");
		q=q.enQueue("LAST");
		Assert.assertFalse(q.isEmpty());
		Assert.assertEquals("ABC",q.head());
		
	}
	/**
	 * To test if the queue is immutable when an element is added
	 **/
	@SuppressWarnings("unchecked")
	@Test
	public void testEnQueueImmutability() throws ImmutableQueueException {
		
		Queue<String> q=ImmutableQueue.getInstance();
		q.enQueue("ABC");
		Assert.assertTrue(q.isEmpty());
				
	}
	/**
	 * To test the null values on being added in the queue
	 **/
	@Test
	public void testEnQueueNullValue() throws ImmutableQueueException {
		@SuppressWarnings("unchecked")
		Queue<Integer> q=ImmutableQueue.getInstance();
		q=q.enQueue(null);
		assertNull(q.head());
	}
	/**
	 * Test Dequeue:
	 * To test if there is any removal in the queue
	 * It can be checked by comparing the head with expected value
	 **/
	@Test
	public void testDeQueue() throws ImmutableQueueException{
		
		@SuppressWarnings("unchecked")
		Queue<String> q=ImmutableQueue.getInstance();
		q=q.enQueue("ABC");
		q=q.enQueue("DEF");
		q=q.enQueue("LAST");
		q=q.deQueue();
		//System.out.println(q);
		Assert.assertEquals("DEF",q.head());
		 
		
	}
	/**
	 * To test if the queue is immutable when an element is removed
	 **/
	@Test
	public void testDeQueueImmutability() throws ImmutableQueueException{
		
		@SuppressWarnings("unchecked")
		Queue<String> q=ImmutableQueue.getInstance();
		q=q.enQueue("ABC");
		q.deQueue();
		//System.out.println(q);
		Assert.assertFalse(q.isEmpty());
		Assert.assertEquals("ABC",q.head());
		 
		
	}
	/**
	 * To test enqueue and dequeue 
	 **/
	@Test
	public void testDeQueueEnQueue() throws ImmutableQueueException{
		@SuppressWarnings("unchecked")
		Queue<String> q=ImmutableQueue.getInstance();
		q=q.enQueue("ABC").enQueue("DEF").deQueue().enQueue("LAST").deQueue();
		//System.out.println(q);
		Assert.assertEquals("LAST",q.head());
		
	}
	/**
	 * To test the Exception being raised when dequeue is being done
	 * when the queue is empty.
	 **/
	@Test(expected=ImmutableQueueException.class)
	public void testDeQueueException() {
		try {
			assertNotNull(ImmutableQueue.getInstance().deQueue());
		} catch (ImmutableQueueException e) {
			
			assertEquals("Queue is empty.", e.getMessage());
		}
	}
	/**
	 * To test the head of the queue with the expected value
	 **/
	@SuppressWarnings("unchecked")
	@Test
	public void testHead() throws ImmutableQueueException {
		Queue<String> q=ImmutableQueue.getInstance();
		q=q.enQueue("ABC");
		//System.out.println(q);
		q=q.enQueue("DEF");
		//System.out.println(q);
		q=q.deQueue();
		//System.out.println(q);
		q=q.enQueue("LAST");
		//System.out.println(q);
		q=q.deQueue();
		//System.out.println(q);
		String head="LAST";
		Assert.assertEquals(head,q.head());
	}
	/**
	 * To test the Exception being raised when calling the head being called
	 * when the queue is empty.
	 **/
	@Test(expected=ImmutableQueueException.class)
	public void testHeadException() {
		try {
			assertNotNull(ImmutableQueue.getInstance().head());
		} catch (ImmutableQueueException e) {
			
			assertEquals("Queue is empty.", e.getMessage());
		}
	}
	/**
	 * Testing if there is an empty queue
	 **/
	@Test
	public void testIsEmpty() {
		@SuppressWarnings("unchecked")
		Queue<String> q=ImmutableQueue.getInstance();
		Assert.assertTrue(q.isEmpty());
	}
	/**
	 * Testing if there queue is not empty
	 **/
	@Test
	public void testIsNotEmpty() {
		@SuppressWarnings("unchecked")
		Queue<String> q=ImmutableQueue.getInstance();
		q=q.enQueue("ABC");
		q=q.enQueue("DEF");
		Assert.assertFalse(q.isEmpty());
	}

}
