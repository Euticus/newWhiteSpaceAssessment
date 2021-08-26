package newWhiteSpaceAssessment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumber {

	private static Map<Character, Integer> map = new LinkedHashMap<>();
	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	public static final int toInteger(String s) {
		return toInteger(s, 0);
	}

	private static final int toInteger(String s, int index) {
		if(index == s.length()) {
			return 0;
		}
		return getNumber(s, index) + toInteger(s.substring(index+1, s.length()));
	}

	private static final int getNumber(String s, int index) {
		if(index+1 == s.length()) {
			return map.get(s.charAt(index));
		}
		
		if (map.get(s.charAt(index)) >= map.get(s.charAt(index+1))) {
			return map.get(s.charAt(index));
		} else {
			return -map.get(s.charAt(index));
		}		
	}

}