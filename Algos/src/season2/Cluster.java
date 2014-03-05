package season2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import alg.Edge;
import alg.EdgeHeap;
import alg.WeightedEdgeGraph;

import sedg.QU;

public class Cluster {
	static int numOFEdges;
	static Bag<Edge> bagOfEdges ;

	
	public static void main(String[] args) throws FileNotFoundException{
		WeightedEdgeGraph graph = buildGraph();
	//	System.out.println(graph.V());
		Cluster.it(graph, 8);
		Cluster.findClusters(graph, 80);
		
		
		
				
				
				
				
			
				
		
		
	}
	
	
	

	public static void it(WeightedEdgeGraph graph, int numOFClusters){
		QU qu = new QU(graph.V());
		bagOfEdges = new Bag<Edge>();
		EdgeHeap heap = new EdgeHeap(graph.V()*500);
		
		for(int i =0; i < graph.V(); i++)
			for(Edge e : graph.adj(i))
				heap.insert(e);
		
		while(qu.size() > numOFClusters){
			Edge e = heap.getMin();
			int v = e.tail();
			int w = e.head();
			
			if(!qu.connected(v, w)){
				bagOfEdges.add(e);
				qu.union(v, w);
			}
		}
		
		Edge k = heap.getMin();
		while(!qu.connected(k.head(), k.tail()))
			k = heap.getMin();
		System.out.println(k.getWeight());
		
	}

	
	public static void findClusters(WeightedEdgeGraph graph, int maxSpacing){
		QU qu = new QU(graph.V());
		bagOfEdges = new Bag<Edge>();
		EdgeHeap heap = new EdgeHeap(graph.V()*500);
		int n = 0;
		
		for(int i =0; i < graph.V(); i++)
			for(Edge e : graph.adj(i))
				heap.insert(e);
		
		while(!heap.isEmpty()){
			Edge e = heap.getMin();
			int v = e.tail();
			int w = e.head();
			
			if(!qu.connected(v, w)){
				if(e.getWeight() == maxSpacing) { System.out.println(graph.V() - 1 - n); break; }
				bagOfEdges.add(e);
				qu.union(v, w);
				n++;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static WeightedEdgeGraph buildGraph() throws FileNotFoundException{
		WeightedEdgeGraph graph;
		
		 String asd = "QuickSort.txt";
		 java.io.File file = new File(asd) ;

		 Scanner input = new Scanner(file);
		 String first[] = input.nextLine().split("[ ]+");
		 graph = new WeightedEdgeGraph(Integer.parseInt(first[0])+ 1);
		// numOFEdges = Integer.parseInt(first[1]); 
		 while (input.hasNext()) {
			String line=input.nextLine();
			String[] edge = line.split("[ ]+");
			Edge k = new Edge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]));
			k.setWeigth(Integer.parseInt(edge[2]));
			graph.addEdge(k);
		
		 }
		 

		 input.close();
		 
		 
		 return graph;
		 
			}



}
