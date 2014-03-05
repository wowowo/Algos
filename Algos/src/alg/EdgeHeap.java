package alg;

public class EdgeHeap {

	private Edge[] heap;
	private int size = 1;

	public EdgeHeap(int i) {
		heap = new Edge[i];
	}

	public void insert(Edge item) {
		heap[size] = item;
		if (size / 2 < 1) {
			size++;
			return;
		}
		int check = (int) Math.floor(size / 2);
		int position = size;
		while (bigger(heap[check], heap[position])) {
			// System.out.println("In loop");
			swap(heap, check, position);
			position = check;
			check = (int) Math.floor(check / 2);
			if (check < 1)
				break;
		}
		size++;

	}

	public Edge getMin() {
		Edge a = heap[1];
		heap[1] = heap[size - 1];
		size--;
		if (size == 1)
			return a;

		bubble(heap);
		return a;

	}

	public void delete(int i) {
		heap[i] = heap[size - 1];
		size--;

		int rooty = i;
		if (rooty * 2 + 1 > size)
			return;
		int child = less(heap, rooty);
		while (bigger(heap[rooty], heap[child])) {
			swap(heap, rooty, child);
			rooty = child;
			if (rooty * 2 >= size)
				break;
			child = less(heap, rooty);
		}

	}

	private void bubble(Edge[] array) {
		int rooty = 1;
		// System.out.println("Size befor bubble:"+size);
		int child = less(heap, rooty);

		while (bigger(heap[rooty], heap[child])) {
			swap(heap, rooty, child);
			rooty = child;
			if (rooty * 2 >= size)
				break;
			child = less(heap, rooty);

		}

	}

	private int less(Edge[] heap2, int i) {
		if (size == i * 2)
			return i * 2;
		if (heap[i * 2].getWeight() < heap[(i * 2) + 1].getWeight())
			return i * 2;
		return (i * 2) + 1;
	}

	private void swap(Edge[] a, int i, int j) {
		Edge temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	private boolean bigger(Edge one, Edge two) {
		return one.compareTo(two) > 0;

	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 1;
	}
}
