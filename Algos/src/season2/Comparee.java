package season2;

import java.util.Comparator;

public class Comparee {
	int ones;
	String string;
	int diff;
	boolean stigmatized;
	public  final Comparator<Comparee> BY_DIFFERENCE = new by_Difference();
	
	private class by_Difference implements Comparator<Comparee>{

		public int compare(Comparee o1, Comparee o2) {
			int diff1 = 0, diff2 = 0;
			for(int i = 0; i < 24; i++){
				if(string.charAt(i) != o1.string.charAt(i)) diff1++;
				if(string.charAt(i) != o2.string.charAt(i)) diff2++;
			}
			o1.diff = diff1;
			o2.diff = diff2;
			
			if(diff1 > diff2) return 1;
			else if(diff2 > diff1) return -1;
			else return 0;
		}
		
	}
	
	public Comparee(String s, int ones){
		this.string = s;
		this.ones = ones;
	}

	
	
}
