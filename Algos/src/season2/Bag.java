package season2;

import java.util.Iterator;

public class Bag <Item> implements Iterable<Item> {
	private Node first;
	private int size;
	
	private class Node {
		Node next;
		Item item;
	}
	
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item=item;
		first.next = oldFirst;
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean contains(Item item) {
		Iterator<Item> iterator =  this.iterator();
		while(iterator.hasNext())
			if(iterator.next()==item)
				return true;
		return false;
	}
	
	public Iterator<Item> iterator() {
		
		return new ListIterator() ;
	}
	
	private class ListIterator implements Iterator {

		 Node current=first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Object next() {
			Item returnee = current.item;
			current = current.next;
			return returnee;
		}


		public void remove() {
		
			
		}
		
	}

	
}
