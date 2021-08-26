package newWhiteSpaceAssessment;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class IntergalacticConverter {
	
	private RosettaStone rs;
	private ArrayList<String> answers = new ArrayList<String>();
	
	public IntergalacticConverter(RosettaStone rs)
	{
		this.rs = rs;
		this.calculate(rs.getPrompts());
	}

	private void calculate(ArrayList<String> prompts)
	{
		// for ()
		// if "how much"
		// 	sum values
		// 	convert to string
		// 	add answer to ArrayList<String> answers
		
		// if "how many" contains element enum
		// 	sum values and multiply 
		// 	convert to string
		// 	add answer to ArrayList<String> answers
	}
	
	
	public void getMeaningOfLife() 
	{
		// for loop over answers
		// print 
	}
}
