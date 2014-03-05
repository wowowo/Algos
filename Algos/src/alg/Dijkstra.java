package alg;

import java.util.Arrays;

//MAY NOT WORK PROPERLY PRIMM MODIFICATIONS

public class Dijkstra {
	static boolean[] inspected;
	static int[] key;
	static int [] paths;
	static EdgeHeap heapy;
	static int weight;

	public static void shortestPath(WeightedEdgeGraph graph){
		inspected = new boolean[graph.V()];
		paths = new int[graph.V()];
		heapy = new EdgeHeap(4000);


				calc(graph,1);
				

					while(!heapy.isEmpty()){
					Edge k = heapy.getMin();
					if(inspected[k.head()]) continue;
					paths[k.head()] = k.getWeight();
					calc(graph,k.head());
					}
				
		
		
	}
	private static void calc(WeightedEdgeGraph graph, int i) {
		inspected[i]=true;
		
		
		for(Edge e:graph.adj(i)){
			Edge withShortestPath = null;
			
			if(!inspected[e.head()]){
				e.setWeigth(e.getWeight() + paths[e.tail()]);
				  withShortestPath = e;
				for(Edge o : graph.adj(e.head()))
					if(inspected[o.tail()])
						if(paths[o.tail()] + o.getWeight() < withShortestPath.getWeight())
							withShortestPath = o;
				

				
				
			}

			if(withShortestPath != null) heapy.insert(withShortestPath);

		}
	}
	
	public static void print(){
		/*System.out.println(Arrays.toString(paths));
		System.out.print("Input this;"+ paths[7]+","+ paths[37]+","+ paths[59]+","+ paths[82]+","+ paths[99]+","+ paths[115]+","
				+ paths[133]+","+ paths[165]+","+ paths[188]+","+ paths[197]);
		System.out.print(" 1 to 80:"+paths[80]+" 80 to 36:"+paths[36]);*/
		


	}

}
