package alg;

public class someAlgo {
	static EdgeHeap heap;
	static boolean[] inspected;
	static Queue<Edge> egdes;

	public static void mst(WeightedEdgeGraph graph) {
		heap = new EdgeHeap(graph.V() * graph.V());
		inspected = new boolean[graph.V()];
		egdes = new Queue<Edge>();
		for (int i = 1; i < graph.V(); i++) {
			if (!inspected[i])
				dfsort(graph, i);
		}

		inspected = new boolean[graph.V()];
		while (!heap.isEmpty()) {
			Edge k = heap.getMin();
			if (inspected[k.head()] && inspected[k.tail()])
				continue;
			else {
				inspected[k.head()] = true;
				inspected[k.tail()] = true;
				egdes.enque(k);
			}
		}
	}

	private static void dfsort(WeightedEdgeGraph graph, int s) {
		inspected[s] = true;
		for (Edge e : graph.adj(s))
			if (!inspected[e.head()])
				heap.insert(e);

	}

	public static Queue<Edge> tree() {
		return egdes;
	}
}
