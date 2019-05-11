import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import java.util.*;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class Main {

	/*
	 * The main class to run the entire program
	 * 
	 */
	
	
	public static void greenBoilerplate() {
		// helper function to print out description of green-rated day care centers
		System.out.println("Green-rated day care centers are those centers whose violation rates ");
		System.out.println("are lower than the citywide average rates in all categories.");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		String data = null;
		boolean inProgress = true;
		
		// get data from NYC website via DataRetriever
		System.out.println("Downloading data from NYC website. Thank you for your patience.");
		System.out.println();
		String url = "https://data.cityofnewyork.us/resource/dsg6-ifza.json?$limit=100000";
		DataRetriever dr = new DataRetriever();
		try {
			data = dr.getJSONDataAsStringFromURL(url);
		} catch (MalformedURIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// store data in an ArrayList of DayCareProviderModel objects
		// via DataParser
		DataParser dp = new DataParser();
		try {
			dp.createInspectionsArrayList(dp.convertToJSONArray(data));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<DayCareProviderModel> d = dp.getInspections();
		
		
		
		//for debugging
//		System.out.println("Number of inspections: " + d.size());
//		System.out.println();
		//for debugging
		
		while (inProgress) {
			// get zipcode and kid's age via userInput
			userInput ui = new userInput();
			ui.getUserInput();
			String zipcode = ui.getZipcode();
			String childCareType = ui.getChildcareType();
			
			
			// retrieve the most recent inspection records for
			// the day care centers within the user's zipcode via DayCareGenie
			
			DayCareGenie genie = new DayCareGenie(d);
			ArrayList<DayCareProviderModel> centersByZipcode = genie.getDayCaresByZipcode(zipcode);
			// winnow the arraylist further so that it only includes centers that
			// provide the childcare type sought by the user
			ArrayList<DayCareProviderModel> winnowedList = genie.getDayCaresByChildcareType(childCareType, centersByZipcode);
			
//			// for debugging
//			System.out.println("Number of inspections in this zip code: " + centersByZipcode.size());
//			System.out.println();
			// for debugging
			
			// get most recent inspection records for each center within the specified zip code that
			// provides the childcare type sought by the user
			HashMap<String, DayCareProviderModel> mostRecentInspections = genie.getMostRecentInspections(winnowedList);
			
			// for debugging
//			System.out.println("Number of recent inspections in this zip code: " + mostRecentInspections.size());
//			System.out.println();
			// for debugging
			
			// evaluate and sort those day care centers via Recommender
			Recommender r = new Recommender();
			r.assignRatings(mostRecentInspections);
			r.sortByInspectionDate();
			ArrayList<DayCareProviderModel> green = r.getGreenCenters();
			ArrayList<DayCareProviderModel> yellow = r.getYellowCenters();
			
			
			// display results for user
			
			System.out.println();
			if (green.size() > 0) {
				greenBoilerplate();
				System.out.println("These are the green-rated day care centers that offer " +  childCareType + " in zipcode " + zipcode + ":");
				System.out.println();
				for (DayCareProviderModel center : green) {
					System.out.println(center.getCenterName());
					System.out.print(center.getBuilding() + " ");
					System.out.println(center.getStreet());
					System.out.println(center.getPhone());
					if (center.getUrl() != null) {
						System.out.println(center.getUrl());
					} 
					System.out.println();
				}
			} else {
				
				if (yellow.size() > 0) {

					greenBoilerplate();
					System.out.println("There are no green-rated day care centers that offer " + childCareType + " in zipcode " + zipcode + ".");
					System.out.println();
					
					System.out.println("Yellow-rated day care centers have lower violation rates than ");
					System.out.println("the citywide average in all but one category.");
					System.out.println("These are the yellow-rated day care centers that offer " + childCareType + " in zipcode " + zipcode + ":");
					System.out.println();
					for (DayCareProviderModel center : yellow) {
						System.out.println(center.getCenterName());
						System.out.print(center.getBuilding() + " ");
						System.out.println(center.getStreet());
						System.out.println(center.getPhone());
						if (center.getUrl() != null) {
							System.out.println(center.getUrl());
						}
						System.out.println();
					}
				} else {
					System.out.println("There are no adequate day care centers that offer " + childCareType + " in zipcode " + zipcode + ".");
				}
			}
			
			// Ask if user wants to search again
			System.out.println();
			boolean newSearch = ui.continueSearch();
			System.out.println();
			if (!newSearch) {
				System.out.println("Thank you!");
				inProgress = false;
			}
		}
		
		
		
			
		
		//for debugging
//		System.out.println();
//		ArrayList<DayCareProviderModel> red = r.getRedCenters();
//		System.out.println("Number of red centers in zipcode: " + red.size());
		
		
		
		
		
		
		//ArrayList<DayCareProviderModel> dZip = genie.getDayCaresByZipcode("40404");
	}
}