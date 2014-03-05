package alg;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class tetS {
	
public static void main(String [] args) throws FileNotFoundException {
	
	for(int i=0;i<20000;i++){
	try {
		buildGraph();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		/*Graph graph = new Graph(9);
	JFileChooser fileChooser = new JFileChooser();
	 if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){ 
	 java.io.File file =fileChooser.getSelectedFile() ;

	 Scanner input = new Scanner(file);
     int k = 0;
	 while (input.hasNext()) {
	String line=input.nextLine();
	String[] nums = line.split("\\s+");
	//System.out.println(Arrays.toString(nums));
	 for(int i = 1;i<nums.length;i++){
		 graph.addEdge(Integer.parseInt(nums[k]),Integer.parseInt(nums[i]));
	 }
	 }

	 input.close();
	 }
	 
	 for(int i=1;i<graph.V();i++){
		 System.out.print("adjnumber:"+i+" = ");
		 for(int x:graph.adj(i)) System.out.print(x+",");
		 System.out.println("");

	 }
	 
	
	 MinCUt.cut(graph);
	





	 
	for(int i=1;i<graph.V();i++){
		 System.out.print("adjnumber:"+i+" = ");
		 for(int x:graph.adj(i)) System.out.print(x+",");
		 System.out.println("");

	 }*/
	
	
	
	//MinCUt.getMin();




}

private static void buildGraph() throws FileNotFoundException{
	Graph graph = new Graph(201);
	
	 String asd = "QuickSort.txt";
	 java.io.File file = new File(asd) ;

	 Scanner input = new Scanner(file);
     int k = 0;
	 while (input.hasNext()) {
	String line=input.nextLine();
	String[] nums = line.split("\\s+");
	//System.out.println(Arrays.toString(nums));
	 for(int i = 1;i<nums.length;i++){
		 graph.addEdge(Integer.parseInt(nums[k]),Integer.parseInt(nums[i]));
	 }
	 }

	 input.close();
	 
	 
	 
	 MinCUt.cut(graph);


	 
	/*	for(int i=1;i<graph.V();i++){
			 System.out.print("adjnumber:"+i+" = ");
			 for(int x:graph.adj(i)) System.out.print(x+",");
			 System.out.println("");

		 }*/
	 
	 
		int number = 0;

		//System.out.println("NUmberssddsa:"+graph.bag(8).getItems());

	 
	
	
	
}


}