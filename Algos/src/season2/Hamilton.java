package season2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Hamilton {
	private static Comparee[] well;
	private int position;
	private boolean[] checked;
	private int[] nums;
	
	public Hamilton(String str){
		Scanner input;
		try {
			input = new Scanner(new File(str));
		
		
		String firstLine = input.next();
		String secondLine = input.next();

		well = new Comparee[Integer.parseInt(firstLine)];
		checked = new boolean[Integer.parseInt(firstLine)];
		nums = new int[Integer.parseInt(firstLine)];


		int bits = Integer.parseInt(secondLine);
		int k = 0;
		String asd = "";
		int sd = 0;
		
		while(input.hasNext()){
			for(int j = 0; j < bits; j++){
				String a = input.next();
				if(a.equals("1")) sd++;
				asd += a;
				}	
			
			well[k] = new Comparee(asd, sd);
			sd = 0;
			asd = "";
			k++;
			
		} 
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void distanceIt() {
		int clusters = 0;
		Arrays.sort(well);
		
		for(int shit = 19; shit < 23; shit++){
			int start = findFirst(shit);
			if(start < 0) continue;
			int stop = findLast(shit+2);
			if(stop < 0) stop = findLast(shit+1);
			if(stop < 0) stop = findLast(shit);
			System.out.println("Shit" + shit + "start" + start + " stop" + stop);
			
			for(int i = start; i < stop; i++){
				for(int j = i + 1; j < stop; j++){
					if(checked[j]) continue;
					int diff = 0;
					for(int a = 0; a < 24; a++){
						if(well[i].string.charAt(a) != well[j].string.charAt(a))
							diff++;
						if(diff >= 3) break;
					}
					if(diff < 3) {clusters--; checked[j] = true;}
				}
			}
			
			System.out.println(clusters);

		}

		

		
		}
	
	private int findFirst(int target){
		//System.out.println("finding");
		search(0, well.length - 1, target);
		int i = position;
		if(position < 0) return-1;
		while(well[i].ones==target) {i--; if(i<0) break;}
		return i+1;

	}
	
	private int findLast(int target){
/*		search(0, well.length - 1, target);
		int i = position;
		if(position < 0) return-1;
		if(position >= well.length) return-1;
		while(well[i].ones==target) i++;*/
		return 200000;

	}
	
	private void search(int start, int end, int target){
		if(start >= end) {position = -1; return;}
		
		int mid = start + (end - start) / 2;
		if (well[mid].ones > target) search(start, mid - 1, target);
		else if (well[mid].ones < target) search (mid + 1, end, target);
		else position =  mid;
		
	}
	
	
	public void stuff(){
		int clusters = 200000;
		for(int i = 0; i < well.length; i++){
			for(int j = 2; j < well.length; j++){
				Quick.select(well, j, well[i].BY_DIFFERENCE);
				int k = Quick.position;
				if( well[k].diff < 3 && !well[k].stigmatized) { clusters--; well[k].stigmatized = true; }
				else break;
				
			}
			System.out.println(i);
		}
		
	}
	

	public void print(){
		for(int i = 0; i < well.length; i++)
			System.out.print(well[i].ones + ", ");


	}
	
	public static void main(String[] args){
		Hamilton ham = new Hamilton("clustering_big.txt");
//		System.out.println(well[0].string);
//		Quick.select(well, 2, well[0].BY_DIFFERENCE);
//		System.out.println(well[Quick.position].string);
//		System.out.println(well[Quick.position].diff);
		ham.stuff();
		
		/*Quick.select(well, 4, well[2].BY_DIFFERENCE);
		System.out.println(Quick.position());
		System.out.println(well[Quick.position].diff);
		for(int i =0; i< well.length; i++)
			System.out.println(well[i].string);*/
		//Arrays.sort(well);

	/*	ham.distanceIt();
		*/
		//ham.print();

		//System.out.println("101" ^ "010");

	}

}
