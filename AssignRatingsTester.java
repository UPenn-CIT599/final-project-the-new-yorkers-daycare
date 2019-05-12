import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class AssignRatingsTester {

	@Test
	void test() {
		/*
		 * JUnit test for the assignRatings method in Recommender class
		 * 
		 * First, the test creates a number of DayCareProviderModel objects and
		 * puts them into a HashMap (center name --> centers).
		 * 
		 * Next, we instantiate a Recommender object and call the assignRatings
		 * method, passing the HashMap to it
		 * 
		 * The best day care centers are stored in the GreenCenters ArrayList.
		 * This should have a size of 2: Carol's Day Care and Ella's Day Care
		 * 
		 * The second tier of day care centers are stored in the YellowCenters
		 * ArrayList. This should have a size of 3: Adam's Day Care, 
		 * Betty's Day Care, and Fred's Day Care
		 * 
		 * The worst day care centers are stored in the RedCenters ArrayList.
		 * This should have a size of 1: Dave's Day Care
		 */
		// create DayCareProviderModel objects
		// add to ArrayList centers
				
				DayCareProviderModel AdamsDayCare = new DayCareProviderModel();
				DayCareProviderModel BettysDayCare = new DayCareProviderModel();
				DayCareProviderModel CarolsDayCare = new DayCareProviderModel();
				DayCareProviderModel DavesDayCare = new DayCareProviderModel();
				DayCareProviderModel EllasDayCare = new DayCareProviderModel();
				DayCareProviderModel FredsDayCare = new DayCareProviderModel();
				
				AdamsDayCare.setCenterName("Adam's Day Care");
				BettysDayCare.setCenterName("Betty's Day Care");
				CarolsDayCare.setCenterName("Carol's Day Care");
				DavesDayCare.setCenterName("Dave's Day Care");
				EllasDayCare.setCenterName("Ella's Day Care");
				FredsDayCare.setCenterName("Fred's Day Care");
				
				AdamsDayCare.setViolationRatePercent(0.56);
				BettysDayCare.setViolationRatePercent(0.32);
				CarolsDayCare.setViolationRatePercent(0.28);
				DavesDayCare.setViolationRatePercent(0.45);
				EllasDayCare.setViolationRatePercent(0.17);
				FredsDayCare.setViolationRatePercent(0.08);
				
				AdamsDayCare.setPublicHealthHazardViolationRate(0.09);
				BettysDayCare.setPublicHealthHazardViolationRate(0.43);
				CarolsDayCare.setPublicHealthHazardViolationRate(0.18);
				DavesDayCare.setPublicHealthHazardViolationRate(0.67);
				EllasDayCare.setPublicHealthHazardViolationRate(0.06);
				FredsDayCare.setPublicHealthHazardViolationRate(0.14);
				
				AdamsDayCare.setCriticalViolationRate(0.15);
				BettysDayCare.setCriticalViolationRate(0.12);
				CarolsDayCare.setCriticalViolationRate(0.12);
				DavesDayCare.setCriticalViolationRate(0.21);
				EllasDayCare.setCriticalViolationRate(0.05);
				FredsDayCare.setCriticalViolationRate(0.23);
				
				HashMap<String, DayCareProviderModel> centers = new HashMap<String, DayCareProviderModel>();
				centers.put(AdamsDayCare.getCenterName(), AdamsDayCare);
				centers.put(BettysDayCare.getCenterName(), BettysDayCare);
				centers.put(CarolsDayCare.getCenterName(), CarolsDayCare);
				centers.put(DavesDayCare.getCenterName(), DavesDayCare);
				centers.put(EllasDayCare.getCenterName(), EllasDayCare);
				centers.put(FredsDayCare.getCenterName(), FredsDayCare);
				
				for (String c : centers.keySet()) {
					centers.get(c).setViolationAvgRatePercent(0.37);
					centers.get(c).setAveragePublicHealthHazardViolationRate(0.23);
					centers.get(c).setAvgCriticalViolationRate(0.19);
				}
				
				// instantiate Recommender object
				Recommender r = new Recommender();
				r.assignRatings(centers);
				
				// extract r's GreenCenters ArrayList
				// should contain 2 centers 
				// Carol and Ella
				
				ArrayList<DayCareProviderModel> green = r.getGreenCenters();
				assertEquals(green.size(), 2);
				assertEquals(green.contains(CarolsDayCare), true);
				assertEquals(green.contains(EllasDayCare), true);
				
				// extract r's Yellow Centers ArrayList
				// should contain 3 centers 
				// Adam, Betty, and Fred
				
				ArrayList<DayCareProviderModel> yellow = r.getYellowCenters();
				assertEquals(yellow.size(), 3);
				assertEquals(yellow.contains(AdamsDayCare), true);
				assertEquals(yellow.contains(BettysDayCare), true);
				assertEquals(yellow.contains(FredsDayCare), true);
				
				// extract r's Red Centers ArrayList
				// should contain 1 center
				// Dave
				
				ArrayList<DayCareProviderModel> red = r.getRedCenters();
				assertEquals(red.size(), 1);
				assertEquals(red.contains(DavesDayCare), true);
				
	}

}
