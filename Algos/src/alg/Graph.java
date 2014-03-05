package alg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Graph {
	private int contractions;
	private int[] shuffled;
	private final int V;
	private Bag<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		// adj[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];

	}

	public int V() {
		return V;
	}

	public Bag<Integer> bag(int a) {
		return adj[a];
	}

	public static Graph buildGraph(int vertecies) throws FileNotFoundException {
		Graph graph = new Graph(vertecies);

		String asd = "QuickSort.txt";
		java.io.File file = new File(asd);

		Scanner input = new Scanner(file);
		int k = 0;
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] nums = line.split("\\s+");
			// System.out.println(Arrays.toString(nums));
			for (int i = 1; i < nums.length; i++) {
				graph.addEdge(Integer.parseInt(nums[k]),
						Integer.parseInt(nums[i]));
			}
		}

		input.close();

		return graph;

	}

	public static Graph buildReverseGraph(int vertecies)
			throws FileNotFoundException {
		Graph graph = new Graph(vertecies);

		String asd = "QuickSort.txt";
		java.io.File file = new File(asd);

		Scanner input = new Scanner(file);
		int k = 0;
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] nums = line.split("\\s+");
			// System.out.println(Arrays.toString(nums));
			for (int i = 1; i < nums.length; i++) {
				graph.addEdge(Integer.parseInt(nums[i]),
						Integer.parseInt(nums[k]));
			}
		}

		input.close();

		return graph;

	}

}