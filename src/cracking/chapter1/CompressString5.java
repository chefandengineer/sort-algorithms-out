package cracking.chapter1;

public class CompressString5 {
	public static String compressString(String str){
		StringBuffer cpsStr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i = 0; i < str.length(); i++){
			char cur = str.charAt(i);
			if (cur == last){
				count++;
			} else {
				cpsStr.append(last);
				cpsStr.append(count);
				last = cur;
				count = 1;
			}
		}
		cpsStr.append(last);
		cpsStr.append(count);
		if(cpsStr.toString().length() >= str.length()){
			return str;
		} 
		return cpsStr.toString();
	}
	
	public static void main(String[] args){
		String str = "abcd";
		System.out.println(compressString(str));
	}
}
