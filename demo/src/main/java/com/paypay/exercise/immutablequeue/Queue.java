package com.paypay.exercise.immutablequeue;

import com.paypay.exercise.exception.ImmutableQueueException;

public interface Queue<T> {
    public Queue<T> enQueue(T t);
    public Queue<T> deQueue() throws ImmutableQueueException;//throws Exception when we try to remove elements and the queue is empty
    public T head() throws ImmutableQueueException; //throws exception when the queue is empty
    public boolean isEmpty();
}
