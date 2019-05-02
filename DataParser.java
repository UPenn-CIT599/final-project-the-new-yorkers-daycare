import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

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
		JSONArray dataJSONArray = new JSONArray(data);
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
		 * method to be written
		 */
	}

	public ArrayList<DayCareProviderModel> getInspections() {
		return inspections;
	}

	public void setInspections(ArrayList<DayCareProviderModel> inspections) {
		this.inspections = inspections;
	}
	
	

}
