package alg;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class MedianMaintanaasd {
	static Heap maxHeap = new Heap(7000);
	static HeapMax minHeap = new HeapMax(7000);
	static Collection<Integer> asd = new ArrayList<Integer>();

	public static void main(String[] args) throws FileNotFoundException {

		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			java.io.File file = fileChooser.getSelectedFile();
			int k = 1;
			Scanner input = new Scanner(file);
			Timer.start();
			while (input.hasNext()) {
				String line = input.nextLine();
				int a = Integer.parseInt(line);

				if (a > minHeap.max())
					maxHeap.insert(a);
				else
					minHeap.insert(a);

				if (k % 2 == 0)
					balance();

				// System.out.println(theChosenOne());
				asd.add(theChosenOne());
				k++;

			}

			input.close();
		}

		int t = 0;
		for (int x : asd)
			t += x;
		System.out.println("INPUTTT" + (t % 10000));
	}

	private static void balance() {
		if (minHeap.getSize() == maxHeap.getSize())
			return;
		if (minHeap.getSize() > maxHeap.getSize())
			maxHeap.insert(minHeap.getMax());
		else
			minHeap.insert(maxHeap.getMin());
	}

	private static int theChosenOne() {
		if (minHeap.getSize() >= maxHeap.getSize())
			return minHeap.max();
		return maxHeap.min();
	}

}
