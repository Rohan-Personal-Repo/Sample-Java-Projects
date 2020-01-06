package com.easysystems.base;

public class StackImplementationSol2 {
	// Stack Class implementation using int[] - RD
	static int[] stackArr = new int[10];
	static int elemCnt = 0;
	
	public static void main(String[] args) {
		pushStack(10);
		pushStack(20);
		pushStack(30);
		printStack();
		peekStack();
		System.out.println( "Popped value : " + popStack() );
		printStack();
	}
	
	public static void pushStack( int v ) {
		System.out.println( "B4 : " + v );
		printStack();
		int[] tempArr = new int[10];
		int i,j;
		
		for( i=0; i<elemCnt; i++ ) {
			tempArr[i] = stackArr[i];
			stackArr[i] = -1;
		}
		
		stackArr[0] = v;
		elemCnt++;
		
		for( i=1,j=0; i<elemCnt; i++,j++ )
			stackArr[i] = tempArr[j];
		System.out.println( "after:");
		printStack();
	}
	
	public static int popStack() {
		int top = stackArr[0];
		
		int[] tempArr = new int[10];
		int i,j;
		
		stackArr[0] = -1;
		for( j=0,i=1; i<elemCnt; i++,j++ ) {
			tempArr[j] = stackArr[i];
			stackArr[i] = -1;
		}
		
		for( i=0; i<elemCnt; i++ )
			stackArr[i] = tempArr[i];
		
		elemCnt--;
		
		return top;
	}
	
	public static void peekStack() {
		System.out.println( "Element at Top : " + stackArr[0] );
	}
	
	public static void printStack() {
		System.out.print("Stack Contents: ");
		for (int i : stackArr) {
			System.out.print(i + " ");
		}
		System.out.println( "---===---" );
	}
	
}
