import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class MostRecentInspectionsTester {

	@Test
	void test() {
		/**
		 * This JUnit test tests the getMostRecentInspections method of the DayCareGenie class.
		 * 
		 * It creates a toy ArrayList of DayCareProviderModel objects and should return a 
		 * HashMap of the most recent inspection for each center found in the ArrayList.
		 * 
		 * For the toy ArrayList, there will be a total of six centers (i.e., 2 inspections each)
		 * and the most recent inspection dates for each center will
		 * be after March 2019.
		 */
		
		// instantiate toy ArrayList of DayCareProviderModel objects
		DayCareProviderModel inspection1 = new DayCareProviderModel();
		DayCareProviderModel inspection2 = new DayCareProviderModel();
		DayCareProviderModel inspection3 = new DayCareProviderModel();
		DayCareProviderModel inspection4 = new DayCareProviderModel();
		DayCareProviderModel inspection5 = new DayCareProviderModel();
		DayCareProviderModel inspection6 = new DayCareProviderModel();
		DayCareProviderModel inspection7 = new DayCareProviderModel();
		DayCareProviderModel inspection8 = new DayCareProviderModel();
		DayCareProviderModel inspection9 = new DayCareProviderModel();
		DayCareProviderModel inspection10 = new DayCareProviderModel();
		DayCareProviderModel inspection11 = new DayCareProviderModel();
		DayCareProviderModel inspection12 = new DayCareProviderModel();
		
		String date1 = "11/02/2017";
		Date dt1;
		try {
			dt1 = new SimpleDateFormat("MM/dd/yyyy").parse(date1);
			inspection1.setCenterName("Center 1");
			inspection1.setInspectiondate(dt1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date2 = "05/02/2019";
		Date dt2;
		try {
			dt2 = new SimpleDateFormat("MM/dd/yyyy").parse(date2);
			inspection2.setCenterName("Center 1");
			inspection2.setInspectiondate(dt2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date3 = "08/23/2018";
		Date dt3;
		try {
			dt3 = new SimpleDateFormat("MM/dd/yyyy").parse(date3);
			inspection3.setCenterName("Center 2");
			inspection3.setInspectiondate(dt3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date4 = "04/18/2019";
		Date dt4;
		try {
			dt4 = new SimpleDateFormat("MM/dd/yyyy").parse(date4);
			inspection4.setCenterName("Center 2");
			inspection4.setInspectiondate(dt4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date5 = "03/11/2019";
		Date dt5;
		try {
			dt5 = new SimpleDateFormat("MM/dd/yyyy").parse(date5);
			inspection5.setCenterName("Center 3");
			inspection5.setInspectiondate(dt5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date6 = "04/30/2019";
		Date dt6;
		try {
			dt6 = new SimpleDateFormat("MM/dd/yyyy").parse(date6);
			inspection6.setCenterName("Center 3");
			inspection6.setInspectiondate(dt6);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date7 = "02/14/2019";
		Date dt7;
		try {
			dt7 = new SimpleDateFormat("MM/dd/yyyy").parse(date7);
			inspection7.setCenterName("Center 4");
			inspection7.setInspectiondate(dt7);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date8 = "05/27/2019";
		Date dt8;
		try {
			dt8 = new SimpleDateFormat("MM/dd/yyyy").parse(date8);
			inspection8.setCenterName("Center 4");
			inspection8.setInspectiondate(dt8);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date9 = "12/25/2017";
		Date dt9;
		try {
			dt9 = new SimpleDateFormat("MM/dd/yyyy").parse(date9);
			inspection9.setCenterName("Center 5");
			inspection9.setInspectiondate(dt9);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date10 = "04/01/2019";
		Date dt10;
		try {
			dt10 = new SimpleDateFormat("MM/dd/yyyy").parse(date10);
			inspection10.setCenterName("Center 5");
			inspection10.setInspectiondate(dt10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date11 = "09/13/2018";
		Date dt11;
		try {
			dt11 = new SimpleDateFormat("MM/dd/yyyy").parse(date11);
			inspection11.setCenterName("Center 6");
			inspection11.setInspectiondate(dt11);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String date12 = "04/05/2019";
		Date dt12;
		try {
			dt12 = new SimpleDateFormat("MM/dd/yyyy").parse(date12);
			inspection12.setCenterName("Center 6");
			inspection12.setInspectiondate(dt12);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<DayCareProviderModel> centers = new ArrayList<DayCareProviderModel>();
		centers.add(inspection1);
		centers.add(inspection2);
		centers.add(inspection3);
		centers.add(inspection4);
		centers.add(inspection5);
		centers.add(inspection6);
		centers.add(inspection7);
		centers.add(inspection8);
		centers.add(inspection9);
		centers.add(inspection10);
		centers.add(inspection11);
		centers.add(inspection12);
		
		// test method
		// there should be 2 centers with the zip code 12345
		DayCareGenie dcg = new DayCareGenie(centers);
		HashMap<String, DayCareProviderModel> result = dcg.getMostRecentInspections(centers);
		String March312019 = "03/31/2019";
		Date M312019;
		try {
			M312019 = new SimpleDateFormat("MM/dd/yyyy").parse(March312019);
			for (String center : result.keySet()) {
				assertEquals(result.get(center).getInspectiondate().after(M312019), true);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
