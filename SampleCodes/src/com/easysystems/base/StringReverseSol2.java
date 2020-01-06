package com.easysystems.base;

public class StringReverseSol2 {
	
	// Solution 2 - Converting into charArray & Reversing using Loop
	public static void main(String[] args) {
		String str = "RohanDeshpande";
		System.out.println( "Original String : " + str );
		char[] charArr = str.toCharArray();
		System.out.print( "Reversed String : " );
		for( int i=(charArr.length-1); i>=0; i-- )
			System.out.print( charArr[i] );
	}
}
