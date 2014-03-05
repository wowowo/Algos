package unfamiliar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnuthMorrisPratt {

	String pat;
	int M;
	int[][] dfa;
	int R;

	public KnuthMorrisPratt(String pat) {
		
		this.pat = pat;
		R = 256;
		M = pat.length();
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;

		for (int X = 0, j = 1; j < M; j++) {

			for (int r = 0; r < R; r++)
				dfa[pat.charAt(r)][j] = dfa[pat.charAt(r)][X];

			dfa[pat.charAt(j)][j] = j + 1;
			X = dfa[pat.charAt(j)][X];

		}

	}

	public int search(String text) {
		
		int j, i, N = text.length();

		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[text.charAt(i)][j];

		if (j == M)
			return i - M;
		
		else
			return N;

	}

	public static void main(String[] args) throws FileNotFoundException {
		
		KnuthMorrisPratt tandy = new KnuthMorrisPratt("before");
		Scanner scnr = new Scanner(new File("clustering_small.txt"));
		String text = "";
		while (scnr.hasNext()) {
			String line = scnr.next();
			text += line;
		}

		System.out.println(tandy.search(text));
		System.out.println(text.indexOf("before"));
	}

}
