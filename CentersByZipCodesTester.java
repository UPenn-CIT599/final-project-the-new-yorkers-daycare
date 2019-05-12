import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class CentersByZipCodesTester {

	@Test
	void test() {
		/**
		 * This JUnit test tests the getDayCaresByZipcode method of the DayCareGenie class.
		 * 
		 * It creates a toy ArrayList of DayCareProviderModel objects and should return an 
		 * ArrayList of only those objects with the zipcode 12345. This ArrayList should be
		 * size 2.
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
		
		center1.setZipcode("11106");
		center2.setZipcode("11215");
		center3.setZipcode("12345");
		center4.setZipcode("10007");
		center5.setZipcode("12345");
		center6.setZipcode("10305");
		
		ArrayList<DayCareProviderModel> centers = new ArrayList<DayCareProviderModel>();
		centers.add(center1);
		centers.add(center2);
		centers.add(center3);
		centers.add(center4);
		centers.add(center5);
		centers.add(center6);
		
		// test method
		// there should be 2 centers with the zip code 12345
		DayCareGenie dcg = new DayCareGenie(centers);
		ArrayList<DayCareProviderModel> result = dcg.getDayCaresByZipcode("12345");
		assertEquals(result.size(), 2);
	}

}
