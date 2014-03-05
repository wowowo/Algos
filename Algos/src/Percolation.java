
public class Percolation {
	private WeightedQuickUnionUF uf;
	private int size;
	private boolean[] openned;

	public Percolation(int N){
		 this.uf = new WeightedQuickUnionUF(N*N+2);
		 this.openned = new boolean[N*N+2];
		 openned[0] = true;
		 openned[openned.length-1] = true;
		 this.size = N;
	}
	
	public void open(int i, int j){


	    if (i <= 0 || i > size || j <= 0 || j>size) throw new IndexOutOfBoundsException("row index i out of bounds");


		int p = (i-1)*size + j;
		openned[p]=true;
		
		if(p+size>=openned.length-1) uf.union(p,openned.length-1);
		else if(openned[p+size]) uf.union(p, p+size);
		
		if(p-size<=0) uf.union(p,0);
		else if(openned[p-size]) uf.union(p, p-size);
		
		if(p+1<=i*size) 
			if(openned[p+1])
				uf.union(p,p+1);
		
		if(p-1!=(i-2)*size +size)
			if(openned[p-1])
				uf.union(p, p-1);
		
	}
	
	public boolean isOpen(int i, int j){
	    if (i <= 0 || i > size || j <= 0 || j>size) throw new IndexOutOfBoundsException("row index i out of bounds");
		return openned[(i-1)*size + j];
	}
	
	public boolean isFull(int i, int j){
		  if (i <= 0 || i > size || j <= 0 || j>size) throw new IndexOutOfBoundsException("row index i out of bounds");
		return uf.connected(0, (i-1)*size + j);
	}

	
	public boolean percolates(){
		return uf.connected(0, openned.length-1);

	}
	
}
