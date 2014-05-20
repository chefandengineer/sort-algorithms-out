package cracking.chapter11;

public class MergeTwoArraysInSortedOrder {
	//public static void
	public static void mergeTwoArrays(int[] arrA,int[] arrB){
		int lengthB = arrB.length - 1;
		int lengthA = 0;
		int i = 0;
		while(arrA[i] != 0) i++;
		lengthA = i - 1;
		System.out.println(lengthA);
		int mergedIndex = lengthA + lengthB + 1;
		while(lengthA >= 0 && lengthB >= 0){
			if (arrA[lengthA] > arrB[lengthB]){
				arrA[mergedIndex] = arrA[lengthA];
				lengthA--;
			} else {
				arrA[mergedIndex] = arrB[lengthB];
				lengthB--;
			}
			mergedIndex--;
		}
		
		while(lengthB >=0 ){
			arrA[mergedIndex] = arrB[lengthB];
			mergedIndex--;
			lengthB--;
		}
	}
	
	public static void main(String[] args){
		int[] arrA = new int[20];
		arrA[0] = 2;
		arrA[1] = 3;
		arrA[2] = 4;
		arrA[3] = 5;
		arrA[4] = 8;
		
		int[] arrB = {1,3,4,9,10};
		mergeTwoArrays(arrA,arrB);
		for(int i=0; i < arrA.length; i++){
			System.out.println(arrA[i]);
		}
	}
}
