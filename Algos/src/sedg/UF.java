package sedg;

public class UF {
	
	public int[] id;
	
	
	public UF(int N) {
		this.id = new int[N];
		for(int i=0; i<N;i++)
			id[i]=i;
	}
	
	public boolean connected(int p, int q) {
		return id[p]==id[q];
	}
	
	public void union(int p, int q ) {
		int pid = id[p];
		int qid = id[q];
		for(int i=0; i<id.length;i++)
			if (id[i] == pid)
				id[i] = qid;
	}
	
}
