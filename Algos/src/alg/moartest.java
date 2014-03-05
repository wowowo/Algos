package alg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;




public class moartest {
	public static void main(String[] args) throws FileNotFoundException{
		Timer.start();
		Graph graph =Graph.buildGraph(875715);
		Graph reverse = Graph.buildReverseGraph(875715);

		DF.sort(reverse);

		int[] a =DF.strongCC(graph);
		//System.out.println(Arrays.toString(a));
		getOccurence(a);
		
		Timer.stop();
		//BF.search(graph);
		//DF.search(graph, 1);
		//MinCUt.cut(graph);
		//printGraph(graph);
/*		int i=0;
	stuff:for (i=15;i>0;i--)
			for(int j=0;j<15;j++)
				if(i==j)
					break stuff;
		System.out.println(i);*/
		
		//DF.strongCC(graph);
		
	/*	Stack <Integer> stacko = DF.getStack();
		for(int i = 0; i<DF.ReverseOrder();i++){
			System.out.print(stacko.pop()+", ");
			
		}*/
		
		


		
		
		
		
		}
	
	private static Graph buildGraph() throws FileNotFoundException{
		Graph graph = new Graph(201);
		
		 String asd = "QuickSort.txt";
		 java.io.File file = new File(asd) ;

		 Scanner input = new Scanner(file);
	     int k = 0;
		 while (input.hasNext()) {
		String line=input.nextLine();
		String[] nums = line.split("\\s+");
		//System.out.println(Arrays.toString(nums));
		 for(int i = 1;i<nums.length;i++){
			 graph.addEdge(Integer.parseInt(nums[k]),Integer.parseInt(nums[i]));
		 }
		 }

		 input.close();
		 
		 
		 return graph;
		 
			}

	private static void printGraph(Graph graph){
		for(int i=1;i<graph.V();i++){
			 System.out.print("adjnumber:"+i+" = ");
			 for(int x:graph.adj(i)) System.out.print(x+",");
			 System.out.println("");

		 }
	}


	private static void getOccurence(int[] a ){
		int[] c = new int[a.length];
		for (int i=1; i<a.length;i++)
			c[a[i]]++;
		Arrays.sort(c);
		for (int i=1;i<6;i++)
			System.out.println(c[c.length-i]);
	}



}

