package com.paypay.exercise.immutablequeue;

public final class Stack<T> {
	private T top;
	private int len;
	private Stack<T> last;
	public Stack(T top, Stack<T> last) {
		super();
		this.top = top;
		this.len = last.len+1;
		this.last = last;
	}
	
	public Stack() {
		this.top = null;
		this.len =0;
		this.last = null;
	}

	@SuppressWarnings("rawtypes")
	public static Stack getEmptyStack() {
		return new Stack();
	}

	@Override
	public String toString() {
		return "Stack [top=" + top + ", len=" + len + ", last=" + last + "]";
	}
	
	public Stack<T> push(T t){
        return new Stack<T>(t,this);
    }

    public Stack<T> pop() {
        return last;
    }

    public T head() { return top; }

    public boolean isEmpty(){
        return this.len == 0;
    }
}
