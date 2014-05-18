package cracking.chapter9;

import java.util.ArrayList;
import java.util.List;
/**
 * Time Complexity : O(n!)
 * @author apple
 *
 */
public class AllPermutationsOfString {
	public static List<String> getPermutations(List<String> subPerms, String str){
		List<String> newPerms = new ArrayList<String>();
		if(subPerms.size() == 0){
			newPerms.add(str);
			return newPerms;
		}
		for(String perm : subPerms){
			for(int i = 0; i <= perm.length();++i){
				String newPerm = concate(perm,str,i);
				newPerms.add(newPerm);
			}
		}
		return newPerms;
	}
	public static String concate(String str1, String str2, int index){
		String preStr = str1.substring(0,index);
		String postStr = str1.substring(index);
		return preStr + str2 + postStr;
	}
	
	public static List<String> allPermutations(String str){
		List<String> allPerms = new ArrayList<String>();
		for(int i = 0; i < str.length() ; ++i){
			String currentStr = String.valueOf(str.charAt(i));
			allPerms = getPermutations(allPerms,currentStr);
		}
		return allPerms;
	}
	
	public static void main(String[] args){
		String str = "abcde";
		List<String> allPerms = allPermutations(str);
		System.out.println(allPerms);
		System.out.println(allPerms.size());
	}
}
