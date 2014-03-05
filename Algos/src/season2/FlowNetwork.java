package season2;

public class FlowNetwork {
	//Starts with 0!
	
	private int V;
	private Bag<FlowEdge> [] edges;

	@SuppressWarnings("unchecked")
	public FlowNetwork(int V){
		this.V = V;
		edges =  (Bag<FlowEdge>[]) new Bag[V];
		for(int i =0; i<V;i++)
			edges[i]= new Bag<FlowEdge>();
		
	}
	
	public int V(){
		return V;
	}
	
	public void addEdge(FlowEdge edge){
		int v = edge.from();
		edges[v].add(edge);
		edges[edge.other(v)].add(edge);
	}
	
	public Iterable<FlowEdge> adj(int v){
		return edges[v];
		
	}
	
	//ZERO!
	public void print(){
		for(int i=0;i<V;i++){
			for(FlowEdge x: this.adj(i))
				System.out.print(x.capacity()+", ");
			System.out.println();
			
		}
	}
}
