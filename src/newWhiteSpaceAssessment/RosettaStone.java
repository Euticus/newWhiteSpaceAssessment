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
		String[] arrOfStr = str.split(" is "); // divides the string based on keyword "is"
		String numCredits = arrOfStr[1].replaceAll("[^\\d]", " ");
		Integer multiplier = Integer.parseInt(numCredits.trim());
		
		String[] valueAndMultiplierArr = arrOfStr[0].split(" ");
		String element = "";
		String roman = "";
		for(int i = 0; i < valueAndMultiplierArr.length; i++)
		{
			int convertedNumber = 1;
			if(!this.values.containsKey(valueAndMultiplierArr[i]))
			{
				element = valueAndMultiplierArr[i]; 
			}
			else if(this.values.containsKey(valueAndMultiplierArr[i]))
			{
				roman += this.values.get(valueAndMultiplierArr[i]);
			}
			if(i == valueAndMultiplierArr.length-1)
			{
				convertedNumber = RomanNumber.toInteger(roman);
				multiplier = multiplier / convertedNumber;
				this.multipliers.put(element, multiplier);
			}
		}
		
	}
	
	private void handlePrompts(String str)
	{
		if(!str.contains(" is "))
		{
			this.promptAnswers.add("I have no idea what you are talking about");
			return;
		}
		String[] arrOfStr = str.replaceAll("\\p{Punct}", "").split(" is "); // splits string before and after "is"
		String[] arrayOfPrompts;
		if(arrOfStr[0].contains("how much"))
		{
			arrayOfPrompts = arrOfStr[1].split(" ");
			String promptAnswer = "";
			for(String s : arrayOfPrompts)
			{
				if(this.values.containsKey(s)) {
					promptAnswer += this.values.get(s);
				}
			}
			int converted = RomanNumber.toInteger(promptAnswer);
			promptAnswer = String.valueOf(converted);
			promptAnswer = arrOfStr[1] + "is " + promptAnswer;
			this.promptAnswers.add(promptAnswer);
		}
		if(arrOfStr[0].contains("how many"))
		{
			arrayOfPrompts = arrOfStr[1].replaceAll("\\p{Punct}", "").split(" ");
			String promptAnswer = "";
			int tempMultiplier = 1;
			for(int i = 0; i < arrayOfPrompts.length; i++)
			{
				if(this.multipliers.containsKey(arrayOfPrompts[i]))
				{
					tempMultiplier = this.multipliers.get(arrayOfPrompts[i]);
				}
				else if (this.values.containsKey(arrayOfPrompts[i])) 
				{
					promptAnswer += this.values.get(arrayOfPrompts[i]);
				}
				if(i == arrayOfPrompts.length-1)
				{
					int converted = RomanNumber.toInteger(promptAnswer);
					promptAnswer = String.valueOf(tempMultiplier * converted);
				}
			}
			promptAnswer = arrOfStr[1] + "is " + promptAnswer + " Credits";
			this.promptAnswers.add(promptAnswer);
		}
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
