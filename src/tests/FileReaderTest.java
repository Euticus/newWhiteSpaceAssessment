package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import newWhiteSpaceAssessment.FileReader;

class FileReaderTest {

	@Test
	// "Constructs three ArrayLists based on values, multipliers, and prompts");
	void testContructsArrayLists() {
		FileReader fr = new FileReader();
		assertEquals(Arrays.asList("glob is I", "prok is V", "pish is X",
				"tegj is L"), fr.getValues());
		assertEquals(Arrays.asList("glob glob Silver is 34 Credits", 
				"glob prok Gold is 57800 Credits", 
				"pish pish Iron is 3910 Credits"), fr.getMultipliers());
		assertEquals(Arrays.asList("how much is pish tegj glob glob ?", 
				"how many Credits is glob prok Silver ?", 
				"how many Credits is glob prok Gold ?", 
				"how many Credits is glob prok Iron ?", 
				"how much wood could a woodchuck chuck if a woodchuck could chuck wood?"), 
				fr.getPrompts());
	}


}
