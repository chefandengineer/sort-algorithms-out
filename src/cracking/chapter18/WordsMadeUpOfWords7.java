package cracking.chapter18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordsMadeUpOfWords7 {
	public static void LongestWords(String[] words){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		for(String word : words){
			map.put(word, true);
		}
		Arrays.sort(words,new LengthComparator());
		for(String word : words){
			if(canBuildByString(map,word,true)){
				System.out.println(word);
				break;
			}
		}
	}
	
	public static boolean canBuildByString(Map<String,Boolean> map, String word,boolean isOriginal){
		if(map.containsKey(word) && !isOriginal){
			return map.get(word);
		}
		for(int i=1; i < word.length();++i){
			String left = word.substring(0,i);
			String right = word.substring(i);
			if (map.containsKey(left) && map.containsKey(left) && canBuildByString(map,right,false)){
				map.put(word, true);
				return true;
			}
		}
		map.put(word, false);
		return false;
	}
	public static void main(String[] args){
		String[] arr = {"word","wordword","foo","bar","foofo9ofoobar","foofo9ofoobarword"};
		LongestWords(arr);
	}
}

class LengthComparator implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		return arg0.length() < arg1.length() ? 1 : -1;
	}
	
}
