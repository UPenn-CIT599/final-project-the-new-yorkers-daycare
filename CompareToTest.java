import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class CompareToTest {

	@Test
	void test() {
		/**
		 * This JUnit test tests the compareTo method of the DayCareProviderModel class.
		 * 
		 * The program access the inspection records of NYC's day care centers, and each 
		 * inspection record is used to build a DayCareProviderModel object.
		 * 
		 * Other methods in the program require that these records (i.e., DayCareProviderModel
		 * objects) be sorted by their inspection date, from most to least recent.
		 * 
		 * Therefore, DayCareProviderModel implements Comparable and overrides the
		 * compareTo method.
		 * 
		 * This JUnit test builds 2 toy DayCareProviderModel objects and tests 
		 * the compareTo method of the DayCareProviderModel class.
		 */
		
		DayCareProviderModel center1 = new DayCareProviderModel();
		DayCareProviderModel center2 = new DayCareProviderModel();
		
		String d1 = "04/03/2019";
		String d2 = "04/04/2019";
		
		try {
			Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(d1);
			Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(d2);
			center1.setInspectiondate(date1);
			center2.setInspectiondate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// center2 has a more recent inspection date, so when the
		// compareTo method is called on center1 (with center 2 as its
		// argument), it should return 1
		int comparison = center1.compareTo(center2);
		assertEquals(comparison, 1);
		
		
	}

}
