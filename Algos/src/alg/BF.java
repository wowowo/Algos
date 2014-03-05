package alg;

public class BF {
	static boolean[] inspected;
	static int CC;
	static Queue<Integer> quey = new Queue<Integer>();

	public static void search(Graph graph) {
		inspected = new boolean[graph.V()];
		
		for (int i = 1; i < graph.V(); i++) {
			if (inspected[i] == false) {
				CC++;
				bfs(graph, i);
			}
		}
		System.out.println("Connected Components:" + CC);
	}

	private static void bfs(Graph graph, int i) {
		inspected[i] = true;
		quey.enque(i);
		while (!quey.isEmpty()) {
			int v = quey.dequeue();
			for (int w : graph.adj(v)) {
				if (!inspected[w]) {
					inspected[w] = true;
					quey.enque(w);
				}
			}
		}
	}

}
