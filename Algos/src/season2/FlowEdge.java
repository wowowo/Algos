package season2;

public class FlowEdge implements Comparable<FlowEdge> {

	private final int v;
	private final int w;
	private final double capacity;
	private double flow;
	
	public FlowEdge(int v, int w, double capacity){
		this.v=v;
		this.w=w;
		this.capacity=capacity;
		
	}
	
	public int from() {
		return v;
	}
	
	public int to(){
		return w;
	}

	public int other(int a) {
		if(a==v) return w;
		return v;
	}
	
	public double capacity(){
		return capacity;
	}
	
	public double flow(){
		return flow;
	}
	
	public int compareTo(FlowEdge that) {
		if(this.capacity==that.capacity) return 0;
		else if(this.capacity>that.capacity) return 1;
		return -1;
	}

	public double residualCapacityTo(int vertex){
		if(vertex==v) return flow;
		else return capacity-flow;
	}
	
	public void addResidualFlow(int vertex, double delta){
		if(vertex==v)flow-=delta;
		else flow+=delta;
	}
	
}
