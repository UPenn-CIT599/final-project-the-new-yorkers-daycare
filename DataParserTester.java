import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.*;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import org.junit.jupiter.api.Test;

class DataParserTester {

	@Test
	void test() {
		/**
		 * This is a JUnit test for the DataParser class.
		 * 
		 * We create a DataRetriever object to get 1000 inspection records from the 
		 * NYC Dept. of Health and Mental Hygiene and return this as a string.
		 * 
		 * This string is passed to a DataParser object, which constructs a JSONArray.
		 * It then iterates through the JSONArray, using each JSONObject to construct
		 * a DayCareProviderModel object, which it stores in an ArrayList.
		 * 
		 * This ArrayList should have size 1000.
		 */
		
		DataRetriever dr = new DataRetriever();
		String data = null;
		try {
			data = dr.getJSONDataAsStringFromURL("https://data.cityofnewyork.us/resource/dsg6-ifza.json");
		} catch (MalformedURIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataParser dp = new DataParser();
		try {
			dp.createInspectionsArrayList(dp.convertToJSONArray(data));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<DayCareProviderModel> results = dp.getInspections();
		assertEquals(results.size(), 1000);
	}

}
