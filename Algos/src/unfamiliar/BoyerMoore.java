package unfamiliar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoyerMoore {

	int M;
	String pat;
	int[] right;
	int R = 256;
	
	public BoyerMoore(String pat){
		this.pat = pat;
		M = pat.length();
		right = new int[R];
		
		for(int r = 0; r < R; r++)
			right[r] = -1;
		
		for (int j =0; j < M; j++)
			right[pat.charAt(j)] = j;
	}
	
	public int search(String txt){
		int N = txt.length();
		int skip;
		for(int i = 0; i < N - M; i += skip){
			skip = 0;
			
			for( int j = M - 1; j >= 0; j--){
				if(pat.charAt(j) != txt.charAt(i + j)){
					skip = Math.max(1, j - right[txt.charAt(i + j)]);
					break;
				}
			}
			
			if(skip == 0) return i;
			
		}
		return N;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		BoyerMoore tandy = new BoyerMoore("Tandy");
		Scanner scnr = new Scanner(new File("clustering_small.txt"));
		String text = "";
		while(scnr.hasNext()){
		String line = scnr.next();
		text += line;
		}
		
		
		System.out.println(tandy.search(text));
		System.out.println(text.indexOf("Tandy"));
	}
}
