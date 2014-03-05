package alg;

public class Stack<Item> {
	Node first;
	public int size;
	
	private class Node {
		Node next;
		Item item;
	}
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}
	
	public Item pop(){
		
		Item theFirst = first.item;
		first = first.next;
		size--;
		return theFirst;
		
	}
	
	
}
