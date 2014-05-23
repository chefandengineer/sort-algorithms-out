package cracking.chapter17;

public class EnglishPhraseOfNumber {
	
	private static final String[] _THREE_PHRASE = {
							"Thousand",
							"Million",
							"Billion" };
	private static final String[] _SINGLE_PHRASE = {
							"One",
							"Two",
							"Three",
							"Four",
							"Five",
							"Six",
							"Seven",
							"Eight",
							"Nine",
							 "Ten",
							 "Eleven",
							 "Tweleve",
							 "Fourteen",
							 "Fifteen",
							 "Sixteen",
							 "Seventeen",
							 "Eighteen",
							 "Nineteen"};
	private static final String[] _TENS_PHRASE = {
							"Twenty",
							"Thirty",
							"Fourty",
							"Fifty",
							"Sixty",
							"Seventy",
							"Eighty",
							"Ninty",
							"Hundred"
							};
	
	public static String translateNumber(int number){
		String phrase = "";
		int digits = getDigits(number);
		int prefixNumber;
		int phraseIndex;
		int remaining;
		if (digits <= 2 && number < 20){
			if (number > 0){
				phrase += _SINGLE_PHRASE[number-1] + " ";
			}
			return phrase;
		} else if (digits <= 3){
			if (digits == 3){
				prefixNumber = number / 100;
				remaining = number % 100;
				phrase += translateNumber(prefixNumber);
				phrase += _TENS_PHRASE[8] + " ";
				phrase += translateNumber(remaining);
			} else {
				prefixNumber = number / 10;
				remaining = number % 10;
				phrase += _TENS_PHRASE[prefixNumber - 2 ] + " ";
				if (remaining != 0) {
					phrase += translateNumber(remaining);
				}
			}
			return phrase;
		} else {
			phraseIndex = digits / 3;
			prefixNumber = number / (int) Math.pow(10,phraseIndex * 3);
			remaining = number % (int) Math.pow(10, phraseIndex * 3);
			phrase += translateNumber(prefixNumber);
			phrase += _THREE_PHRASE[phraseIndex - 1] + " ";
			phrase += translateNumber(remaining);
			return phrase;
		}
	}
	
	public static int getDigits(int number){
		int digits = 0;
		if (number == 0){
			return digits;
		}
		while(number != 0){
			number = number / 10;
			digits++;
		}
		return digits;
	}
	
	public static void main(String[] args){
		System.out.println(translateNumber(10000011));
	}

}
