package sedg;

public class Puzzles {
	
	public static void main(String[] args) {
		cleverSwap();
}

	private static void elementary() {
		//Big-L
		System.out.println(12345 + 5432l);
}

	private static void joyOfHex() {
		// it is generally best to avoid mixed-type computations
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
	}

	private static void multiCast() {
		//it is impossible to represent a negative byte value as a char
		
		//Sign extension is performed if the type of the original 
		//value is signed; zero extension if it is a char, regardless 
		//of the type to which it is being converted.
		
		System.out.println((int) (char) (byte) -1);
	}

	private static void cleverSwap() {
        
		int x = 1984;  // (0x7c0)
        int y = 2001;  // (0x7d1)

        x ^= y ^= x ^= y;

        System.out.println("x = " + x + "; y = " + y);

	}

}
