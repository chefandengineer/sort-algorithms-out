package cracking.chapter18;

public class FindSmallestOneMillionNumber {
	
	public static void quickSort(int[] array, int start, int end){
		if (start < end){
			int pivotIndex = (end + start) / 2;
			int partitionIndex = partition(array,start,end,pivotIndex);
			quickSort(array,start,partitionIndex - 1);
			quickSort(array,partitionIndex + 1,end);
		}
	}
	
	public static int findNthElement(int[] array, int start, int end, int i){
			int pivotIndex = (end + start) / 2;
			int partitionIndex = partition(array,start,end,pivotIndex);
			
			if (partitionIndex == i - 1) {
				return array[partitionIndex];
			} else if (partitionIndex > i - 1){
				return findNthElement(array,start,partitionIndex - 1,i);
			} else {
				return findNthElement(array,partitionIndex + 1, end,i);
			}
	}
	
	public static int partition(int[] array, int left, int right, int pivotIndex){
		int pivotValue = array[pivotIndex];
		int temp = array[right];
		int storeIndex = left;
		array[right] = pivotValue;
		array[pivotIndex] = temp;
		for(int i = left; i < right; ++i){
			if(array[i] < pivotValue){
				temp = array[i];
				array[i] = array[storeIndex];
				array[storeIndex] = temp;
				storeIndex++;
			}	
		}
		temp = array[right];
		array[right] = array[storeIndex];
		array[storeIndex] = temp;
		return storeIndex;
	}
	
	
	public static void main(String[] args){
		int[] arr = {1,3,2,4,6,8,9,7,5};
		quickSort(arr,0,arr.length - 1);
//		for(Integer a : arr){
//			System.out.print(a + ",");
//		}
		System.out.println(findNthElement(arr,0,arr.length-1,1));
	}
}