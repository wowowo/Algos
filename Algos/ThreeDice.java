package sedg;

import java.util.Arrays;

public class ThreeDice {
	
	private int[] die = new int[3];
	private int[] sequence1 = {1,2,3};
	private int[] sequence2 = {4,5,6};
	private String asd;
	public static Scanner scnr;
	
	public ThreeDice(int i, int j, int k) {
		die[0] = i;
		die[1] = j;
		die[2] = k;
		Arrays.sort(die);
	}
	
	public String checkScore() {
		
		if( die[0] == die[1] && die[1] == die[2] && die[0] == die[2]){
			return "Three the same";}
		
		for(int a = 0, a <10; a++){
			
		}
		
		if(die[0] == die[1] || die[0] == die[2] || die[1] == die[2])
			return "A pair";
		
		if( Arrays.equals(die, sequence1) || Arrays.equals(die, sequence2) ) 
			return "A run";
		
		return "All different";
		
	}


	
}