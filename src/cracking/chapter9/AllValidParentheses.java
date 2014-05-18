package cracking.chapter9;

public class AllValidParentheses {
	public static void getAllParentheses(char[] parens, int index, int left, int right){
		if (left < 0 || right < left){
			return;
		}
		if (left == 0 && right == 0) {
			System.out.println(parens);
			return;
		}
		if(left > 0) {
			parens[index] = '(';
			getAllParentheses(parens,index + 1,left - 1,right);
		}
		if(left < right) {
			parens[index] = ')';
			getAllParentheses(parens,index + 1,left,right - 1);
		}
	}
	
	public static  void printAllParentheses(int n){
		char[] parens = new char[2*n];
		getAllParentheses(parens,0,n,n);
	}
	public static void main(String[] args){
		printAllParentheses(2);
	}
}
