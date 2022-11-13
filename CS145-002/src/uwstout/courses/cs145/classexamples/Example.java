package uwstout.courses.cs145.classexamples;

public class Example {

	
	public int min(int x, int y) {
		if (x < y) {
			return x;
		}
		
		return y;
	}
	

	public int min(int a, int b, int c, int d) {
		//int ab = min(a, b);
		//int cd = min(c, d);
		//return min(ab, cd);
		return Math.min(Math.min(a, b), Math.min(c, d));
	}
	

	public long factorial(long a) {
		if (a < 0) {
			return 0;
		}
		if (a == 0) {
			return 1;
		}
		
		long r = a;
		for (long i = a - 1; i > 0; i--) {
			r *= i;
		}
		
		return r;
	}
	
	
	public long combinations(long k, long n) {
		if (k < 0 || n < 0 || k > n) {
			return 0;
		}
		
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Example e = new Example();
		
		e.min(1, 2, 3, 4);
		
	}
	
	
}
