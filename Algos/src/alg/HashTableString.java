package alg;

public class HashTableString {
	private int[] well = { 101, 211, 307, 401, 509 };
	private int length = 0;
	private String[] map;
	private int size;

	public HashTableString() {
		map = new String[101];

	}

	private boolean toDouble() {
		return size >= map.length / 2 + 1;
	}

	private boolean toHalve() {
		return size <= map.length / 2 + 1;

	}

	private void doubleSize() {

		String[] a = map;
		map = new String[well[++length]];
		for (int i = 0; i < a.length; i++) {
			map[i] = a[i];
		}
		a = null;
	}

	private void halveSize() {
		String[] a = map;
		map = new String[well[--length]];
		for (int i = 0; i < a.length; i++) {
			map[i] = a[i];
		}
		a = null;
	}

	private int hash(String a) {
		return (a.hashCode() & 0x7fffffff) % map.length;
	}

	public void insert(String a) {
		int hash = hash(a);
		for (int i = hash; map[i] != ""; i = (i + 1) % map.length) {
			map[hash] = a;
		}
		size++;
		if (toDouble())
			doubleSize();
		if (toHalve())
			halveSize();

	}

	public String get(String a) {
		int hash = hash(a);

		int i;
		for (i = hash; map[i] != a; i = (i + 1) % map.length)
			;
		return map[i];

	}

}
