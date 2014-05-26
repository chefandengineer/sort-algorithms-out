package cracking.chapter1;

public class CheckRotation8 {
	public static boolean isRotation(String s1,String s2){
		if(s2.length() > 0 && s2.length() == s1.length()){
			String s = s2 + s2;
			return isSubString(s,s1);
		}
		return false;
	}
	public static boolean isSubString(String s1, String s2){
		return true;
	}
}
