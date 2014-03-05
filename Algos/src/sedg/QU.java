package sedg;

import java.util.Arrays;

public class QU {
	private int[] id;
	private int[] sz;
	private int size;
	
	public QU(int N) {
		this.id = new int[N];
		this.sz = new int[N];
		this.size = N;
		for(int i=0; i<N;i++){
			id[i]=i;
			sz[i]=1;
		}
		
	}
	
	private int root(int i) {
		while(i!=id[i]) {
			id[i] = id[id[i]];
			i=id[i];
		}
		return i;
	}
	
	public int size() {
		return size;
	}
	

	
	
	public boolean connected(int p, int q) {
		return root(p)==root(q);
	}
	

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		else{ id[j] = i; sz[i] += sz[j]; }
		size--;
		
	}

	
}
