package com.easysystems.base;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImplementation1 {
	
	// Direct Queue implementation from UTIL package
	static Queue<Integer> queue = new PriorityQueue<>();
	
	public static void main(String[] args) {
		queue.add( 10 );
		queue.add( 20 );
		queue.add( 30 );

		printContents();
		
		System.out.println( "Peek : " + queue.peek() );
		
		printContents();
		
		System.out.println( "Poll : " + queue.poll() );
		
		printContents();
	}
	
	private static void printContents() {
		System.out.print( "Quque Contents : " );
		for (Integer i : queue)
			System.out.print(i + " ");
		System.out.println();
	}
}
