package season2;


public  class Job implements Comparable<Job>{
	double weight,length,ratio;
	
	public Job(double d, double e){
		this.length = e;
		this.weight = d;
		this.ratio = d - e;
	}

	public int compareTo(Job that) {
		if(this.ratio > that.ratio) return 1;
		else if(this.ratio < that.ratio) return -1;
		else if(this.ratio == that.ratio && this.weight > that.weight) return 1;
		else return -1;
	}
}
