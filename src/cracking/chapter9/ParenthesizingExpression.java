package cracking.chapter9;
//TODO : Why changing += to + won't work,
//need to figure out

public class ParenthesizingExpression {
	public static int waysToParen(String expression, boolean result, int pStart, int pEnd){
		//The base case
		int ways = 0;
		if(pStart == pEnd){
			if (expression.charAt(pStart) == '1' && result){
				return 1;
			}
			if (expression.charAt(pStart) == '0' && !result){
				return 1;
			}
			return 0;
		} 
		if (result) {
			for(int i = pStart + 1; i <= pEnd ; i+=2){
				char operator = expression.charAt(i);
				switch (operator) {
					case '&' : ways += waysToParen(expression,true,pStart,i-1) 
									* waysToParen(expression,true,i+1,pEnd);
								break;
					case '|' : ways += waysToParen(expression,false,pStart,i-1) 
									* waysToParen(expression,true,i+1,pEnd);
							ways +=	waysToParen(expression,true,pStart,i-1) 
									* waysToParen(expression,false,i+1,pEnd);  
							ways += waysToParen(expression,true,pStart,i-1) 
									* waysToParen(expression,true,i+1,pEnd);
								break;
					case '^' : ways += waysToParen(expression,false,pStart,i-1) 
									* waysToParen(expression,true,i+1,pEnd);
								ways += waysToParen(expression,true,pStart,i-1) 
								    * waysToParen(expression,false,i+1,pEnd);
								break;
				}
			}
		} else {
			for(int i = pStart + 1; i <= pEnd ; i+=2){
				char operator = expression.charAt(i);
				switch (operator) {
					case '&' : ways += waysToParen(expression,false,pStart,i-1) 
									* waysToParen(expression,false,i+1,pEnd);
							   ways += waysToParen(expression,false,pStart,i-1) 
									* waysToParen(expression,true,i+1,pEnd); 
							   ways += waysToParen(expression,true,pStart,i-1) 
									* waysToParen(expression,false,i+1,pEnd);
								break;
					case '|' : ways += waysToParen(expression,false,pStart,i-1) 
									* waysToParen(expression,false,i+1,pEnd);
								break;
					case '^' : ways += waysToParen(expression,true,pStart,i-1) 
								    * waysToParen(expression,true,i+1,pEnd);
							 ways +=
								      waysToParen(expression,false,pStart,i-1) 
								    * waysToParen(expression,false,i+1,pEnd);
								break;
				}
			}
		}
		System.out.println(ways);
		return ways;
	}
	
	public static void main(String[] args){
		String expression = "1|1|1|1";
		boolean result = true;
		System.out.println(waysToParen(expression,result,0,expression.length()-1));
		int ways = 0;
		ways = 1 + 3 + 4 + 5;
		System.out.println(ways);
		ways = 0;
		ways+=1;
		ways+=3;
		ways+=4;
		ways+=5;
		System.out.println(ways);
		
	}
}
