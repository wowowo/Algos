package alg;

public class BloomFilter {
	boolean[] map;
	
	public BloomFilter(int size){
		map = new boolean[size];
		
	}

	private int hash(long a){
		a=31l*a+17l;
		return (int) ((a & 0x7fffffff)%map.length);
	}
	private int hash2(long a) {
		
		a=31*a+83;
		return (int) ((a & 0x7fffffff)%map.length);
		
	}
	private int hash3(long a) {
		
		a=31*a+31;
		return (int) ((a & 0x7fffffff)%map.length);
		
	}
	
	public void insert(long a){
		int hash = hash(a);
		int hash2 = hash2(a);
		int hash3  = hash3(a);
		if(!map[hash]) map[hash]=true;
		else if(!map[hash2]) map[hash2]=true;
		else if (!map[hash3]) map[hash3]=true;
	
		
	}

	public boolean check(long a){
		int hash = hash(a);
		int hash2 = hash2(a);
		int hash3  = hash3(a);
		if(map[hash]) return true;
		else if(map[hash2]) return true;
		else if (map[hash3])  return true;
		return false;
	
	}
}
