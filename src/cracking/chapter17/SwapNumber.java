package cracking.chapter17;

public class SwapNumber {
	public static void swapNumbers(Integer a, Integer b){
	//	System.out.println("a " + a + " b " + b);
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("a " + a + " b " + b);
	}
	public static void swapNumberInBits(int a, int b){
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a " + a + " b " + b);
	}
	
	public static void main(String[] args){
		Integer a = 2;
		Integer b = 3;
		swapNumbers(a,b);
		swapNumberInBits(a,b);
		System.out.println("a " + a + " b " + b);
	}
}
