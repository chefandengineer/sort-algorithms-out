package cracking.chapter18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Question 18.5
 * You have a large text file containing words. Given any two words, find the shortest distance 
 * (in terms of number of words) between them in the file. If the operation will be repeated 
 * many times for the same file (but different pairs of words), can you optimize your solution?
 * @author apple
 *
 */
public class FindShortestPathInFile {
	/**
	 * Without Repeating requirement
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int findShortestDistance(String[] words, String word1,String word2){
		int min = Integer.MAX_VALUE;
		int lastWord1Position = -1;
		int lastWord2Position = -1;
		for(int i = 0; i < words.length; ++i){
			if(words[i].equals(word1)){
				if (lastWord2Position != -1) {
					if((i - lastWord2Position) < min){
						min = i -lastWord2Position;
					}
				}
				lastWord1Position = i;
			}
			if(words[i].equals(word2)){
				if (lastWord1Position != -1) {
					if((i - lastWord1Position) < min){
						min = i - lastWord1Position;
					}
				}
				lastWord2Position = i;
			}
		}
		return min;
	}
	
	public static int findShortestDistanceRepeat(String[] words, String word1,String word2){
		Map<String,ArrayList<Integer>> map = getInvertList(words);
		ArrayList<Integer> list1 = map.get(word1);
		ArrayList<Integer> list2 = map.get(word2);
		int lastPosition1 = -1;
		int lastPosition2 = -1;
		int index1 = 0;
		int index2 = 0;
		int min = Integer.MAX_VALUE;
		boolean done1 = false;
		boolean done2 = false;
		while (!done1 || !done2) {
			int position1 = done1? Integer.MAX_VALUE : list1.get(index1);
			int position2 = done2? Integer.MAX_VALUE : list2.get(index2);

			if(position1 < position2 && !done1){
				if (lastPosition2 >= 0){
					if ((position1 - lastPosition2) < min){
						min = position1 - lastPosition2;
					} 
				}
				lastPosition1 = position1;
				if (index1 < list1.size() - 1) {
					index1++;
				} else {
					done1 = true;
				}
			}
			if(position1 >= position2 && !done2){
				if (lastPosition1 >= 0){
					if ((position2 - lastPosition1) < min){
						min = position2 - lastPosition1;
					} 
				}
				lastPosition2 = position2;
				if (index2 < list2.size() - 1){
					index2++;
				} else {
					done2 = true;
				}
			}
		}
		return min;
	}
	
	public static Map<String, ArrayList<Integer>> getInvertList(String[] words){
		Map<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
		for(int i = 0; i < words.length; ++i){
			String word = words[i];
			ArrayList<Integer> list;
			if(map.containsKey(word)) {
				list = map.get(word);
			}else{
				list = new ArrayList<Integer>();
				map.put(word, list);
			}
			list.add(i);
		}
		return map;
	}
	
	public static void main(String[] args){
		String[] arr = {"foo","bar","bar","bar","tao","tao","bar"};
		int min = findShortestDistance(arr,"foo","tao");
		System.out.println(min);
		int min1 = findShortestDistanceRepeat(arr,"foo","tao");
		System.out.println(min1);
	}
}
