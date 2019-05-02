import java.util.ArrayList;
import java.util.Date;

public class DayCareGenie {
	//variable list
	private ArrayList <DayCareProviderModel> list; 
	
	//constructor for other code to pass the data in
	public DayCareGenie(ArrayList <DayCareProviderModel> data) {
		list = data;
	}
	
	//Method to retreive 
	ArrayList <DayCareProviderModel> getDayCaresByZipcode (String zipcode) {
		//methods to answer question using variable list
		ArrayList<DayCareProviderModel> result = new ArrayList<DayCareProviderModel>();
		
		for(DayCareProviderModel dc : list) {
			if (dc.getZipcode().equals(zipcode) == true) {
				result.add(dc);
			}
		}
		
		return result;
	}
	
	/**
	 * gets all day care providers with the specified zipcode whose last inspection date
	 * is greater than or equal to the specified inpsection date.
	 * @param zipcode - a String representing the 6 digit zipcode to look for.
	 * @param inspectionDate - a date representing the desired inspection date
	 * @return a list of Day Care Providers matching the passed parameters.
	 */
	ArrayList <DayCareProviderModel> getDayCaresByZipcode (String zipcode, Date inspectionDate) {
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
}
