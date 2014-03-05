package unfamiliar;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import alg.Edge;
import alg.WeightedEdgeGraph;

public class BellmanFord {
	// CHECK STARTING INDECIES
	public static void pathIT(WeightedEdgeGraph graph) {
		int edges = graph.edges();
		int V = graph.V();
		int[][] check = new int[edges][V];
		check[0][1] = 0;

		for (int i = 2; i < V; i++)
			check[0][i] = 1000000; // change to infinity with doubles

		for (int i = 1; i < edges; i++)
			for (int v = 2; v < V; v++)
				check[i][v] = Math
						.min(check[i - 1][v], min(i, v, graph, check));

		// Arrays.sort(check[edges-1]);
		System.out.println(Arrays.toString(check[edges - 1]));
	}

	private static int min(int i, int v, WeightedEdgeGraph graph, int[][] check) {
		ArrayList<Edge> edges = new ArrayList<Edge>();

		for (Edge e : graph.adj(v))

			if (e.head() == v) {
				Edge g = e.clone();
				int a = e.getWeight();
				g.setWeigth(check[i - 1][g.tail()] + a);
				edges.add(g);
			}

		Collections.sort(edges);
		// System.out.println(edges.get(0).getWeight());
		if (edges.size() == 0)
			return 1000000;
		return edges.get(0).getWeight();
	}

	public static void main(String[] args) throws FileNotFoundException {
		WeightedEdgeGraph graph = WeightedEdgeGraph.buildGraph(6);
		BellmanFord.pathIT(graph);
	}
}
