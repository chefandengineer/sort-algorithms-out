package cracking.chapter11;

import java.util.Arrays;

public class ChapterCommon {
	/**
	 * 
	 * 
	 * Insertion Sort
	 */
	public static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i ++){
			for (int j = i; j > 0 ; j--){
				if(arr[j] > arr[j - 1]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	/**
	 * Bubble Sort
	 * @param arr
	 */
	public static void bubbleSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = i; j < arr.length - i; j++){
				 if(arr[j] > arr[j + 1]){
					 int temp = arr[j + 1];
					 arr[j + 1] = arr[j];
					 arr[j] = temp;
				 }
			}
		}
	}
	
	/**
	 * o(n^2)
	 * Selection Sort
	 */
	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int iMin = i;
			for(int j = i ;j < arr.length; j++){
				if (arr[j] < arr[j + 1]){
					iMin = j;
				}
			}
			if (iMin != i) {
				int temp = arr[i];
				arr[i] = arr[iMin];
				arr[iMin] = temp;
			}
		}
	}
	
	/**
	 * Merge Sort
	 */
	
	public static int[] mergeSort(int[] arr){
		if(arr.length <= 1){
			return arr;
		}

		int[] left = getLeft(arr);
		int[] right = getRight(arr);
		
		return merge(mergeSort(left),mergeSort(right));
	}
	public static int[] getLeft(int[] arr){
		int[] left = new int[arr.length/2];
		for(int i = 0; i < left.length;i++){
			left[i] = arr[i];
		}
		return left;
	}
	public static int[] getRight(int[] arr){
		int[] right = new int[arr.length - arr.length/2];
		for(int i = arr.length / 2; i < arr.length; i++){
			right[i-arr.length/2] = arr[i];
		}
		return right;
	}

	
	public static int[] merge(int[] left, int[] right){
		int i = 0;
		int j = 0;
		int index = 0;
		int[] target = new int[left.length + right.length];
		while(i < left.length && j < right.length){
			if(left[i] < right[j]){
				target[index] = left[i];
				i++;
			}else {
				target[index] = right[j];
				j++;
			}
			index++;
		}
		while(i < left.length){
			target[index] = left[i];
			index++;
			i++;
		}	
		while(j < right.length){
			target[index] = right[j];
			index ++;
			j++;
		}	
		return target;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,7,8,0,3,434,32,34,12};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
