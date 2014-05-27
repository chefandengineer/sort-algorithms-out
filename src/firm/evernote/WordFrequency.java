package firm.evernote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordFrequency {
	public static List<String> getTopTerms(String s, int k) {
		// Seperate String
		String[] words = s.split("[\\p{Punct}\\s]+");
		List<String> topTerms = new ArrayList<String>();

		//O(N)
		Map<String, Integer> wordcount = new HashMap<String, Integer>();
		for (String word : words) {
			word.toLowerCase();
			if (wordcount.containsKey(word)) {
				int count = wordcount.get(word);
				wordcount.put(word,++count);
			} else {
				wordcount.put(word, 1);
			}
		}

		// n*logn
		List<Entry<String, Integer>> terms = new ArrayList<Entry<String, Integer>>(
				wordcount.entrySet());
		Collections.sort(terms, new TermComparator());

		// Get top k terms
		//O(N)
		for (int i = 0; i < k; ++i) {
			Entry<String, Integer> entry = terms.get(i);
			topTerms.add(entry.getKey());
		}
		return topTerms;
	}
	
	public static void main(String[] args){
		String str = "string, hello string workd, one 1 2 trhree";
		List<String> ls = getTopTerms(str, 3);
		System.out.println(ls);
	}
}

class TermComparator implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> entry1,
			Entry<String, Integer> entry2) {
		int count1 = (Integer) entry1.getValue();
		int count2 = (Integer) entry2.getValue();
		return count1 > count2 ? -1 : 1;
	}
}
