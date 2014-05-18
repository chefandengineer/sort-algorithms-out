package cracking.chapter9;

public class MagicIndex {
	public static boolean magicIndexExist(int[] arr, int start, int end){
		if(end < start){
			return false;
		}
		int midIndex = (start + end) / 2;
		int midValue = arr[midIndex];
		
		if (midIndex == midValue){
			return true;
		}
		if (midIndex > midValue){
			return magicIndexExist(arr,midIndex + 1, end);
		} else {
			return magicIndexExist(arr,start, midIndex - 1);
		}
	}
	
	public static boolean magicIndexExistDuplicate(int[] arr, int start, int end){
		if(end < start || start < 0 || end >= arr.length){
			return false;
		}
		int midIndex = (start + end) / 2;
		int midValue = arr[midIndex];	
		if (midIndex == midValue){
			return true;
		}
		boolean left = false;
		boolean right = false;
		int newStart = Math.min(midIndex - 1, midValue);
		left = magicIndexExistDuplicate(arr,start, newStart);	
		if(left) return left;
		newStart = Math.max(midIndex + 1, midValue);
		right =  magicIndexExistDuplicate(arr,newStart,end);
		return right || left;
	}
	
	public static void main(String[] args){
		int[] arr = {2,2,2,33,44,55,55};
		System.out.println(magicIndexExistDuplicate(arr,0,arr.length - 1));
	}
}
