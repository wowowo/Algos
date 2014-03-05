/*
 * Notes on other sorting':
 * 
 * 
 * Radix sorts by sorting all the digits and starts 
 * from the least significant thus fucks up the cache;
 * 
 * Bucket sort is used for doubles and uses linkedLists
 */

package unfamiliar;

import java.util.Arrays;


//Assumes knowledge of largest possible integer,
// if no knowledge loop once more to find it
//ignore the zero


public class CountingSort {
	
	public static int[] it(int[] UNsortedArray, int biggestInteger){
		
		int[] sortedArray = new int[UNsortedArray.length + 1];
		int[] frequencies = new int[biggestInteger + 1];
		
		//determine frequencies
		for(int i = 0; i < UNsortedArray.length; i++)
			frequencies[UNsortedArray[i]] ++;
		
		//determine number of elements 
		//less than or equal to every other(i)
		for(int i = 1; i < frequencies.length; i++)
			frequencies[i] = (frequencies[i] + frequencies[i - 1]);
			
		//order the array according to the
		//frequencies
		for(int i = UNsortedArray.length - 1; i >= 0 ; i--){
			sortedArray[frequencies[UNsortedArray[i]]] = UNsortedArray[i];
			frequencies[UNsortedArray[i]]--;
		}
		
		return sortedArray;
	}
	
	//test
	public static void main(String[] args){
		int[] a = {5,7,2,1,3,9,7};
		int[] b = CountingSort.it(a, 9);
		System.out.println(Arrays.toString(b));
		
		
	}
	
}
