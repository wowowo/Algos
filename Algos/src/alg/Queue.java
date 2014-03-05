package alg;


public class Queue<Item> {
	private Node first;
	private Node last;
	private int N=0;
	
	private class Node {
		Node next;
		Item item;
	}

	public void enque(Item item){
		Node oldlast = last;
		last = new Node();
		last.item=item;
		last.next = null;
		if(isEmpty()) first=last;
		else oldlast.next=last;
		N++;
	}

	public Item dequeue(){
		Item item =first.item;
		first=first.next;
		if(isEmpty())last=null;
		N--;
		return item;
	}
	
	public int size(){
		return N;
	}

	public boolean isEmpty() {
		
		return first==null;
	}

}
