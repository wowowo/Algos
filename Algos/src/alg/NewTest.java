package alg;

import java.io.FileNotFoundException;

public class NewTest {
public static void main(String[] args) throws FileNotFoundException{

	BloomFilter bloom = new BloomFilter(30000);


	
	
	
	
/*WeightedEdgeGraph graph = WeightedEdgeGraph.buildGraph(201);
//graph.print();
Timer.start();
Dijkstra.shortestPath(graph);
Timer.stop();
Dijkstra.print();*/
	
	
/*Queue<Edge> asd = Primm.tree();
int sum = 0;

while(!asd.isEmpty()){
	Edge k =asd.dequeue();
	System.out.print(k.getWeight() +", ");
	sum+=k.getWeight();
	
}
System.out.println();

System.out.println(sum);*/




	/*EdgeHeap heap = new EdgeHeap(40);
	int[] a = {6399,2597,2909,2437,8700,7896,2367,4612,6647,508,1724,7420,9146,2183,9047,7905,6461,1913,546,4122,647,2069,8021,648,2620,8164,982};
	for (int i=0;i<a.length;i++){
	Edge  e =  new Edge(0,0);
	e.setWeigth(a[i]);
	heap.insert(e);
	}
	

	System.out.println(heap.getMin().getWeight());
	System.out.println(heap.getMin().getWeight());
	System.out.println(heap.getMin().getWeight());
	System.out.println(heap.getMin().getWeight());
	System.out.println(heap.getMin().getWeight());*/


	


}
private static void testGraph(){
	Edge a = new Edge(1,2);
	Edge b = new Edge(2,3);
	Edge c = new Edge(1,3);
	Edge d = new Edge(2,4);
	Edge e = new Edge(3,4);
	a.setWeigth(1);
	b.setWeigth(2);
	c.setWeigth(4);
	d.setWeigth(6);
	e.setWeigth(3);
	
	WeightedEdgeGraph graph = new WeightedEdgeGraph(5);
	graph.addEdge(a);
	graph.addEdge(b);
	graph.addEdge(c);
	graph.addEdge(d);
	graph.addEdge(e);
	
	Dijkstra.shortestPath(graph);
	Dijkstra.print();
	

}






}
