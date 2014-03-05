package season2;

import java.util.Comparator;

public class Quick {
	static int position;
	public static void select(Comparee[] well, int ith, Comparator<Comparee> comp){
		rsel(well,0,well.length-1,ith,comp);
	}

	private static void rsel(Comparee[] a, int s, int e, int ith, Comparator<Comparee> comp) {
		if(e <= s) position = -1;
		int pivot = partition(a,s,e, comp);
		if (pivot == ith-1) { position = pivot; return; }
		if(pivot < ith-1) rsel(a,pivot+1,e,ith, comp);
		else rsel(a,s,pivot-1,ith,comp);
	}
	
	public static int position(){
		return position;
	}

	private static int partition(Comparee[] a, int lo, int hi, Comparator<Comparee> comp) {
		int i = lo, j = hi + 1;
		
		while(true){
			
			while(less(a[++i],a[lo], comp)) if (i==hi) break;
			
			while(less(a[lo],a[--j], comp)) if (j==lo) break;
			
			if (i>=j) break;
			exch(a,i,j);
		}
		
		exch(a,lo,j);
		return j;
	}
	
	private static boolean less(Comparee a, Comparee b, Comparator<Comparee> comp){
		return comp.compare(a,b)<0;
		}
	
	private static void exch(Comparee[] a, int i, int j){
		Comparee t = a[i];
		a[i] = a[j];
		a[j] = t;
	}


}
