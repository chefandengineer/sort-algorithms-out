package cracking.chapter1;

public class CheckStringIsPermutationOfOther3 {
	public static boolean check(String str1,String str2){
		if(str1.length() != str2.length()) {
			return false;
		}
		int[] count = new int[256];
		for(int i = 0; i < str1.length();i++){
			char c = str1.charAt(i);
			count[c]++;
		}
		for(int j = 0; j < str2.length();j++){
			char c = str2.charAt(j);
			if(--count[c] < 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		String str1 = "abcdedfg";
		String str2 = "gfdedcba";
		String str3 = "gggedcba";
		
		System.out.println(check(str1,str2));
		System.out.println(check(str2,str3));
		System.out.println(check(str3,str1));
				
	}
}
