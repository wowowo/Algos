package alg;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	private int position;
	private Node first;
	private int items;

	private class Node {
		Node next;
		Item item;

	}

	public boolean contains(Item item) {
		
		Iterator iterator = this.iterator();
		
		while (iterator.hasNext())
			if (iterator.next() == item)
				return true;
		
		return false;
	}

	public void add(Item item) {
		
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		items++;

	}

	public Iterator<Item> iterator() {
		
		return new ListIterator();
		
	}

	private class ListIterator implements Iterator<Item> {
		
		private Node current = first;
		private Node previous = first;
		private Node deletor = first;

		public boolean hasNext() {
			return current != null;

		}

		public void remove() {

			if (deletor.next == previous.next)
				first = first.next;
			else
				deletor.next = previous.next;
			items--;

		}

		public Item next() {
			Item item = current.item;

			deletor = previous;
			previous = current;
			current = current.next;
			position++;
			return item;
		}

	}

	public Item first() {
		return first.item;
	}

	public int getItems() {
		return items;
	}

	public int getPosition() {
		return position;

	}

	public void resetPosition(int n) {
		position = 0;

	}
}