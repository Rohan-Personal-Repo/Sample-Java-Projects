package com.easysystems.base;

public class StringReverseSol3 {
	
	// Solution 2 - taking single character using Loop & Reversing 
	public static void main(String[] args) {
		String str = "RohanDeshpande";
		System.out.println( "Original String : " + str );
		StringBuilder builder = new StringBuilder();
		for( int i=str.length()-1; i>=0; i-- )
			builder.append( str.charAt(i) );
		System.out.println( "Reversed String : " + builder.toString() );
	}
}
