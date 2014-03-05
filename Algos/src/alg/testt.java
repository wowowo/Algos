package alg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import season2.Kruskal;

public class testt {
	private static int numOFEdges;
	
public static void main(String[] args) throws FileNotFoundException{
	WeightedEdgeGraph graph = buildGraph();
	//graph.print();
	Timer.start();
	Primm.mst(graph, numOFEdges*2);
	Timer.stop();
	Primm.weight();
	
	int i = 0;
	Timer.start();
	season2.Bag<Edge> bag = Kruskal.bagIT(graph);
	Timer.stop();
	Iterator<Edge> itr = bag.iterator();
	while(itr.hasNext()){
		i += itr.next().getWeight();
	}
	System.out.println(i);
}


public static WeightedEdgeGraph buildGraph() throws FileNotFoundException{
	WeightedEdgeGraph graph;
	
	 String asd = "QuickSort.txt";
	 java.io.File file = new File(asd) ;

	 Scanner input = new Scanner(file);
	 String first[] = input.nextLine().split("[ ]+");
	 graph = new WeightedEdgeGraph(Integer.parseInt(first[0] + 1));
	 numOFEdges = Integer.parseInt(first[1]); 
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
