package alg;

public class HashTableInt {
		private long[] map;
		private int size;
		
		public HashTableInt(){
			map = new long[2000003];
			
		}
	
		private int hash(long a){
			a=31*a+17;
			return (int) ((a & 0x7fffffff)%map.length);
		}
		
		public void insert(long a){
			int hash = hash(a);
			int i;
			for( i =hash;map[i]!=0;i=(i+1)%map.length)
				if(map[i]==a) 
					break;
			map[i] = a;
			size++;
		
			
		}

		public long get(long a){
			int hash = hash(a);
			int i;
			for( i =hash;map[i]!=0l;i=(i+1)%map.length)
				if(map[i] == a) return map[i];
			return  0;
		
		}
		
}

