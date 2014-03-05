package alg;

public class RBST<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	private class Node {
		Node left, right;
		Key key;
		Value val;
		boolean color;

		public Node(Key key, Value val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;
		}
	}

	public Value get(Key key) {
		Node x = root;
		// if(current==null) return 0;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.val;
		}
		return null;

	}

	private boolean isRed(Node node) {
		if (node == null)
			return BLACK;
		return node.color == RED;
	}

	private Node rotateLeft(Node h) {
		Node x = h.left;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;

	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;

	}

	private Node put(Node h, Key key, Value val) {
		if (h == null)
			return new Node(key, val, RED);
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		if (cmp > 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;

		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		return h;
	}

	public void insert(Key key, Value val) {
		root = put(root, key, val);
	}

}
