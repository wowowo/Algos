package unfamiliar;

import java.io.FileNotFoundException;
import java.util.Arrays;

import alg.Edge;
import alg.WeightedEdgeGraph;

public class FloydWarshall {
	static int V;
	static int[][][] check;

	public static void allPairsPath(WeightedEdgeGraph graph) {
		V = graph.V();
		int n = graph.edges(); // CHECK!
		check = new int[V][V][V];

		for (int i = 1; i < V; i++)
			for (int j = 1; j < V; j++)
				if (i == j)
					check[i][j][0] = 0;
				else
					check[i][j][0] = 1000000;

		for (int i = 1; i < V; i++)
			for (Edge e : graph.adj(i))
				check[e.tail()][e.head()][0] = e.getWeight();

		// System.out.println(Arrays.toString(check[4][1]));

		for (int k = 1; k < V; k++)
			for (int i = 1; i < V; i++)
				for (int j = 1; j < V; j++)
					check[i][j][k] = Math.min(check[i][j][k - 1],
							check[i][k][k - 1] + check[k][j][k - 1]);

		int min = check[1][1][1];
		for (int i = 1; i < V; i++)
			for (int j = 1; j < V; j++)
				if (check[i][j][V - 1] < min)
					min = check[i][j][V - 1];

		if (!negative())
			System.out.println(min);
		else
			System.out.println("NEGATIVE");
	}

	// private static void check(int i, int j, WeightedEdgeGraph graph) {
	// for(Edge e: graph.adj(i))
	// if(e.tail() == i && e.head() == j)
	// check[i][j][0] = e.getWeight();
	// else check[i][j][0] = 1000000;
	// }

	private static boolean negative() {
		for (int i = 1; i < V; i++)
			if (check[i][i][V - 1] < 0)
				return true;
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		WeightedEdgeGraph graph = WeightedEdgeGraph.buildGraph(1001);
		FloydWarshall.allPairsPath(graph);
	}
}
