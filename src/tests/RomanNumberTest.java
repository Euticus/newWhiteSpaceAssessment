package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import newWhiteSpaceAssessment.RomanNumber;

public class RomanNumberTest {

		@Test
		public void testToInteger() {
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
			
			int[] answerArr = {
					1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 42, 2021, 1993
			};
			
			int answer;
		    for (int i = 0; i < strArr.length; i++) {
		    	answer = RomanNumber.toInteger(strArr[i]);
		        System.out.println(strArr[i]+"\t =\t "+RomanNumber.toInteger(strArr[i]));
		        assertEquals(answer, answerArr[i]);
		    }
		    
		    

		}

	}
