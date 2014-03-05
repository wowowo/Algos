package unfamiliar;

import java.util.Arrays;

/**
 * Implementation of Radix sort.
 * @author User
 *
 */
public class LSDRadix {
	
	public static void sort(String[] a, int length){
		
		int chars = 256;
		int N = a.length;
		String[] aux = new String[N];
		
		//for each character
		for (int j = length-1; j >= 0; j--) {
			
			int[] count = new int[chars + 1];
			
			//record the frequency of each character
			for(int i = 0; i < N; i++)
				count[a[i].charAt(j)+ 1]++;
			
			//add them up
			for(int i = 0; i < chars; i++)
				count[i + 1] += count[i];
			
			//the frequency of the letter represents
			//its position in the array. Add 1 for repeated chars
			for(int i = 0; i < N; i++) 
				aux[count[a[i].charAt(j)]++] = a[i];
			
			//copy back to the array
			for(int i = 0; i < N; i++)
				a[i] = aux[i];
		}
		
	}
	
	/**
	 * Test
	 * @param args
	 */
	public static void main(String[] args){
		
		String[] a = {"dog", "cat", "bow", "cop", "wop", "bob", "dor"};
		
		LSDRadix.sort(a, 3);
		
		System.out.println(Arrays.toString(a));
	}
}
