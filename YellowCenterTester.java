import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class YellowCenterTester {

	@Test
	void test() {
		/**
		 * JUnit test to ensure that Recommender class returns 
		 * Yellow-rated day care centers
		 * 
		 * The program returns the Green-rated day care centers within a zip code
		 * for a given type of child care. Green-rated centers are the centers with 
		 * the best inspection records.
		 * 
		 * However, some times, there are no Green-rated day care centers within a zip code
		 * for a given type of child care. In this case, the program returns Yellow-rated
		 * centers, which are centers with lower violation rates than the citywide average 
		 * in 2 out of 3 categories.
		 * 
		 * This JUnit test uses a toy dataset of day care centers to ensure that the
		 * yellow-rated centers are properly stored in an ArrayList.
		 * 
		 * There should be 3 yellow-rated centers in the ArrayList: Center 2, Center 3,
		 * and Center 6
		 */
		
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
		
		center1.setViolationRatePercent(0.56);
		center2.setViolationRatePercent(0.32);
		center3.setViolationRatePercent(0.38);
		center4.setViolationRatePercent(0.15);
		center5.setViolationRatePercent(0.73);
		center6.setViolationRatePercent(0.08);
		
		center1.setPublicHealthHazardViolationRate(0.90);
		center2.setPublicHealthHazardViolationRate(0.13);
		center3.setPublicHealthHazardViolationRate(0.18);
		center4.setPublicHealthHazardViolationRate(0.11);
		center5.setPublicHealthHazardViolationRate(0.67);
		center6.setPublicHealthHazardViolationRate(0.24);
		
		center1.setCriticalViolationRate(0.59);
		center2.setCriticalViolationRate(0.33);
		center3.setCriticalViolationRate(0.12);
		center4.setCriticalViolationRate(0.15);
		center5.setCriticalViolationRate(0.55);
		center6.setCriticalViolationRate(0.18);
		
		HashMap<String, DayCareProviderModel> centers = new HashMap<String, DayCareProviderModel>();
		centers.put("center1", center1);
		centers.put("center2", center2);
		centers.put("center3", center3);
		centers.put("center4", center4);
		centers.put("center5", center5);
		centers.put("center6", center6);
		
		for (String c : centers.keySet()) {
			centers.get(c).setViolationAvgRatePercent(0.37);
			centers.get(c).setAveragePublicHealthHazardViolationRate(0.23);
			centers.get(c).setAvgCriticalViolationRate(0.19);
		}
		
		// instantiate Recommender object
		Recommender r = new Recommender();
		r.assignRatings(centers);
		
		// extract r's YellowCenters ArrayList
		// should contain 3 centers:
		// center2, center3, and center6
		
		ArrayList<DayCareProviderModel> Yellow = r.getYellowCenters();
		assertEquals(Yellow.size(), 3);
		assertEquals(Yellow.contains(center2), true);
		assertEquals(Yellow.contains(center3), true);
		assertEquals(Yellow.contains(center6), true);
	}

}
