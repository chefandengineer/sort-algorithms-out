package cracking.chapter18;
/**
 * 
 * Write a method to count the number of 2s between 0 and n.
 * 
 * Solution: 
 * At a given digit: 
 * 1. if the digit is lower than 2. Num(2) = Higher * factor
 * 2. if the digit is equals to 2. Num(2) = Higher * factor + lower + 
 * 3. if digit is greater than 2. Num(2) =   
 * @author Tao Jiang 
 */

public class CountOccuranceOfTwo4{
	
	public static int count2sBF(int n){
		int number = 0;
		int count = 0;
		int digit;
		int cur = 2;
		while (cur <= n){
			number = cur;
			while(number != 0){
				digit = number % 10;
				if (digit == 2){
					count++;
				}
				number = number / 10;
			}
			cur++;
		}
		return count;
	}
	
	public static int count2s(int n){
		int factor = 1;
		int count = 0;
		int highFix = 0;
		int lowFix = 0;
		int digit = 0;
		int factorNum = (int) Math.pow(10, factor - 1) ;
		int nCopy = n;
		
		while(nCopy != 0) {
			highFix = n / (int) Math.pow(10, factor);
			lowFix = n % (int) Math.pow(10, factor - 1);
			digit = (n / (int) Math.pow(10,factor - 1)) % 10;
			factorNum = (int) Math.pow(10, factor - 1) ;
			
			
			if (digit < 2) {
				count += highFix * factorNum;
			} 
			if (digit == 2) {
				count +=  highFix * factorNum + lowFix + 1; 
			} 
			if (digit > 2) {
				count += (highFix + 1) * factorNum; 
			}
			factor++;
			nCopy = nCopy / 10;
		}
		return count;
	}
	
	public static void main(String[] args){
		int n = 422;
		int n2s = count2s(n);
		int n2sBF = count2sBF(n);
		System.out.println(n2s);
		System.out.println(n2sBF);
	}
}
