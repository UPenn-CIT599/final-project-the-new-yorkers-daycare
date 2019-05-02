import java.util.ArrayList;

public class Main {

	/*
	 * The main class to run the entire program
	 * Code to be written
	 */
	
	public static void main(String[] args) {
		//
		DataParser dp = new DataParser();
		ArrayList<DayCareProviderModel> d = dp.getInspections();
		
		DayCareGenie genie = new DayCareGenie(d);
		
		ArrayList<DayCareProviderModel> dZip = genie.getDayCaresByZipcode("40404");
	}
}
