import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int size;

	public Deque() {

	}

	private class Node {

		Item item;
		Node next;
		Node previous;

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();

		Node oldFirst = first;
		first = new Node();
		first.item = item;

		if (isEmpty())
			last = first;
		else {
			first.next = oldFirst;
			oldFirst.previous = first;
		}

		size++;
	}

	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();

		Node previousLast = last;
		last = new Node();
		last.item = item;
		// last.next = null;

		if (isEmpty())
			first = last;

		else {
			last.previous = previousLast;
			previousLast.next = last;
		}

		size++;

	}

	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");

		Item item = first.item;
		first = first.next;
		size--;

		if (!isEmpty())
			first.previous = null;
		else {
			first = null;
			last = null;
		}

		return item;

	}

	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");

		Item item = last.item;
		last = last.previous;
		size--;

		if (!isEmpty())
			last.next = null;
		else {
			first = null;
			last = null;
		}

		return item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("stuuf");
		}
	}

}
