package com.easysystems.base;

import java.util.LinkedList;

public class QueueImplementation3 {
	
	// Direct Queue implementation using LinkedList
	static LinkedList<Integer> queueList = new LinkedList<>();
	
	public static void main(String[] args) {
		insertItem( 10 );
		insertItem( 20 );
		insertItem( 30 );

		printContents();
		
		System.out.println( "Peek : " + peekItem() );
		
		printContents();
		
		System.out.println( "Remove : " + removeItem() );
		
		printContents();
	}
	
	private static void insertItem( int v ) {
		queueList.addFirst(v);
	}
	
	private static int removeItem() {
		int val = queueList.getFirst();
		queueList.removeFirst();
		return val;
	}
	
	private static int peekItem() {
		return queueList.getFirst();
	}
	
	
	private static void printContents() {
		System.out.print( "Queue Contents : " );
		for (Integer i : queueList)
			System.out.print(i + " ");
		System.out.println();
	}
}
