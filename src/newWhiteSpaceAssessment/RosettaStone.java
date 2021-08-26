package newWhiteSpaceAssessment;


import java.util.ArrayList;
import java.util.TreeMap;

public class RosettaStone 
{
	TreeMap<String, String> values = new TreeMap<String, String>();
	TreeMap<String, Integer> multipliers = new TreeMap<String, Integer>();
	ArrayList<String> prompts = new ArrayList<String>();
	ArrayList<String> promptAnswers = new ArrayList<String>();

	public RosettaStone(ArrayList<String> v, ArrayList<String> m, ArrayList<String> p)
	{
		createValues(v);
		createMultipliers(m);
		createPrompts(p);
	}
	
	private void createValues(ArrayList<String> values) 
	{
		String[] arrOfStr;
		for (String v : values) {
			arrOfStr = v.split(" is ");
			this.values.put(arrOfStr[0], arrOfStr[1]);
		}
		
	}
	
	private void createMultipliers(ArrayList<String> multipliers) 
	{
		for (String m : multipliers) 
		{
			this.handleMultipliers(m);
		}
	}
	
	private void createPrompts(ArrayList<String> prompts) 
	{
		this.prompts = prompts;
		for (String p : prompts) 
		{
			this.handlePrompts(p);
		}

	}
	
	private void handleMultipliers(String str)
	{
		String[] arrOfStr = str.split(" is ");
		String tempStr = arrOfStr[1].replaceAll("[^\\d]", " ");
		Integer tempCredits = Integer.parseInt(tempStr.trim());
		
		String[] newArr = arrOfStr[0].split(" ");
		String tempElement = "";
		String tempRoman = "";
		for(int i = 0; i < newArr.length; i++)
		{
			int convertedNumber = 1;
			if(!this.values.containsKey(newArr[i]))
			{
				tempElement = newArr[i]; 
			}
			else if(this.values.containsKey(newArr[i]))
			{
			
				tempRoman += this.values.get(newArr[i]);
			}
			if(i == newArr.length-1)
			{
				convertedNumber = RomanNumber.toInteger(tempRoman);
				tempCredits = tempCredits / convertedNumber;
				this.multipliers.put(tempElement, tempCredits);
			}
		}
		
		// splits arrayList into before and after "is" --> arrOfStr
		// if after, pull out the integer and return it --> tempMult
		// if before, grab the words in this.values and translate them RomanNumeral.toInteger() --tempInt
		// return tempMult/tempInt --> multiplier
		// if before, return any word not in this.values --> tempElement
		// this.multipliers.add(tempElement, multiplier)
	}
	
	private void handlePrompts(String str)
	{
		if(!str.contains(" is "))
		{
			this.promptAnswers.add("I have no idea what you are talking about");
			return;
		}
		String[] arrOfStr = str.replaceAll("\\p{Punct}", "").split(" is ");
		String[] tempArr;
		if(arrOfStr[0].contains("how much"))
		{
			tempArr = arrOfStr[1].split(" ");
			String tempStr = "";
			for(String s : tempArr)
			{
				if(this.values.containsKey(s)) {
					tempStr += this.values.get(s);
				}
			}
			int converted = RomanNumber.toInteger(tempStr);
			tempStr = String.valueOf(converted);
			tempStr = arrOfStr[1] + "is " + tempStr;
			this.promptAnswers.add(tempStr);
		}
		if(arrOfStr[0].contains("how many"))
		{
			tempArr = arrOfStr[1].replaceAll("\\p{Punct}", "").split(" ");
			String tempStr = "";
			int tempMultiplier = 1;
			for(int i = 0; i < tempArr.length; i++)
			{
				if(this.multipliers.containsKey(tempArr[i]))
				{
					tempMultiplier = this.multipliers.get(tempArr[i]);
				}
				else if (this.values.containsKey(tempArr[i])) 
				{
					tempStr += this.values.get(tempArr[i]);
				}
				if(i == tempArr.length-1)
				{
					int converted = RomanNumber.toInteger(tempStr);
					tempStr = String.valueOf(tempMultiplier * converted);
				}
			}
			tempStr = arrOfStr[1] + "is " + tempStr + " Credits";
			this.promptAnswers.add(tempStr);
		}
		// if "how much" --> 
		// 		split before/after "is" --> arrOfStr
		// 		String s += arrOfStr[1] + " is "
		// 		s += RomanNumeral.toInteger(str)
		// 		this.promptAnswers.add(s)
		// if "how many credits"
		// 		Integer tempMult = find word in this.multiplers and set equal to its value
		// 		split before/after "is" --> arrOfStr
		// 		String s += arrOfStr[1] + " is " + String.parseString(tempMult * RomanNumeral.toInteger(str))
		// 		this.promptsAnswers.add(s)
		// else 
		//
		// 		this.promptAnswers.add("I have no idea what you are talking about")
	}
	
	public TreeMap<String, String> getValues()
	{
		return this.values;
	}
	
	public TreeMap<String, Integer> getMultipliers()
	{
		return this.multipliers;
	}
	
	public ArrayList<String> getPrompts()
	{
		return this.prompts;
	}
	
	public ArrayList<String> getPromptAnswers()
	{
		return this.promptAnswers;
	}


	public void getTheMeaningOfLife() {

		for(String a : this.promptAnswers)
		{
			System.out.println("\n"+ a);
		}
		
	}
}
