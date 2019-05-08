import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataParser {
	
	/*
	 * DataRetriever queries the URL for NYC's Open Data website and gets the
	 * childcare inspections dataset in the form of a string.
	 * 
	 * DataParser takes that string and parses it into JSONObjects, which 
	 * are stored in a JSONArray.
	 * 
	 * Each JSONObject (representing the results of one inspection of a 
	 * day care center) is then used to create a DayCareProviderModel object, which will
	 * be used by the other classes in this program.
	 * 
	 * These DayCareProviderModel objects are stored in an ArrayList.
	 * 
	 */
	
	private ArrayList<DayCareProviderModel> inspections = new ArrayList<DayCareProviderModel>();
	
	public JSONArray convertToJSONArray (String data) {
		/*
		 * Takes in a string (the result of DataRetriever
		 * querying the NYC Open Data site) and puts all of
		 * that data into a JSONArray
		 */
		JSONArray dataJSONArray = null;
		try {
			dataJSONArray = new JSONArray(data);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataJSONArray;
	}
	
	public void createInspectionsArrayList (JSONArray dataJSONArray) {
		/*
		 * This method iterates through a JSONArray containing the
		 * data on the city's inspections of day centers and builds
		 * Model objects.
		 * 
		 * Each inspection is a JSONObject stored in the JSONArray.
		 * This method extracts the data about that inspection from the
		 * JSONObject and uses that data to construct a Model object.
		 * 
		 * This Model object is then stored in the inspections ArrayList.
		 * 
		 * 
		 */
		
		// iterate through JSONArray
		for (int i = 0; i < dataJSONArray.length(); i++) {
			// instantiate new DayCareProviderModel object
			DayCareProviderModel inspectionRecord = new DayCareProviderModel();
			
			// extract data from JSONObject and use that data to
			// construct inspectionRecord
			try {
				JSONObject inspection = dataJSONArray.getJSONObject(i);
				inspectionRecord.setCenterName((String) inspection.get("centername"));
				inspectionRecord.setLegalName((String) inspection.get("legalname"));
				inspectionRecord.setBuilding((String) inspection.get("building"));
				inspectionRecord.setStreet((String) inspection.get("street"));
				inspectionRecord.setBorough((String) inspection.get("borough"));
				inspectionRecord.setZipcode((String) inspection.get("zipcode"));
				inspectionRecord.setPhone((String) inspection.get("phone"));
				inspectionRecord.setPermitNumber((String) inspection.get("permitnumber"));
				inspectionRecord.setPermitExp((String) inspection.get("permitexp"));
				inspectionRecord.setLegalName((String) inspection.get("legalname"));
				inspectionRecord.setStatus((String) inspection.get("status"));
				inspectionRecord.setAgeRange((String) inspection.get("agerange"));
				inspectionRecord.setMaximumCapacity(Integer.parseInt((String) inspection.get("maximumcapacity")));
				inspectionRecord.setDcID((String) inspection.get("dc_id"));
				inspectionRecord.setProgramType((String) inspection.get("programtype"));
				inspectionRecord.setChildCareType((String) inspection.get("childcaretype"));
				inspectionRecord.setBin(Integer.parseInt((String) inspection.get("bin")));
				inspectionRecord.setUrl((String) inspection.get("url"));
				inspectionRecord.setDatePermitted((String) inspection.get("datepermitted"));
				inspectionRecord.setActual((String) inspection.get("actual"));
				inspectionRecord.setViolationRatePercent(Double.parseDouble((String) inspection.get("violationratepercent")));
				inspectionRecord.setViolationAvgRatePercent(Double.parseDouble((String) inspection.get("violationavgratepercent")));
				inspectionRecord.setTotalEducationalWorkers(Integer.parseInt((String) inspection.get("totaleducationalworkers")));
				inspectionRecord.setPublicHealthHazardViolationRate(Double.parseDouble((String) inspection.get("publichealthhazardviolationrate")));
				inspectionRecord.setAveragePublicHealthHazardViolationRate(Double.parseDouble((String) inspection.get("averagepublichealthhazardviolationrate")));
				inspectionRecord.setCriticalViolationRate(Double.parseDouble((String) inspection.get("criticalviolationrate")));
				inspectionRecord.setAvgCriticalViolationRate(Double.parseDouble((String) inspection.get("avgcriticalviolationrate")));
				inspectionRecord.setRegulationSummary((String) inspection.get("regulationsummary"));
				inspectionRecord.setViolationCategory((String) inspection.get("violationcategory"));
				inspectionRecord.setHealthCodeSubsection((String) inspection.get("healthcodesubsection"));
				inspectionRecord.setViolationStatus((String) inspection.get("violationstatus"));
				inspectionRecord.setInspectionSummaryResult((String) inspection.get("inspectionsummaryresult"));
				
				// get inspectiondate from JSONObject and create a Date object
				// set inspectionRecord's inspectiondate member to this Date object
				String inspectionDateString = (String) inspection.get("inspectiondate");
				String month = inspectionDateString.substring(5, 7);
				String day = inspectionDateString.substring(8, 10);
				String year = inspectionDateString.substring(0, 4);
				String date = month + "/" + day + "/" + year;
				try {
					Date inspectionDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
					inspectionRecord.setInspectiondate(inspectionDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			// store inspectionRecord in inspections ArrayList
			inspections.add(inspectionRecord);
			
		}
	}

	public ArrayList<DayCareProviderModel> getInspections() {
		return inspections;
	}

	public void setInspections(ArrayList<DayCareProviderModel> inspections) {
		this.inspections = inspections;
	}
	
	

}
