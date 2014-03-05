package alg;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class MinCUt {
	static Iterator iterator;
	static Iterator itr;
	static int count=0;
	static Graph pf;
	public static ArrayList<Integer> bests = new ArrayList<Integer>();
	public static void cut(Graph graph){
		pf=graph;
		
		int [] grandom = new int[graph.V()-1];
		for(int i = 0; i<grandom.length;i++){
			grandom[i]=i+1;
		}
		
	
		Timer.shuffle(grandom);
		//int[] grandom={3,5,6,1,4,2,8,7};
		//System.out.println(Arrays.toString(grandom));

		
		for(int i = 0; i<grandom.length-2;i++){
			//Timer.shuffle(grandom,i,grandom.length-1);
			//System.out.println(Arrays.toString(grandom));
			randomize(pf.bag(grandom[i]));
			iterator = pf.adj(grandom[i]).iterator();
			int x = (int) iterator.next();
			
			while(iterator.hasNext()){
				int w =(int)iterator.next();
				if(w!=x)pf.addEdge(x,w );
				}
			
			for(int j =1;j<pf.V();j++){
				itr = pf.adj(j).iterator();
				
				while(itr.hasNext()) {
					 int y =(int)itr.next();
					if(y==grandom[i]) {
						itr.remove();
						if(j!=x)pf.addEdge(j, x);
						itr = pf.adj(j).iterator();
					}
					if(j==y) itr.remove();
				}
			}
		}
	
		if((pf.bag(grandom[grandom.length-1]).getItems())<=17) System.out.println(pf.bag(grandom[grandom.length-1]).getItems());

		
	}
/*private static void remove(int bag,int todelete){
	itr = pf.adj(bag).iterator();
	while(itr.hasNext()){
		int x = (int) itr.next();
		if(x==todelete) itr.remove();
	}
}*/

	public static void getMin(){
		 int min = 0;
		 for(int x:bests){
			  min = 150;
			 if(bests.get(x)<min) min = bests.get(x);
		 }
		 System.out.println(min);
	}
	
	private static void randomize(Bag<Integer> baggy){
		Iterator<Integer> itr = baggy.iterator();
		
		int n = (int) (Math.random()*baggy.getItems()+1);
		//System.out.println("Random to change:"+n);
		
		
		while(itr.hasNext()){
			int y=itr.next();
			//System.out.print(y+", ");
			if(baggy.getPosition()==n){
			itr.remove();
			baggy.add(y);
			}
		}
	}
}
