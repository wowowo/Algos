package season2;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Knapsack {
	
	static int[] v;
	static int[] w;
	static int totalWeight;

	public static void main(String[] args) throws FileNotFoundException{
		JFileChooser filechooser = new JFileChooser();
		if(filechooser.showOpenDialog(null)==filechooser.APPROVE_OPTION){
			java.io.File file = filechooser.getSelectedFile();
			Scanner input = new Scanner(file);
			
			String firstline = input.next();
			String secondline = input.next();
			

			v = new int[Integer.parseInt(secondline)];
			w = new int[Integer.parseInt(secondline)];
			totalWeight = Integer.parseInt(firstline);
			
			int k=0;
			while(input.hasNext()){
				firstline = input.next();
				secondline = input.next();
				v[k] = Integer.parseInt(firstline);
				w[k] = Integer.parseInt(secondline);
				k++;
			}
			input.close();
			
		}
		
		
		int[] old = new int[totalWeight+1];
		int[] current = new int[totalWeight+1];

		for(int i = 1; i < v.length; i++){
			for(int x = 0 ; x < totalWeight + 1; x++){
				if(w[i]> x) current[x] = old[x];
				else current[x] = Math.max(old[x], old[x-w[i]] + v[i]);
			}
			
			old = current;
		}
		
	
		System.out.println(current[totalWeight]);
	}
}
