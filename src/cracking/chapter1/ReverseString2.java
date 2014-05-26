package cracking.chapter1;

public class ReverseString2 {
	public static char[] reverseString(char[] str){
		if (str != null && str.length <= 1){
			return str;
		}
		int middle = str.length / 2; 
		for(int i = 0; i < middle; i++){
			char temp = str[i];
			str[i] = str[str.length - 1 - i];
			str[str.length - 1 - i] = temp;
		}
		return str;
	}
	public static char[] reverseString2(char[] str){
		if (str != null && str.length <= 1){
			return str;
		}
		int end = str.length - 1;
		int start = 0;
		while(start < end){
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
		return str;
	}
	
	public static void main(String[] args){
		String strs = "ancdefd";
	//	char[] str = {'a','n','c','d'};
		System.out.println(reverseString2(strs.toCharArray()));
	}
}
