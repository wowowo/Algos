package season2;

import alg.Queue;


public class FordFulkerson {
	private FlowEdge[] edgeTo;
	private boolean[] marked;
	private double value;
	
   public FordFulkerson(FlowNetwork G, int s, int t) {
	   value = 0;
	   while (hasAugmentingPath(G,s,t)){
		   double bottle = Double.POSITIVE_INFINITY;
		 
		   for(int v=t; v!=s; v=edgeTo[v].other(v))
			   bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
		   
		   for(int v=t; v!=s; v=edgeTo[v].other(v))
			  edgeTo[v].addResidualFlow(v, bottle);
		   
		   value+=bottle;
		   
	   }
		
	}

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
	edgeTo = new FlowEdge[G.V()];
	marked = new boolean [G.V()];
	
	Queue<Integer> q = new Queue<Integer>();
	q.enque(s);
	marked[s]=true;
	while(!q.isEmpty()){
		int v = q.dequeue();
		for(FlowEdge e:G.adj(v)){
			int w = e.other(v);
			if(e.residualCapacityTo(w)>0 && !marked[w]){
				edgeTo[w]=e;
				marked[w]=true;
				q.enque(w);
			}
		}
	}
	
	
	return marked[t];
}
	
    public boolean inCut(int t){
		return marked[t];
	}
	
	public double value(){
		return value;
	}

	
}
