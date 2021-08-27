Aug 26, 2021

This is for the WhiteSpace Assessment! 

clone down and run in any Java environment

There are 4 Classes: \n
	1. FileReader \n
		-- reads seedData.txt and seedData2.txt \n
		-- filters data into 3 ArrayList<String>() \n
	2. RomanNumber \n
		-- recursively converts any string of Roman Numerals into integers \n
	3. RosettaStone \n
		-- further filters data from FileReader into TreeMaps to access for later calculations \n
		-- calculates a multiplier 'element' and stores in another TreeMap \n
		-- creates ArrayList<String> promptAnswers \n
	4. GalaxyDriver \n
		-- a humorously named driver class to do everything \n 
		-- calls getTheMeaningOfLife() from the RosettaStone class to print answers \n
		

Tests include: \n
	-- two seed files for further test cases \n
	-- 3 unit tests ensuring createValues() , createMultipliers(), and createPrompts() in the RosettaStone class are used properly \n
	-- 1 end-to-end test for both seed files \n
