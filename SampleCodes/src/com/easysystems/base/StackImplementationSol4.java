package com.easysystems.base;

public class StackImplementationSol4 {
	// Stack Class implementation using int[] - JB
	// Simply moving the pointer not removing elements
	static int[] stackArr;
	static int capacity = 0;
	static int top;
	
	public StackImplementationSol4( int capacity ) {
		this.stackArr = new int[capacity];
		this.capacity = capacity;
		this.top = -1;
	}
	
	public static void main(String[] args) {
		StackImplementationSol4 stack = new StackImplementationSol4( 5 );
		stack.pushStack(10);
		stack.pushStack(20);
		stack.pushStack(30);
		stack.peekStack();
		System.out.println( "Popped value : " + stack.popStack() );
		System.out.println( "Popped value : " + stack.popStack() );
		stack.pushStack(90);
		System.out.println( "Peek value : " + stack.peekStack() );
	}
	
	public void pushStack( int v ) {
		this.stackArr[++top] = v;
	}
	
	public int popStack() {
		return this.stackArr[top--];
	}
	
	public int peekStack() {
		return this.stackArr[top];
	}
}
