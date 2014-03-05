package alg;

public class BST {
	private Node root;
	private Node size;
	private Node pointer;

	private class Node {
		// Node parent;
		Node leftChild;
		Node rightChild;
		int item;

		private Node(int item) {
			this.item = item;
		}
	}

	public void insert(int item) {

		root = put(root, item);

	}

	private Node put(Node root2, int item) {
		if (root2 == null)
			return new Node(item);
		if (root2.item < item)
			root2.rightChild = put(root2.rightChild, item);
		if (root2.item > item)
			root2.leftChild = put(root2.leftChild, item);
		return root2;
	}

	public int get(int item) {
		pointer = root;
		// if(current==null) return 0;
		while (pointer != null) {
			if (pointer.item == item)
				return pointer.item;
			else if (pointer.item < item)
				pointer = pointer.rightChild;
			else
				pointer = pointer.leftChild;
		}
		return 0;

	}

	public int max() {
		Node node = root;
		Node previous = root;
		while (node != null) {
			previous = node;
			node = node.rightChild;
		}
		return previous.item;
	}

	private Node mini(Node node1) {
		Node node = node1;
		Node previous = root;
		while (node != null) {
			previous = node;
			node = node.leftChild;
		}
		return previous;

	}

	public int min() {
		Node node = root;
		Node previous = root;
		while (node != null) {
			previous = node;
			node = node.leftChild;
		}
		return previous.item;

	}

	public void delete(int item) {
		root = delete(root, item);

	}

	private Node delete(Node x, int item) {
		if (x == null)
			return null;
		if (x.item > item)
			x.leftChild = delete(x.leftChild, item);
		else if (x.item < item)
			x.rightChild = delete(x.rightChild, item);
		else {
			if (x.rightChild == null)
				return x.leftChild;
			Node t = x;
			x = mini(t.rightChild);
			x.rightChild = deleteMin(t.rightChild);
			x.leftChild = t.leftChild;
		}

		return x;
	}

	private void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.leftChild == null)
			return x.rightChild;
		x.leftChild = deleteMin(x.leftChild);
		return x;

	}

}
