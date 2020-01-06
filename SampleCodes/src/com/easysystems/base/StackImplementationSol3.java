package com.easysystems.base;

import java.util.LinkedList;

public class StackImplementationSol3 {
	// Stack Class implementation using LinkedList
	static LinkedList<Integer> stackList = new LinkedList<>();
	
	public static void main(String[] args) {
		pushStack(10);
		pushStack(20);
		pushStack(30);
		printStack();
		System.out.println( "Peeked value : " + peekStack() );
		printStack();
		System.out.println( "Popped value : " + popStack() );
		printStack();
	}
	
	public static void pushStack( int v ) {
		stackList.addFirst(v);
	}
	
	public static int popStack() {
		int val = stackList.getFirst();
		stackList.remove();
		return val;
	}
	
	public static int peekStack() {
		return Integer.valueOf( stackList.getFirst() );
	}
	
	public static void printStack() {
		System.out.print("Stack Contents: ");
		for (int i : stackList) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
