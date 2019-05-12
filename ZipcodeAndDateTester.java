import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ZipcodeAndDateTester {

	@Test
	void test() {
		/**
		 * DayCareGenie class has a method, getDayCaresByZipcode, which is
		 * overloaded. One version takes in only a string (zipcode), and the
		 * other takes in a string (zipcode) and a Date (inpection date).
		 * 
		 * This JUnit test tests the version that takes in a string and a Date
		 * as arguments.
		 * 
		 * We create a toy ArrayList of DayCareProviderModel objects.
		 * Two of these objects have BOTH the desired zip code ("12345") and are after
		 * the Date (04/01/2019) passed to the method.
		 */
		
		// instantiate toy ArrayList of DayCareProviderModel objects
				DayCareProviderModel center1 = new DayCareProviderModel();
				DayCareProviderModel center2 = new DayCareProviderModel();
				DayCareProviderModel center3 = new DayCareProviderModel();
				DayCareProviderModel center4 = new DayCareProviderModel();
				DayCareProviderModel center5 = new DayCareProviderModel();
				DayCareProviderModel center6 = new DayCareProviderModel();
				
				center1.setCenterName("Center 1");
				center2.setCenterName("Center 2");
				center3.setCenterName("Center 3");
				center4.setCenterName("Center 4");
				center5.setCenterName("Center 5");
				center6.setCenterName("Center 6");
				
				center1.setZipcode("12345");
				center2.setZipcode("11215");
				center3.setZipcode("12345");
				center4.setZipcode("10007");
				center5.setZipcode("12345");
				center6.setZipcode("10305");
				
				String date1 = "11/02/2018";
				Date dt1;
				try {
					dt1 = new SimpleDateFormat("MM/dd/yyyy").parse(date1);
					center1.setInspectiondate(dt1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String date2 = "05/02/2019";
				Date dt2;
				try {
					dt2 = new SimpleDateFormat("MM/dd/yyyy").parse(date2);
					center2.setInspectiondate(dt2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String date3 = "04/23/2019";
				Date dt3;
				try {
					dt3 = new SimpleDateFormat("MM/dd/yyyy").parse(date3);
					center3.setInspectiondate(dt3);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String date4 = "04/18/2019";
				Date dt4;
				try {
					dt4 = new SimpleDateFormat("MM/dd/yyyy").parse(date4);
					center4.setInspectiondate(dt4);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String date5 = "04/11/2019";
				Date dt5;
				try {
					dt5 = new SimpleDateFormat("MM/dd/yyyy").parse(date5);
					center5.setInspectiondate(dt5);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String date6 = "04/30/2019";
				Date dt6;
				try {
					dt6 = new SimpleDateFormat("MM/dd/yyyy").parse(date6);
					center6.setInspectiondate(dt6);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ArrayList<DayCareProviderModel> centers = new ArrayList<DayCareProviderModel>();
				centers.add(center1);
				centers.add(center2);
				centers.add(center3);
				centers.add(center4);
				centers.add(center5);
				centers.add(center6);
				
				String insDate = "04/01/2019";
				Date ins;
				try {
					ins = new SimpleDateFormat("MM/dd/yyyy").parse(insDate);
					DayCareGenie dcg = new DayCareGenie(centers);
					ArrayList<DayCareProviderModel> results = dcg.getDayCaresByZipcode("12345", ins);
					
					// size of results should be 2
					// those centers are Center 3 and Center 5
					assertEquals(results.size(), 2);
					assertEquals(results.contains(center3), true);
					assertEquals(results.contains(center5), true);
				} catch(ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
	}

}
