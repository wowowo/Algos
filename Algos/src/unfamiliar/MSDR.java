package unfamiliar;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import alg.Timer;

/**
 * Same as LSD, doesn't rely on a fixed amount of iterations.
 * @author User
 *
 */
public class MSDR {
	
	private static String[] aux;
	private static int R = 256;
	
	public static void sort(String[] a){
		
		aux = new String[a.length];
		
		sort(a, aux, 0, a.length - 1, 0);
		
	}
	/**
	 * 
	 * @param a - the array to be sorted
	 * @param aux - auxiliary array to store temp positions
	 * @param lo - start position to sort
	 * @param hi - end position to sort
	 * @param d - the char position to be compared
	 */
	private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
		
		if(hi <= lo) return;
		int[] count = new int[R + 2]; 
		
		//Same as LSD just 
		// get char frequencies offset by two
		// 1 reserved for chars out of bounds
		for(int i = lo; i <= hi; i++) {
			
			  int c = charAt(a[i], d);
	            count[c + 2]++;
	            
		}
		
		for(int r = 0; r < R + 1; r++)
			count[r+1] += count[r];
		

		for(int i = lo; i <= hi; i++){
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }
		
		
		for(int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];
		
		//sort again for each character
		for(int r = 0; r < R; r++)
			sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);}
		
	

	/**
	 * 
	 * @param s - the string to extract a char from
	 * @param d - the position of the char
	 * @return - -1 if position bigger than string length,</br> the char at the position otherwise
	 */
	private static int charAt(String s, int d){
		
		if(d == s.length()) return -1;
		return s.charAt(d);
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		
		ArrayList<String> as = new ArrayList<String>();
		Scanner in = new Scanner(new File("clustering_small.txt"));
		
		while(in.hasNext())
			as.add(in.next());
		
		String[] asd =  as.toArray(new String[0]);
		
		Timer.start();
		MSDR.sort(asd);
		Timer.stop();

		Timer.start();
		System.out.println(Arrays.toString(asd));
		Timer.stop();
	}


}
