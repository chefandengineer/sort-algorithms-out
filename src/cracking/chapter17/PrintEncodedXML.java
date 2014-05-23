package cracking.chapter17;

import java.util.Map;

public class PrintEncodedXML {
	public static String printEncodedXml(String encodedXML, Map<Integer,String> map){
		String[] encodedArr = encodedXML.split(" ");
		String xml = "";
		int i = 0;
		String childElement = "";
		String closeTag = "";
		for (; i < encodedArr.length ; ++i){
			String str = encodedArr[i];
			if (isNumeric(str)) {	
				if (Integer.parseInt(str) == 0){
					xml += ">" + "\n";
					break;
				}
				String tagName = map.get(Integer.valueOf(encodedArr[i]));
				xml += tagName;
				if (i == 0){
					closeTag = "</" + tagName + ">";
				}
			} else {
				xml += "=\"";
				xml += encodedArr[i];
				xml += "\"";
			}			
		}
		childElement = encodedXML.substring(i + 2, encodedXML.length() - 1);
		xml += printEncodedXml(childElement, map);
		xml += closeTag;
		return xml;
		
	}
	public static boolean isNumeric(String str){
		try {
			int a = Integer.parseInt(str);
		} catch (NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println("");
	}
}
