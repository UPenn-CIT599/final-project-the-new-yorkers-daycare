import java.util.ArrayList;

import org.json.JSONArray;

public class Main {

	/*
	 * The main class to run the entire program
	 * Code to be written
	 */
	
	public static void main(String[] args) {
		try {
			//Get the data from the URL as a string
			DataRetriever retriever = new DataRetriever();
			String data = retriever.getJSONDataAsStringFromURL("https://data.cityofnewyork.us/resource/dsg6-ifza.json?$limit=100000");
			//Convert the string of data into an Array of JSON objects
			DataParser parser = new DataParser();
			JSONArray jsonArray = parser.convertToJSONArray(data);
			//Convert the JSONArray into an ArrayList of DayCareProviderModel
			parser.createInspectionsArrayList(jsonArray);
			//get what has been converted from the parser;
			ArrayList<DayCareProviderModel> d = parser.getInspections();
			for (DayCareProviderModel m : d) {
				System.out.println("cn: " + m.getCenterName()); //+ " last ins date: " + m.getInspectiondate());
			}
			System.out.println(d.size());
			//DayCareGenie genie = new DayCareGenie(d);
			
			//ArrayList<DayCareProviderModel> dZip = genie.getDayCaresByZipcode("40404");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
