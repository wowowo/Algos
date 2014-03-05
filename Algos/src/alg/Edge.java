package alg;


public class Edge implements Comparable<Edge>,Cloneable{
	private int head;
	private int tail;
	private int weight;
	public Edge(int tail,int head){
		this.tail = tail;
		this.head = head;
	}

	public Edge clone(){
		try {
			return (Edge) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setWeigth(int kg){
		this.weight = kg;
	}
	
	public int head(){
		return head;
	}
	public int tail(){
		return tail;
	}
	
	public int getWeight(){
		return weight;
	}

	
	public int compareTo(Edge that){
		if (this.weight>that.getWeight()) return +1;
		if (this.weight<that.getWeight()) return -1;
		return 0;

	}

}
