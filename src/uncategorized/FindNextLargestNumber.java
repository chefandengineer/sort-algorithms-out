package uncategorized;

public class FindNextLargestNumber {
	public static int findNextLargestNumber(){
		return 1;
	}
	
	public int getDigits(int num){
		int digits = 0;
		if (num < 10){
			return 1;
		}
		while(num != 0){
			num = num / 10;
			++digits;
		}
		return digits;
	}
}
