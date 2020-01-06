package com.easysystems.base;

public class StringReverseSol1 {
	
	// Solution 1 - Using reverse() methods of StringBuffer and StringBuilder
	public static void main(String[] args) {
		String str = "RohanDeshpande";
		
		System.out.println( "Original String : " + str );
		System.out.println( "Reverse String Fun 1 : " + new StringBuffer(str).reverse().toString() );
		System.out.println( "Reverse String Fun 2 : " + new StringBuilder(str).reverse().toString() );
	}
}
