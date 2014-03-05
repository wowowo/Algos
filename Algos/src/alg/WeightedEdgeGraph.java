package alg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;




public class WeightedEdgeGraph {
	private final int V;
	private Bag<Edge>[] adj;
	private int edges;

	@SuppressWarnings("unchecked")
	public WeightedEdgeGraph(int V){
		this.V=V;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int v=0;v<V;v++){
			adj[v] = new Bag<Edge>();
		}
	}

	public void addEdge(Edge e){
		int v = e.tail();
		int w = e.head();
		adj[v].add(e);
		adj[w].add(e);
		edges++;
	}
		
	public Iterable<Edge> adj(int v){
		return adj[v];
		

	}
	
	public int V(){
		return V;
	}

	public int edges(){
		return edges;
	}

	public static WeightedEdgeGraph buildGraph(int vertecies) throws FileNotFoundException{
		WeightedEdgeGraph graph = new WeightedEdgeGraph(vertecies);
		
		 String asd = "QuickSort.txt";
		 java.io.File file = new File(asd) ;

		 Scanner input = new Scanner(file);
		 
			String lines=input.nextLine();
			String[] edgess = lines.split("\\s+");
			
			
	     
		 while (input.hasNext()) {
			 
		String line=input.nextLine();
		String[] edges = line.split("\\s+");
		
		//System.out.println(Arrays.toString(edges));
	
				 Edge a = new Edge(Integer.parseInt(edges[0]),Integer.parseInt(edges[1]));
				 a.setWeigth(Integer.parseInt(edges[2]));
				 graph.addEdge(a);
				 
			 
		 }
		 

		 input.close();
		 
		 
		 return graph;
		 
			}
	
	public void print(){
		for(Edge e:this.adj(1))
			System.out.println(e.getWeight());
	}


	


}




