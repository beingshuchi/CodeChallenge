package com.paypay.exercise.immutablequeue;

import com.paypay.exercise.exception.ImmutableQueueException;

public class ImmutableQueue<T> implements Queue<T> {
	/*
	 * Declaring two stacks so that there is no need to reverse the stack at the
	 * time of Dequeue fStack-- will store the elements as we store normally in
	 * stack-- Forward Stack bStack-- will store the elements in the reverse order
	 * as in fStack-- Backward Stack
	 */
	private final Stack<T> fStack, bStack;

	public ImmutableQueue(Stack<T> fStack, Stack<T> bStack) {
		super();
		this.fStack = fStack;
		this.bStack = bStack;
	}

	@SuppressWarnings({ "rawtypes" })
	public static Queue getInstance() {
		return EmptyQueue.getInstance();
	}

	/**
	 * This method adds the item in the queue and returns the queue with new element
	 * 1. if fStack is not empty adding the element to fStack 
	 * 2. else adding the element to bSatck to be sure that 
	 *    bStack is always having an element
	 */

	@Override
	public Queue<T> enQueue(T t) {
		if (!fStack.isEmpty()) {
			return new ImmutableQueue<T>(fStack.push(t), bStack);
		} else {
			return new ImmutableQueue<T>(fStack, bStack.push(t));
		}

	}

	/**
	 * When fStack/bStack is empty, the bStack/fStack elements need to be pushed
	 * into the fStack/bStack, this method reverses the input stack
	 * 
	 * O(n)
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Stack revStack(Stack stack) {
		Stack reversed = Stack.getEmptyStack();
		while (!stack.isEmpty()) {
			reversed = reversed.push(stack.head());
			stack = stack.pop();
		}
		return reversed;
	}
	/**
	 * Removes the head and returns the remaining queue
	 * 1. if the current queue is empty, throw an exception
	 * 2. if bStack is empty, reverse fStack and remove the head
	 * 3. if bStack is not empty, remove the head from bStack
	 **/

	@SuppressWarnings("unchecked")
	@Override
	public Queue<T> deQueue() throws ImmutableQueueException {
		
		if (this.isEmpty()) {
			throw new ImmutableQueueException("Queue is empty");
		}
		
		  Stack<T> fStack = revStack(this.fStack).pop(); //O(n)
		  if (bStack.isEmpty()) {
			// return getInstance();
			//return new ImmutableQueue<T>(Stack.getEmptyStack(), revStack(this.fStack).pop());
			 return new ImmutableQueue<T>(this.fStack, fStack);
		} 
		
		  else {
			  return new ImmutableQueue<T>(fStack, this.bStack.pop()); 
			  }
		 
	}
	
	/**
	 * This method returns the head of the queue
	 * 1. if the current queue is empty, throw exception
	 * 2. if bStack is empty, reverse fStack and return the head
	 * 3. if bStack is not empty, return the head of bStack
	 **/
	@SuppressWarnings("unchecked")
	@Override
	public T head() throws ImmutableQueueException {
		if (this.isEmpty()) {
			throw new ImmutableQueueException("Queue is empty");
		} 
		if (bStack.isEmpty()) {
			//System.out.println(bStack.head()+" -- bstack"+fStack.head()+"--fstak" );
			return (T) revStack(this.fStack).head();

		} else {
			//System.out.println(bStack.head()+" -- bstack"+fStack.head()+"--fstak" );
			return this.bStack.head();
		}

	}
	/**
	 * This method returns true if both fStack and bStack are empty else false
	 **/

	@Override
	public boolean isEmpty() {

		return (this.fStack.isEmpty() && this.bStack.isEmpty()) ? true : false;
	}

	@Override
	public String toString() {
		return "ImmutableQueue [fStack=" + fStack + ", bStack=" + bStack + "]";
	}
	/**
	 * The class empty queue creates a new empty queue.
	 **/

	private static final class EmptyQueue<T> implements Queue<T> {

		@SuppressWarnings("rawtypes")
		private final static EmptyQueue eQueue = new EmptyQueue();

		@SuppressWarnings("rawtypes")
		public final static EmptyQueue getInstance() {
			return eQueue;
		}

		@SuppressWarnings("unchecked")
		public final Queue<T> enQueue(T t) {
			return new ImmutableQueue<T>(Stack.getEmptyStack().push(t), Stack.getEmptyStack());
		}

		public final Queue<T> deQueue() throws ImmutableQueueException {
			throw new ImmutableQueueException("Queue is empty.");
		}

		public final T head() throws ImmutableQueueException {
			throw new ImmutableQueueException("Queue is empty.");
		}

		public final boolean isEmpty() {
			return true;
		}
	}

}
