package cracking.chapter9;

public class PossibleWaysRunUpStair {
	public static int waysRunUp(int n){	
		if(n < 0){
			return 0;
		} else if(n == 0) {
			return 1;
		}
		return waysRunUp(n-1) + waysRunUp(n-2) + waysRunUp(n-3);
	}
	
	public static int waysRunUpDP(int n,int[] m){
		if(n < 0){
			return 0;
		} else if(n == 0) {
			return 1;
		}
		if(m[n] != 0){
			return m[n];
		}
		int ways = waysRunUpDP(n-1,m) + waysRunUpDP(n-2,m) + waysRunUpDP(n-3,m);
		m[n] = ways;
		return ways;
	}
	
	public static void main(String[] args){
		int n = 30;
		int[] m = new int[n+1];
		System.out.println(waysRunUpDP(n,m));
		System.out.println(waysRunUp(n));
	}
}
