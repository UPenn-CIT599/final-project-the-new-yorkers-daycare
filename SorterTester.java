import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

class SorterTester {

	@Test
	void test() {
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
		
		String c1date = "02/13/2019";
		String c2date = "04/23/2018";
		String c3date = "05/01/2017";
		String c4date = "08/30/2019";
		String c5date = "09/08/2017";
		String c6date = "11/12/2018";
		
		try {
			Date c1insDate = new SimpleDateFormat("MM/dd/yyyy").parse(c1date);
			Date c2insDate = new SimpleDateFormat("MM/dd/yyyy").parse(c2date);
			Date c3insDate = new SimpleDateFormat("MM/dd/yyyy").parse(c3date);
			Date c4insDate = new SimpleDateFormat("MM/dd/yyyy").parse(c4date);
			Date c5insDate = new SimpleDateFormat("MM/dd/yyyy").parse(c5date);
			Date c6insDate = new SimpleDateFormat("MM/dd/yyyy").parse(c6date);
			
			center1.setInspectiondate(c1insDate);
			center2.setInspectiondate(c2insDate);
			center3.setInspectiondate(c3insDate);
			center4.setInspectiondate(c4insDate);
			center5.setInspectiondate(c5insDate);
			center6.setInspectiondate(c6insDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String, DayCareProviderModel> centers = new HashMap<String, DayCareProviderModel>();
		centers.put("Center 1", center1);
		centers.put("Center 2", center2);
		centers.put("Center 3", center3);
		centers.put("Center 4", center4);
		centers.put("Center 5", center5);
		centers.put("Center 6", center6);
		
		for (String c : centers.keySet()) {
			centers.get(c).setViolationAvgRatePercent(0.37);
			centers.get(c).setAveragePublicHealthHazardViolationRate(0.23);
			centers.get(c).setAvgCriticalViolationRate(0.19);
		}
		
		// instantiate Recommender object
		Recommender r = new Recommender();
		r.assignRatings(centers);
		

		r.sortByInspectionDate();
		ArrayList<DayCareProviderModel> redCenters = r.getRedCenters();
		assertEquals(redCenters.get(0).getCenterName(), "Center 1");
		
	}

}
