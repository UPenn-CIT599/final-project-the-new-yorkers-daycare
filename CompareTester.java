import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompareTester {

	@Test
	void test() {
		/*
		 * JUnit test to test the compareAgainstCityAverage method of
		 * the Recommender class
		 * 
		 * compareAgainstCityAverage compares a day care center's
		 * violation rate for a given category against the citywide average
		 * violation rate for that same category. 
		 * 
		 * If a day care center's violation rate for a given category is 0%, 
		 * or if it is lower than the citywide average violatin rate, the 
		 * method returns 1. Otherwise, it returns a 0.
		 */
		
		// create a Recommender object
		Recommender r = new Recommender();
		int zeroViolation = r.compareAgainstCityAverage(0, 0.05);
		int lowViolation = r.compareAgainstCityAverage(0.10, 0.50);
		int highViolation = r.compareAgainstCityAverage(0.50, 0.30);
		
		// zeroViolation and lowViolation should be 1; highViolation should be 0
		assertEquals(zeroViolation, 1);
		assertEquals(lowViolation, 1);
		assertEquals(highViolation, 0);
		
	}

}
