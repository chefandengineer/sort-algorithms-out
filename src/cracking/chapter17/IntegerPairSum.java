package cracking.chapter17;

import java.util.Arrays;
import java.util.HashSet;

public class IntegerPairSum {
	public static void findPairs(int[] arr, int sum){
		HashSet<Integer> map = new HashSet<Integer>();
		for(int i = 0; i < arr.length ; ++i){
			int num = arr[i];
			int complement = sum - num;
			if (map.contains(complement)){
				System.out.println(num + "," + complement);
			} else {
				map.add(num);
			}
		}
	}
	
	public static void findPairsSorted(int[] arr, int target){
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		while(arr[start] < arr[end]){
			int sum = arr[start] + arr[end];
			if (sum == target) {
				System.out.println(arr[start] + "," + arr[end]);
				--end;
			} else if (sum > target){
				--end;
			} else {
				++start;
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		findPairs(arr, 7);
		findPairsSorted(arr,7);
	}
}
