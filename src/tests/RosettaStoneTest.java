package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import newWhiteSpaceAssessment.FileReader;
import newWhiteSpaceAssessment.RosettaStone;

class RosettaStoneTest {
	
	@Test
	@DisplayName("createValue() creates a TreeMap<String, String> with proper values stored")
	void testCreateValues() 
	{ 
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
		
		File myObj = new File("seedData2.txt"); 
		FileReader fr2 = new FileReader(myObj);
		ArrayList<String> testAL2 = new ArrayList<String>();
		testAL2.add("gloob is I");
		testAL2.add("praefawefok is V");
		testAL2.add("lo is XX");
		testAL2.add("tegj is L");
		testAL2.add("iwreut is M");
		
		TreeMap<String, String> answerMap2 = new TreeMap<String, String>();
		answerMap2.put("gloob", "I");
		answerMap2.put("praefawefok", "V");
		answerMap2.put("lo", "XX");
		answerMap2.put("tegj", "L");
		answerMap2.put("iwreut", "M");		
		
		RosettaStone rs2 = new RosettaStone(testAL2, fr2.getMultipliers(), fr2.getPrompts());
		assertEquals(rs2.getValues(), answerMap2);
	}
	
	@Test 
	@DisplayName("createMultipliers() creates a TreeMap<String, Integer> with proper values stored")
	void testCreateMultipliers() 
	{
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

		File myObj = new File("seedData2.txt"); 
		FileReader fr2 = new FileReader(myObj);
		ArrayList<String> testAL2 = new ArrayList<String>();
		testAL2.add("gloob gloob Mohawk is 34 Credits");
		testAL2.add("gloob praefawefok Pineapple is 57800 Credits");
		testAL2.add("lo lo Peanut is 3900 Credits");

		TreeMap<String, Integer> answerMap2 = new TreeMap<String, Integer>();
		answerMap2.put("Mohawk", 17);
		answerMap2.put("Pineapple", 14450);
		answerMap2.put("Peanut", 97);
		
		RosettaStone rs2 = new RosettaStone(fr2.getValues(), testAL2, fr2.getPrompts());
		assertEquals(answerMap2, rs2.getMultipliers());
	}	
	
	@Test
	@DisplayName("createPrompts() creates an ArrayList<String> with proper values stored")
	void testCreatePrompts() 
	{
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

		File myObj = new File("seedData2.txt"); 
		FileReader fr2 = new FileReader(myObj);
		ArrayList<String> testAL2 = new ArrayList<String>();
		testAL2.add("how much is pish tegj gloob gloob ?");
		testAL2.add("how much is iwreut iwreut lo lo ?");
		testAL2.add("how many Credits is gloob lo Pineapple ?");
		testAL2.add("how many Credits is gloob lo Peanut ?");

		ArrayList<String> answerAL2 = new ArrayList<String>();
		answerAL2.add("pish tegj gloob gloob is 152");
		answerAL2.add("iwreut iwreut lo lo is 2040");
		answerAL2.add("gloob lo Pineapple is 274550 Credits");
		answerAL2.add("gloob lo Peanut is 1843 Credits");
		
		RosettaStone rs2 = new RosettaStone(fr2.getValues(), fr2.getMultipliers(), testAL2);
		assertEquals(answerAL2, rs2.getPromptAnswers());

	}
	
	@Test
	@DisplayName("tests beginning to end functionality")
	void testEndtoEnd()
	{
		FileReader fr = new FileReader();
		RosettaStone rs = new RosettaStone(fr.getValues(), fr.getMultipliers(), fr.getPrompts());
		ArrayList<String> answers = rs.getPromptAnswers();
		
		ArrayList<String> correctAnswers = new ArrayList<String>();
		correctAnswers.add("pish tegj glob glob is 42");
		correctAnswers.add("glob prok Silver is 68 Credits");
		correctAnswers.add("glob prok Gold is 57800 Credits");
		correctAnswers.add("glob prok Iron is 780 Credits");
		correctAnswers.add("I have no idea what you are talking about");
		
		assertEquals(answers, correctAnswers);
		
		File myObj = new File("seedData2.txt");
		FileReader fr2 = new FileReader(myObj);
		RosettaStone rs2 = new RosettaStone(fr2.getValues(), fr2.getMultipliers(), fr2.getPrompts());
		ArrayList<String> answers2 = rs2.getPromptAnswers();
		
		ArrayList<String> correctAnswers2 = new ArrayList<String>();
		correctAnswers2.add("pish tegj gloob gloob is 152");
		correctAnswers2.add("iwreut iwreut lo lo is 2040");
		correctAnswers2.add("gloob lo Mohawk is 323 Credits");
		correctAnswers2.add("gloob lo Pineapple is 274550 Credits");
		correctAnswers2.add("gloob lo Peanut is 1843 Credits");
	 	correctAnswers2.add("I have no idea what you are talking about");

		assertEquals(answers2, correctAnswers2);

	}
		
}
