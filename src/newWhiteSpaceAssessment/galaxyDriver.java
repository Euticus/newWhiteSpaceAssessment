package newWhiteSpaceAssessment;

public class GalaxyDriver {

	public static void main(String[] args) {
			 FileReader fr = new FileReader();
			 RosettaStone rs = new RosettaStone(fr.getValues(), 
					 		fr.getMultipliers(), fr.getPrompts());
			 rs.getTheMeaningOfLife();

	}

}
