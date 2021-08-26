package tests;

import org.junit.jupiter.api.Test;

import newWhiteSpaceAssessment.RomanNumber;

class testRomanConversion {

	@Test
	public void test() {
		String[] strArr = {
				"I",
				"IV",
				"V",
				"IX",
				"X",
				"XL",
				"L",
				"XC",
				"C",
				"CD",
				"D",
				"CM",
				"M",
				"XLII",
				"MMXXI",
				"MCMXCIII"
		};
		
	    for (int i = 0; i<= strArr.length; i++) {
	        System.out.println(strArr[i]+"\t =\t "+RomanNumber.toInteger(strArr[i]));
	    }

	}

}
