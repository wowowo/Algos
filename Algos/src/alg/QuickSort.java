package alg;
import java.util.Arrays;

public class QuickSort {
	static int count;
public static void quicksort(int[] a){
	
	quicksort(a,0,a.length-1);
}

private static void quicksort(int[] a, int s, int e) {
	if(e<=s) return;
	int j = partition(a,s,e);
	quicksort(a,s,j-1);
	quicksort(a,j+1,e);


}

private static int partition(int[] a, int s, int e) {
	int temp;
	
/*	int median  = median(a,s,e);
if(median == e) {
	temp = a[e];
	a[e] = a[s];
	a[s]=temp;}
if( median > s && median< e) {
	temp = a[median];
	a[median] = a[s];
	a[s] = temp;}*/
	
	int p = a[s];
	int i = s+1;
	for (int j = s+1;j<=e;j++){
		if(a[j]<p) {
			temp = a[j];
			a[j] = a[i];
			a[i]=temp;
			i++;
			
		}
		count++;
	}
	temp = a[i-1];
	a[i-1] = a[s];
	a[s]=temp;
	
//count += e-s-1;
	return i-1;
}

public static void getCount(){
	System.out.println(count);
}


public  static int median(int a[],int s, int e){
	int first = a[s];
	int middle = (s+e)/2;
	int last = a[e];
	int length = e-s;
	/*if (length%2!=0) middle = a[(length-1)/2]; 
	else middle=a[length/2-1];*/
    if ( (first - middle) * (last - first) >= 0 ) // a >= b and a <= c OR a <= b and a >= c
        return s;
    else if ( (middle - first) * (last - middle) >= 0 )    	// b >= a and b <= c OR b <= a and b >= c
    	return middle;
   /* {
    	if(length%2!=0) return (length-1)/2;
    	else return (length/2)-1;
    }*/
    else
        return e;
    // a = first b = middle c = last
}

public static void rsel(int [] a, int i){
	rsel(a,0,a.length-1,i);
		
	
}

private static void rsel(int[] a, int s, int e, int ith) {
	if(e<=s){
		System.out.println(a[s]);
		return;
	}
int pivot = partition(a,s,e);
System.out.println("pivot:"+pivot);
System.out.println("array:"+Arrays.toString(a));
if (pivot == ith-1) {
	System.out.println(a[pivot]);
	return;
}
if(pivot < ith-1) rsel(a,pivot+1,e,ith);
else rsel(a,s,pivot-1,ith);
	
}
}
