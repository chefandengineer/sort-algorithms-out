package cracking.chapter18;

public class ShuffleADeckOfCards {
	public static int rand(int lower,int higher){
		return lower + (int) (Math.random() * (higher- lower + 1));
	}
	public static void shuffle(Card[] cards){
		for(int i = 0; i < cards.length; ++i){
			int random = rand(0,i);
			Card temp = cards[random];
			cards[random] = cards[i];
			cards[i] = temp;
		}
	}  
}

class Card{
	String type;
	int number;
}
