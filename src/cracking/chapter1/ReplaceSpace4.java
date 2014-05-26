package cracking.chapter1;

public class ReplaceSpace4 {
	public static void replaceSpace(char[] arr,int length){
		int count = 0;
		for(int i = 0; i < length ; ++i){
			if(arr[i] == ' '){
				count++;
			}
		}
		int end = length + 2 * count - 1;
		int index = length - 1;
		
		while(index >= 0) {
			if (arr[index] == ' '){
				arr[end] = '0';
				arr[end-1] = '2';
				arr[end-2] = '%';
				end -= 3;
			} else {
				arr[end] = arr[index];
				end--;
			}
			index--;
		}
	}
	public static void main(String[] args){
		char[] arr = new char[100];
		String str = "a b c d e f";
		int i = 0;
		for(char c : str.toCharArray()){
			arr[i++] = c;
		}
		replaceSpace(arr,11);
		System.out.println(arr);
	}
}
