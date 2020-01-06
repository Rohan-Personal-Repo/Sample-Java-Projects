package com.easysystems.base;

import java.util.Stack;

public class StackImplementationSol1 {
	// Direct Stack Class from util package
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<>();
		stack1.push( 1 );
		stack1.push( 2 );
		stack1.push( 3 );
		stack1.push( 4 );
		System.out.println( "I/P in the order : 1 2 3 4" );
		System.out.print( "O/P in the order : " );
		while( !stack1.isEmpty() )
			System.out.print( stack1.pop() + " ");
	}
}
/*
	I/P in the order : 1 2 3 4
	O/P in the order : 4 3 2 1 
*/