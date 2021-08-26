package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import newWhiteSpaceAssessment.FileReader;
import newWhiteSpaceAssessment.RosettaStone;

class RosettaStoneTest {
	
	@Test
	@DisplayName("createValue() creates the TreeMap I want")
	void testCreateValues() { 
		FileReader fr = new FileReader();
		ArrayList<String> testAL = new ArrayList<String>();
		testAL.add("glob is I");
		testAL.add( "prok is V");
		testAL.add("pish is X");
		testAL.add("tegj is L");
		
		TreeMap<String, String> answerMap = new TreeMap<String, String>();
		answerMap.put("glob", "I");
		answerMap.put("prok", "V");
		answerMap.put("pish", "X");
		answerMap.put("tegj", "L");
		
		RosettaStone rs = new RosettaStone(testAL, fr.getMultipliers(), fr.getPrompts());
		assertEquals(rs.getValues(), answerMap);
		
		// createValues tests
		// keys can be any size
		// values can be any single digit roman numeral
		// value can be any roman numeral
		
		
//		File myObj = new File("seedData2.txt"); 
//		FileReader fr2 = new FileReader(myObj);
//		ArrayList<String> testAL2 = new ArrayList<String>();
//		testAL2.add("gloob is I");
//		testAL2.add("praefawefok is V");
//		testAL2.add("lo is XX");
//		testAL2.add("tegj is L");
//		testAL2.add("iwreut is M");
//		
//		TreeMap<String, String> answerMap2 = new TreeMap<String, String>();
//		answerMap2.put("gloob", "I");
//		answerMap2.put("praefawefok", "V");
//		answerMap2.put("lo", "XX");
//		answerMap2.put("tegj", "L");
//		answerMap2.put("iwreut", "M");		
//		
//		RosettaStone rs2 = new RosettaStone(testAL2, fr2.getMultipliers(), fr2.getPrompts());
//		assertEquals(rs2.getValues(), answerMap2);
	}
	
	@Test 
	@DisplayName("createMultipliers() creates the TreeMap I want")
	void testCreateMultipliers() {
		FileReader fr = new FileReader();
		ArrayList<String> testAL = new ArrayList<String>();
		testAL.add("glob glob Silver is 34 Credits");
		testAL.add( "glob prok Gold is 57800 Credits");
		testAL.add("pish pish Iron is 3900 Credits");
		
		TreeMap<String, Integer> answerMap = new TreeMap<String, Integer>();
		answerMap.put("Silver", 17);
		answerMap.put("Gold", 14450);
		answerMap.put("Iron", 195);
		
		RosettaStone rs = new RosettaStone(fr.getValues(), testAL, fr.getPrompts());
		assertEquals(answerMap, rs.getMultipliers());
		
		// createMultipliers tests
					// successfully stores any string as element in a TreeMap
					// successfully calculates values before element, 
					// 		divides by # of Credits, stores answer as value in TreeMap
					// elements can be any string
//		File myObj = new File("seedData2.txt"); 
//		FileReader fr2 = new FileReader(myObj);
//		ArrayList<String> testAL2 = new ArrayList<String>();
//		testAL2.add("gloob gloob Mohawk is 34 Credits");
//		testAL2.add("gloob praefawefok Pineapple is 57800 Credits");
//		testAL2.add("lo lo Peanut is 3900 Credits");
//		System.out.println("testAL2" + testAL2);
//		TreeMap<String, Integer> answerMap2 = new TreeMap<String, Integer>();
//		answerMap2.put("Mowhawk", 17);
//		answerMap2.put("Pineapple", 14450);
//		answerMap2.put("Peanut", 195);
//		
//		RosettaStone rs2 = new RosettaStone(fr2.getValues(), fr2.getMultipliers(), fr2.getPrompts());
//		System.out.println("hitting");
//		System.out.println(answerMap2);
//		System.out.println(rs2.getMultipliers());
//		assertEquals(answerMap2, rs2.getMultipliers());
	}	
	
	@Test
	@DisplayName("filters string not in this.values into tree map and calculates a multiplier")
	void testHandleMultipliers()
	{
		// splits arrayList into before and after "is" --> arrOfStr
		// if after, pull out the integer and return it --> tempMult
		// if before, grab the words in this.values and translate them RomanNumeral.toInteger() --tempInt
		// return tempMult/tempInt --> multiplier
		// if before, return any word not in this.values --> tempElement
		// this.multipliers.put(tempElement, multiplier)
		
		
	}
	
	
	@Test
	@DisplayName("createPrompts() creates the ArrayList I want")
	void testCreatePrompts() {
		FileReader fr = new FileReader();
		ArrayList<String> testAL = new ArrayList<String>();
		testAL.add("how much is pish tegj glob glob ?");
		testAL.add("how many Credits is glob prok Silver ?");
		testAL.add("how many Credits is glob prok Gold ?");
		testAL.add("how many Credits is glob prok Iron ?");
		testAL.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood?");

		ArrayList<String> answerAL = new ArrayList<String>();;
		answerAL.add("pish tegj glob glob is 42");
		answerAL.add("glob prok Silver is 68 Credits");
		answerAL.add("glob prok Gold is 57800 Credits");
		answerAL.add("glob prok Iron is 780 Credits");
		answerAL.add("I have no idea what you are talking about");

		RosettaStone rs = new RosettaStone(fr.getValues(), fr.getMultipliers(), testAL);
		assertEquals(answerAL, rs.getPromptAnswers());
		
		// create prompts tests
					// successfully adds a string of values together --> roman numeral --> integer
					// successfully multiplies if element present
					// properly handles prompts that have no meaning
					// prints successfully
	}
	
	@Test
	@DisplayName("executes appropriate actions based on how much || how many")
	void testHandlePrompts()
	{
		// if "how much" --> 
		// 		split before/after "is" --> arrOfStr
		// 		String s += arrOfStr[1] + " is "
		// 		s += RomanNumeral.toInteger(str)
		// 		this.prompts.add(s)
		// if "how many credits"
		// 		Integer tempMult = find word in this.multiplers and set equal to its value
		// 		split before/after "is" --> arrOfStr
		// 		String s += arrOfStr[1] + " is " + String.parseString(tempMult * RomanNumeral.toInteger(str))
		// 		this.prompts.add(s)
		// else 
		//
		// 		this.prompts.add("I have no idea what you are talking about")
	}
		
			
		

}
