
public class PercolationStats {
	private double[] iter;
	private Percolation perc;
	private int T;
	
	public PercolationStats(int N, int T){
		 if (N <= 0 || T <= 0) throw new java.lang.IllegalArgumentException("Invalid arguments");
		
		
		this.iter = new double[T];
		this.T = T;
		for(int i=0; i<T;i++){
			this.perc = new Percolation(N);
			double num=0;
			while(!this.perc.percolates()){
				int p = StdRandom.uniform(N)+1;
				int j = StdRandom.uniform(N)+1;
				//System.out.println("p:" + p+"j:"+j);
				if (!this.perc.isOpen(p,j)){
					this.perc.open(p, j);
					num++;
				}
			}
				
			//System.out.println(num/(N*N));
				this.iter[i]=num/(N*N);
		}
		
		//System.out.println("mean = " + this.mean());
		//System.out.println("stddev" + this.stddev());
	}
	
	public double mean(){
		return StdStats.mean(iter);
	}
	
	public double stddev(){
		return StdStats.stddev(iter);
	}
	
	public double confidenceLo(){
		return (this.mean() - (1.96* this.stddev()/ Math.sqrt(T)));
	}

	public double confidenceHi() {
		return (this.mean() + (1.96* this.stddev()/ Math.sqrt(T)));

	}
	
	public static void main(String[] args){
		
		//In in = new In(args[0]);
		
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		
		PercolationStats percStats = new PercolationStats(N, T);
		
		
		StdOut.println("mean = " + percStats.mean());
		StdOut.println("stddev = " + percStats.stddev());
		StdOut.println("95% confidence interval = " + percStats.confidenceLo() + ","+ percStats.confidenceHi());
		

	}
}
