package season2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import alg.Timer;

public class Schedule {
	


	
	public static void it(String file) throws FileNotFoundException{
		Scanner input = new Scanner(new File(file));
		Job[] jobs = new Job[Integer.parseInt(input.nextLine())];
		int k = 0;
		while(input.hasNext()){
			String line = input.nextLine();
			String lines[] = line.split("[ ]+");
			jobs[k]= new Job(Double.parseDouble(lines[0]),Double.parseDouble(lines[1]));
			k++;
		}
				
		Arrays.sort(jobs, Collections.reverseOrder());
		System.out.println(jobs[0].ratio+" = " + jobs[0].weight + " / " + jobs[0].length );
		System.out.println(jobs[1].ratio+" = " + jobs[1].weight + " / " + jobs[1].length );
		System.out.println(jobs[2].ratio+" = " + jobs[2].weight + " / " + jobs[2].length );
		System.out.println(jobs[3].ratio+" = " + jobs[3].weight + " / " + jobs[3].length );
		System.out.println(jobs[jobs.length-5].ratio+" = " + jobs[jobs.length-5].weight + " / " + jobs[jobs.length-5].length );



		long sum = (long) (jobs[0].weight*jobs[0].length);
		int trueLenght = (int) jobs[0].length; 
		for(int i = 1; i <jobs.length; i++){
			trueLenght += jobs[i].length;
			sum += jobs[i].weight * trueLenght;
			
		}
		System.out.print(sum);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Schedule.it("jobs.txt");
	}
	
}
