package season2;

import alg.Edge;
import alg.EdgeHeap;
import alg.WeightedEdgeGraph;
import sedg.QU;


public class Kruskal {
	public static Bag<Edge> bagIT(WeightedEdgeGraph graph){
		QU qu = new QU(graph.V());
		Bag<Edge> bagOfEdges = new Bag<Edge>();
		EdgeHeap heap = new EdgeHeap(graph.V()*2);
		
		for(int i =0; i < graph.V(); i++)
			for(Edge e : graph.adj(i))
				heap.insert(e);
		
		while(!heap.isEmpty()){
			Edge e = heap.getMin();
			int v = e.tail();
			int w = e.head();
			
			if(!qu.connected(v, w)){
				bagOfEdges.add(e);
				qu.union(v, w);
			}
		}
		return bagOfEdges;
	}
}
