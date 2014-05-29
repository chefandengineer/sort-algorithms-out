package firm.evernote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * A Word Counter that returns the top most frequent terms running O(n)<br>
 * where n is the number of the characters.
 * 
 * Major Steps : 
 * 
 * 1. Split string by punctuation and spaces. 
 * 
 * 2. Store each word and the frequency in a hash map. <br>
 * 	  The time complexity for this operation is O(n) where n is the number of words. 
 * 
 * 3. Quick Select the top K words by it's frequency. 
 * 	  The best case for quick select is O(n) and worst case is O(n^2) and the average<br>
 *    time complexity is O(n) where n is the number of words.
 * 
 * 4. Sort the selected top k words by it's frequency. 
 *    This step sort the top k words while part of the k words is already sorted after the last<br>
 *    quick select step. This sorting takes O(K * logK) steps where K is the number of the words<br>
 *    been returned. As K is 
 *
 * 
 * Assumtions: <br>
 * 
 * 1. The string input wouldn't be extremely large to hold in memory. Therefore <br>
 * splitting the string in memory would not cause out of memory issue.<br>
 *  
 * 2. The order for terms that are equal frequent is not important. Therefore <br>
 * when 10 terms have equal frequency while the K is 3. Those 3 terms returned are randomly <br>
 * ordered out of 10 equal frequent terms.
 * 
 * 3. No stemming is needed for frequency.<br> 
 * 
 * 
 * Time Complexity: 
 * 
 * 
 * 
 * 
 * @author Tao Jiang
 *
 */
public class WordCounter {
	
	private Comparator<Entry<String,Integer>> comparator;
	
	/**
	 * Constructs the counter with an anonymous comparator class.
	 * compares the terms in terms of frequency.
	 */
	public WordCounter(){
		comparator = new Comparator<Entry<String,Integer>>(){
			public int compare(Entry<String, Integer> entry1,
					Entry<String, Integer> entry2) {
				int count1 = (Integer) entry1.getValue();
				int count2 = (Integer) entry2.getValue();
				return count1 > count2 ? -1 : 1;
			}
		};
	}
	
	/**
	 * Constructor with a customized comparator. 
	 * @param _comparator customized comparator, weighted term frequency etc.
	 */
	public WordCounter(Comparator<Entry<String,Integer>> _comparator){
		comparator = _comparator;
	}
	
	/**
	 * Get the top k terms sorted by their frequencies.
	 * @param text string representation of the text
	 * @param k number of items to be returned
	 * @return List of top k terms
	 */
	public List<String> getTopTerms(String text, int k) {
		
		String[] words = text.split("[\\p{Punct}\\s]+");
		List<String> topTerms = new ArrayList<String>();
		Map<String, Integer> wordcount = new HashMap<String, Integer>();
		
		//Get word count for all terms
		for (String word : words) {
			word = word.toLowerCase();
			if (wordcount.containsKey(word)) {
				int count = wordcount.get(word);
				wordcount.put(word, ++count);
			} else {
				wordcount.put(word, 1);
			}
		}

		List<Entry<String, Integer>> terms = new ArrayList<Entry<String, Integer>>(
				wordcount.entrySet());
		
		List<Entry<String,Integer>> topKTerms = selectTopK(terms,0,terms.size() - 1,k);
		Collections.sort(topKTerms,comparator);
		
		for (int i = 0; i < k; ++i) {
			Entry<String, Integer> entry = terms.get(i);
			topTerms.add(entry.getKey());
		}
		return topTerms;
	}


	/**
	 * Selects the top k terms from the whole term population.
	 * @param terms full terms entry list
	 * @param start start index
	 * @param end end index
	 * @param k number of terms to select
	 * @return List containing the k most frequent terms at the beginning
	 */
	private  List<Entry<String,Integer>> selectTopK(List<Entry<String,Integer>> terms, int start, int end, int k) {
		int pivotIndex = (end + start) / 2;
		int partitionIndex = partition(terms, start, end, pivotIndex);

		if (partitionIndex == k - 1) {
			return terms.subList(0, k);
		} else if (partitionIndex > k - 1) {
			return selectTopK(terms, start , partitionIndex - 1, k);
		} else {
			return selectTopK(terms, partitionIndex + 1, end, k);
		}
	}

	/**
	 * Partitioning method for the quick select method.
	 * @param terms	list of terms entry 
	 * @param left left index 
	 * @param right right index 
	 * @param pivotIndex pivot index
	 * @return the partitioning index
	 */
	private int partition(List<Entry<String,Integer>> terms, int left, int right, int pivotIndex) {
		Entry<String,Integer> pivotEntry = terms.get(pivotIndex);
		Entry<String,Integer> temp = terms.get(right);
		int storeIndex = left;
		terms.set(right, pivotEntry);
		terms.set(pivotIndex, temp);
		for (int i = left; i < right; ++i) {
			Entry<String,Integer> currentEntry = terms.get(i);
			//if (currentEntry.getValue() >= pivotEntry.getValue()) {
			if (comparator.compare(pivotEntry,currentEntry) > 0){
				temp = currentEntry;
				terms.set(i,terms.get(storeIndex));
				terms.set(storeIndex, temp);
				storeIndex++;
			}
		}
		temp = terms.get(right);
		terms.set(right, terms.get(storeIndex));
		terms.set(storeIndex, temp);
		return storeIndex;
	}

	public static void main(String[] args) {
		String str = "string string string, hello HELLO HELLO String workd, one 1 2 trhree string workd workd workd";
		WordCounter counter = new WordCounter();
		List<String> ls = counter.getTopTerms(str, 3);
		System.out.println(ls);
	}
}