package cracking.chapter1;

public class CheckForUniqueCharacters1 {
	public static boolean containsUniqueChar(String str){
		if (str.length() > 256) {
			return false;
		}
		boolean[] visited = new boolean[256];
		for(int i = 0; i < str.length() ; ++i){
			char cur = str.charAt(i);
			if(visited[cur]){
				return false;
			} else {
				visited[cur] = true;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args){
		String str = "aaabbbccc";
		String str1 = "abcdefg";
		System.out.println(containsUniqueChar(str));
		System.out.println(containsUniqueChar(str1));
	}
}
