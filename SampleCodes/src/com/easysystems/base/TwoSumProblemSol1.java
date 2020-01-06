package com.easysystems.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */		

// Solution 1 - Take Input from CMD Line 
public class TwoSumProblemSol1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print( "Enter the Numbers in Array : " );
		String[] numStrArr = br.readLine().split(" ");
		int[] num = new int[numStrArr.length];

		for (int i=0; i<numStrArr.length; i++ ) {
			num[i] = Integer.parseInt( numStrArr[i] );
		}
		System.out.print( "Enter the target:" );
		int target = Integer.parseInt( br.readLine() );
		int done1=110, done2=120;

		for( int i=0; i<num.length; i++ ) {
			for( int j=0; j<num.length; j++ ) {
				if( i!=j ) {
					if( num[i] + num[j] == target ) {
						if( j==done1 && i==done2 )
							continue;
						else {
							done1 = i;
							done2 = j;
							System.out.println( target + " is found on positions : " + i + " and " + j );
							break;
						}
					}
				}
			}
		}

	}
}
