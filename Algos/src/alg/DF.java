package alg;

import java.util.Arrays;

public class DF {
	static boolean[] inspected;
	private static Stack<Integer> stacky;
	static int order;
	private static int globailLoop=0;
	private static int leader;
	private static int [] leaders;
	
	public static void search(Graph graph, int s){
	inspected = new boolean[graph.V()];
	dfs(graph,s);
		
	}

	
	private static void dfs(Graph graph, int s) {
		inspected[s] = true;
		for(int x:graph.adj(s)){
			if (!inspected[x]) dfs(graph,x);
			
		}
	}
	
	
	public static void sort(Graph graph){
		order = graph.V()-1;
		stacky = new Stack<Integer>();
		inspected = new boolean[graph.V()];
		for(int i= 1;i<graph.V();i++){
			if(!inspected[i]) dfsort(graph,i);
		}
		
		
	}


	private static void dfsort(Graph graph, int s) {
		inspected[s] = true;
		for(int x:graph.adj(s))
			if (!inspected[x]) dfsort(graph,x);
			
		stacky.push(s);
		//System.out.println("Vertex " + s +" is in position " +order);
		//order--;
	}

	public static int ReverseOrder(){
		return stacky.size;
	}
	
	public static Stack<Integer> getStack(){
		return stacky;
	}

	
	public static int[] strongCC(Graph graph){
		leaders = new int[graph.V()];
		/*Timer.start();
		reverse(graph);
		Timer.stop();*/
		inspected = new boolean[graph.V()];
		while(stacky.size>0){
			int c = stacky.pop();
			if(!inspected[c]){
				leader = c;
				dfscc(graph,c);
				
			}
		}
		return leaders;
	}
	
	
	private static void dfscc(Graph graph, int s) {
		inspected[s] = true;
		leaders[s]=leader;
		for(int x:graph.adj(s))
			if (!inspected[x]) dfscc(graph,x);
			
		//stacky.push(s);
		//System.out.println("Vertex " + s +" is in position " +order);
		//order--;
		
	}


	private static void reverse(Graph graph){
		int n = graph.V();
		inspected = new boolean[n];
		stacky = new  Stack<Integer>();
		for( globailLoop = n-1;globailLoop>0;globailLoop--){
			//if(graph.bag(i).getItems()==0) inspected[i] = true;
			for(int x: graph.adj(globailLoop))
				if(!inspected[x])
					dfr(graph,x);
		}
	}


	private static void dfr(Graph graph, int x) {
		inspected[x]=true;	
			for(int i=globailLoop;i>0;i--)				
				for(int w:graph.adj(i))
						if(w==x && !inspected[i])
							dfr(graph,i);

			stacky.push(x);
		
	}

}
