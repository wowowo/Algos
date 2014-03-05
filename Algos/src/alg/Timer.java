package alg;

import java.util.Random;


public class Timer {
	static long l;
	static long k;
public static void start(){
	l = System.currentTimeMillis();
}
public static void stop(){
	k = System.currentTimeMillis(); 
	System.out.println(k-l);
}



public static void shuffle(int [] num){
	 Random rand = new Random(); 	 
	 
	 for (int i = num.length-1; i > 0; i--)
	 {
	     int n = rand.nextInt(i +1);
	     int temp = num[i];
	     num[i] = num[n];
	     num[n] = temp;
	 }
	 
}	
}