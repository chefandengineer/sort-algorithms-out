package cracking.chapter17;

public class ContinuousLargestSum {
	public static int findLargestSum(int[] arrs){
		int max = 0;
		int currentMax = 0;
		for(int i = 0; i < arrs.length; ++i){
			currentMax += arrs[i];
			if ( currentMax < 0 ){
				currentMax = 0;
			}
			if (currentMax > max){
				max = currentMax;
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] arrs = {1,2,3,-1,5,6,-11,1,7,9};
		System.out.println(findLargestSum(arrs));
	}
}
