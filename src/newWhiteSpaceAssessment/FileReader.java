package newWhiteSpaceAssessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public final class FileReader {
	
	private final ArrayList<String> values = new ArrayList<String>();
	private final ArrayList<String> multipliers = new ArrayList<String>();
	private final ArrayList<String> prompts = new ArrayList<String>();
	
	public FileReader() {
		try 
		{
			File myObj = new File("seedData.txt"); 
			Scanner sc = new Scanner(myObj); 	
			String input ;
			while (sc.hasNextLine()) {
				input = sc.nextLine();
				if (input.contains("how much") || input.contains("how many"))
				{
					prompts.add(input);
				} 
				else if ( !input.contains("Credits") 
					&& !(input.contains("how much") || input.contains("how many")))
				{
					values.add(input);
				}
				else
				{
					multipliers.add(input);
				}
			}
			sc.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public FileReader(File f) {
		try 
		{
			Scanner sc = new Scanner(f); 
			String input;
			while (sc.hasNextLine()) {
				input = sc.nextLine();
				if (input.matches("\\d"))
				{
					multipliers.add(input);
				}
				if (input.contains("how much") || input.contains("how many"))
				{
					prompts.add(input);
				}
				else 
				{
					values.add(input);
				}
			}
			sc.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getValues() {
		return this.values;
	}
	
	public ArrayList<String> getMultipliers() {
		return this.multipliers;
	}
	
	public ArrayList<String> getPrompts() {
		return this.prompts;
	}
	
}
