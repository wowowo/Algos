package alg;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class HashTest {
	static long [] array = new long[1000000];
	static Bag<Long> bagy = new Bag<Long>();
	static ArrayList<Integer> list2 = new ArrayList<Integer>();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Long> result = new ArrayList<Long>();
	static BloomFilter bloom = new BloomFilter(40009);



	
	
	public static void main(String[] args) throws FileNotFoundException{
	JFileChooser fileChooser = new JFileChooser();
	if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){ 
	 java.io.File file =fileChooser.getSelectedFile() ;
	 int k=0;
	 Scanner input = new Scanner(file);
	 Timer.start();
	 while (input.hasNext()) {
	String line=input.nextLine();
		array[k++]=Long.parseLong(line);
	 }

	 input.close();
	 }
	
	

	
	Arrays.sort(array);


		
		
		for(int i=0;i<499991;i++){
			binaryRange(array,499990,array.length-1,i);
		}
		
		
	
		
		for(int i=499991;i<array.length-1;i++){
			binaryRangePositive(array,0,499989,i);
		}
		
		Timer.stop();
		
		
	
		System.out.println("NEGATIVE SIZE:"+list2.size());

		System.out.println("Positive SIZE:"+list.size());

		
/*		Timer.start();
		int t=0;
		for(int i=0;i<list.size();i++){
			int j = list.get(i);
			for(int b:list2){
				long a = array[j]+array[b];
				if(a>=-10000 && a<=10000 && !bloom.check(a) && array[j]!=array[b]){
					//System.out.println("ENTRY : "+ array[j]+" ENTRY: "+array[b]+" ="+a);
					bloom.insert(a);
					result.add(a);
					t++;
				}
					
				
			}
		
		}
		Timer.stop();
		System.out.println("TEST: "+t);*/
		Collections.sort(result);
		System.out.println(Arrays.toString(result.toArray()));
		System.out.println(result.size());
		int t=0;
		for(int i=1;i<result.size();i++)
			if(result.get(i)==result.get(i-1))
				t++;
		System.out.println("TEST: "+t);
		

	
		
		
		
		
		/*int t = 0;
	for(int i=0;i<array.length/2;i++){
		bagy.add(array[i]);
		for(long j=-10000;j<10001;j++){ 
			long a = asd.get(j-array[i]);
			if(a!=0) t++;
		}
	}
	System.out.print(t);
	*/

	
	}
	

	private static int inRangePositive(long[] array,int neg, int pos){
		long a = array[neg]+array[pos];
		if(a>=-10000 && a<=10000) return 0;
		else if(a<-10000) return 1;
		else return -1;
	}
	
	private static void binaryRangePositive(long[] array,int start,int end,int neg ){
		if(start>=end) return;
		int mid = start+(end-start)/2;
		int direction = inRangePositive(array,neg,mid);
		if(direction==0) {
			long a = array[neg] + array[mid];
			if(!bloom.check(a)) {
				result.add(a);
				bloom.insert(a);
			}
		
		binaryRangePositive(array,start+1,end,neg);
		
		}
		else if(direction > 0) binaryRangePositive(array,mid+1,end,neg);
		else binaryRangePositive(array,start,mid-1,neg);
	}
	
	private static int inRange(long[] array,int neg, int pos){
		long a = array[neg]+array[pos];
		if(a>=-10000 && a<=10000) return 0;
		else if(a<-10000) return 1;
		else return -1;
	}
	
	private static void binaryRange(long[] array,int start,int end,int neg ){
		if(start>=end) return;
		int mid = start+(end-start)/2;
		int direction = inRange(array,neg,mid);
		if(direction==0) {
			long a = array[neg] + array[mid];
			if(!bloom.check(a)) {
				result.add(a);
				bloom.insert(a);
				} 
			
			binaryRange(array,start+1,end,neg);
			}
		else if(direction > 0) binaryRange(array,mid+1,end,neg);
		else binaryRange(array,start,mid-1,neg);
	}
}

