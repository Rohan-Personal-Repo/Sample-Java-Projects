package com.easysystems.base;

public class QueueImplementation2 {
	
	// Direct Queue implementation using int[]
	static int[] queueArr = new int[10]; 
	static int elemCnt = 0;
	
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
		elemCnt++;
		if( elemCnt > 0 )
			queueArr[ elemCnt-1 ] = v;
		else 
			queueArr [ elemCnt ] = v;
	}
	
	private static int removeItem() {
		int val = queueArr[0], i,j;
		int[] tempArr = new int[elemCnt];
		queueArr[0] = -1;
		for( i=1,j=0; i<elemCnt; i++,j++ ) {
			tempArr[j] = queueArr[i];
			queueArr[i] = -1;
		}
		
		elemCnt--;
		
		for( i=0; i<elemCnt; i++ )
			queueArr[i] = tempArr[i];
		
		return val;
	}
	
	private static int peekItem() {
		return queueArr[0];
	}
	
	
	private static void printContents() {
		System.out.print( "Queue Contents : " );
		for (Integer i : queueArr)
			System.out.print(i + " ");
		System.out.println();
	}
}
