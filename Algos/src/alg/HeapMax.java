package alg;

import java.util.Arrays;

public class HeapMax {
	private int[] heap;
	private int size = 1;

	public HeapMax(int i) {
		heap = new int[i];
	}

	public void insert(int item) {
		heap[size] = item;
		if (size / 2 < 1) {
			size++;
			return;
		}
		int check = (int) Math.floor(size / 2);
		int position = size;
		while (heap[check] < heap[position]) {
			swap(heap, check, position);
			position = check;
			check = (int) Math.floor(check / 2);
			if (check == 0)
				break;
		}
		size++;

	}

	public int getMax() {
		int a = heap[1];
		heap[1] = heap[size - 1];
		size--;

		bubble(heap);
		return a;

	}

	public void delete(int i) {
		if (i == 0)
			return;
		heap[i] = heap[size - 1];
		size--;

		int rooty = i;
		if (rooty * 2 + 1 > size)
			return;
		int child = less(heap, rooty);
		while (heap[rooty] > heap[child]) {
			swap(heap, rooty, child);
			rooty = child;
			if (rooty * 2 >= size)
				break;
			child = less(heap, rooty);
		}

	}

	private void bubble(int[] array) {
		int rooty = 1;
		int child = less(heap, rooty);
		while (heap[rooty] < heap[child]) {
			swap(heap, rooty, child);
			rooty = child;
			if (rooty * 2 >= size)
				break;
			child = less(heap, rooty);

		}

	}

	private int less(int[] heap2, int i) {
		if (size == i * 2)
			return i * 2;
		if (heap[i * 2] > heap[(i * 2) + 1])
			return i * 2;
		return (i * 2) + 1;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public void print() {
		System.out.println(Arrays.toString(heap));
	}

	public int getSize() {
		return size;

	}

	public boolean isEmpty() {
		return size == 1;
	}

	public int max() {
		return heap[1];
	}
}
