import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] a;
	private int size;

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		this.a = (Item[]) new Object[1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();

		if (size == a.length)
			resize(2 * a.length);
		a[size++] = item;
	}

	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();

		int i = StdRandom.uniform(size);

		Item temp = a[i];
		a[i] = a[size - 1];
		a[size - 1] = null;

		if (size > 0 && size == a.length / 4)
			resize(a.length / 2);

		size--;
		return temp;

	}

	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException();

		return a[StdRandom.uniform(size)];
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Item[] b = (Item[]) new Object[capacity];

		for (int i = 0; i < size; i++)
			b[i] = a[i];

		a = b;
	}

	public Iterator<Item> iterator() {
		resize(size);
		StdRandom.shuffle(a);
		Item[] b = a;
		return new ListIterator(b);

	}

	private class ListIterator implements Iterator<Item> {
		int i = size;
		Item[] b;

		public ListIterator(Item[] b2) {
			this.b = b2;
		}

		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return b[--i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
