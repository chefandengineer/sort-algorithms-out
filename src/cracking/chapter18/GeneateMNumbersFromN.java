package cracking.chapter18;

public class GeneateMNumbersFromN {
	public static void generateSubset(int[] n,int m){
		for(int i = 0; i <= m; i++){
			int k = ShuffleADeckOfCards.rand(i,n.length);
			int tmp = n[i];
			n[i] = n[k];
			n[k] = tmp;
		}
	}
}
