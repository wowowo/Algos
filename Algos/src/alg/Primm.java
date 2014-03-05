package alg;

public class Primm {
	private static EdgeHeap heap;
	private static Queue<Edge> edges;
	private static boolean[] inspected;
	private static int weight = 0;
	
	public static void mst(WeightedEdgeGraph graph, int numOfEdges){

		heap = new EdgeHeap(numOfEdges);
		edges = new Queue<Edge>();
		inspected = new boolean[graph.V()];
		primm(graph,1);
	
		while(!heap.isEmpty()){
			Edge k = heap.getMin();
			if(inspected[k.head()] && inspected[k.tail()]) continue;
			edges.enque(k);
			weight += k.getWeight();
			if(!inspected[k.tail()]) primm(graph,k.tail());
			if(!inspected[k.head()]) primm(graph,k.head());

			
		}
		
	}

	private static void primm(WeightedEdgeGraph graph, int i) {
		for(Edge e:graph.adj(i))
			if(!inspected[e.head()] || !inspected[e.tail()])
				heap.insert(e);
		inspected[i] = true;

	}
	
	public static Queue<Edge> tree(){
		return edges;
	}
	
	public  static void weight(){
		System.out.println(weight);
	}

}
