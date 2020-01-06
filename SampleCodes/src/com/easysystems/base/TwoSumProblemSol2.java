package com.easysystems.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */		
public class TwoSumProblemSol2 {

	public static void main(String[] args) throws IOException {

		int[] num = new int[args.length-1];
		Map<Integer,Integer> numMap = new HashMap<>();
		int i=0,done1=-100, done2=-100;

		for ( i=0; i<(args.length-1); i++ ) {
			num[i] = Integer.parseInt( args[i] );
			numMap.put( num[i],i );
		}

		int target = Integer.parseInt( args[args.length-1] );
		int diff = -100;
		for ( i=0; i<num.length; i++ ) {
			diff = target-num[i];
			if( numMap.containsKey(diff) ) {
				if( done1==i && done2==numMap.get(diff) )
					continue;
				else {
					System.out.println( target + " = values at position : " + i + " and " + numMap.get(diff) );
					done1 = numMap.get(diff);
					done2 = i;
				}
			}
		}
		
		if( done1==-100 || done2==-100 )
			System.out.println( "None of the array members form : " + target );
	}
}