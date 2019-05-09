
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

public class DayCareGenie {
	//variable list
	private ArrayList <DayCareProviderModel> list; 
	
	//constructor for other code to pass the data in
	public DayCareGenie(ArrayList <DayCareProviderModel> data) {
		list = data;
	}
	
	//Method to retrieve inspections of all day care centers in a zipcode
	public ArrayList <DayCareProviderModel> getDayCaresByZipcode (String zipcode) {
		//methods to answer question using variable list
		ArrayList<DayCareProviderModel> result = new ArrayList<DayCareProviderModel>();
		
		for(DayCareProviderModel dc : list) {
			if (dc.getZipcode() != null) {
				if (dc.getZipcode().equals(zipcode)) {
					result.add(dc);
				}
			}
			
		}
		
		return result;
	}
	
	/**
	 * gets all day care providers with the specified zipcode whose last inspection date
	 * is greater than or equal to the specified inspection date.
	 * @param zipcode - a String representing the 6 digit zipcode to look for.
	 * @param inspectionDate - a date representing the desired inspection date
	 * @return a list of Day Care Providers matching the passed parameters.
	 */
	public ArrayList <DayCareProviderModel> getDayCaresByZipcode (String zipcode, Date inspectionDate) {
		//methods to answer question using variable list
		ArrayList<DayCareProviderModel> result = new ArrayList<DayCareProviderModel>();
		
		for(DayCareProviderModel dc : list) {
			if (dc.getZipcode().equals(zipcode) == true  &&
			    (dc.getInspectiondate().after(inspectionDate) || dc.getInspectiondate().equals(inspectionDate))) {
				result.add(dc);
			}
		}
		
		return result;
	}
	
	public ArrayList<DayCareProviderModel> getDayCaresByChildcareType(String childCareType, 
			ArrayList<DayCareProviderModel> inspectionsByZipCode) {
		// this method is intended to be used after getDayCaresByZipcode has 
		// returned an arraylist of all day care centers in the specified zip code
		//
		// this method takes that arraylist and winnows it further
		// it returns an arraylist of daycare providers for the specified childcare type
		// all within that zipcode
		ArrayList<DayCareProviderModel> result = new ArrayList<DayCareProviderModel>();
		for (DayCareProviderModel dc: inspectionsByZipCode) {
			if (dc.getChildCareType() != null) {
				if (dc.getChildCareType().equals(childCareType)) {
					result.add(dc);
				}
			}
		}
		return result;
	}
	
	public HashMap<String, DayCareProviderModel> getMostRecentInspections(ArrayList<DayCareProviderModel> winnowedList) {
		/**
		 * This method takes in an arraylist of all the inspections for a zip code
		 * for day care centers of a specified type. Essentially, this method should
		 * be used only after:
		 * 1. getDayCaresByZipcode has returned an arraylist of inspections for centers by zip code
		 * 2. getDayCaresByChildcareType has winnowed that arraylist to only centers within
		 * that zip code for a specified childcare type
		 * 
		 * It iterates through those inspections and extracts the most recent inspection for
		 * each day care center.
		 * Each center and its most recent inspection are stored as key-values in a 
		 * hashmap, which is returned
		 */
		
		// hashmap to store the most recent inspections for the centers in the zip code
		HashMap<String, DayCareProviderModel> mostRecentInspections = new HashMap<String, DayCareProviderModel>();

		
		// iterate through inspections for a zipcode
		for (DayCareProviderModel inspection : winnowedList) {
			// determine if a center is in the hashmap
			// if so, determine if this inspection record is more recent than 
			// the one stored in the hashmap; if so, replace the value in the hashmap
			// with this inspection record
			// else add the center and inspection record to the hashmap
			if (mostRecentInspections.containsKey(inspection.getCenterName())) {
				if (inspection.getInspectiondate() != null) {
					Date comparisonDate = mostRecentInspections.get(inspection.getCenterName()).getInspectiondate();
					if (inspection.getInspectiondate().after(comparisonDate)) {
					mostRecentInspections.put(inspection.getCenterName(), inspection);
					}
				}
				
			} else {
				if (inspection.getInspectiondate()!= null) {
					mostRecentInspections.put(inspection.getCenterName(), inspection);
				}
				
			}
		}
		
		return mostRecentInspections;
	}
}
