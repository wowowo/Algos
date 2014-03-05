package sedg;

import java.util.Arrays;

public class PriorityQueue<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int N) {
		this.pq = (Key[]) new Comparable[N + 1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key key) {
		pq[++N] = key;
		swim(N);
		
	}
	
	public Key delMin() {
		Key min = pq[1];
		exch(1,N--);
		sink(1);
		pq[N + 1] = null;
		return min;
	}
	
	private void swim(int i) {
		
		while(i > 1 && less(i/2, i)){
			
			exch(i, i/2);
			i = i/2;
		}
	}
	
	private void sink(int i) {
		
		while(2 * i <= N){
			int j = i * 2;
			if(j < N && less(j, j+1)) j++; 
			if(!less(i, j)) break;
			exch(i, j);
			i = j;
		}
	}
	
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) > 0;
	}
	
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(10);
		pq.insert(5);
		pq.insert(7);
		pq.insert(2);
		pq.insert(1);
		pq.insert(3);
		pq.insert(9);

		System.out.println(Arrays.toString(pq.pq));
		
		while(!pq.isEmpty())
			System.out.println(pq.delMin());

	}


}
