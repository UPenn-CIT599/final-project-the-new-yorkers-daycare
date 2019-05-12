import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidZipCodeTester {

	@Test
	void test() {
		/**
		 * This JUnit test tests the isValidZipcode method of the UserInput class.
		 * 
		 * We create an UserInput object and call the method on the
		 * following zip codes: 11106, 10024, and 95070
		 * 
		 * The method should return true for the first two zip codes 
		 * and false for the last one.
		 */
		
		userInput ui = new userInput();
		boolean z1 = ui.isValidZipcode("11106");
		boolean z2 = ui.isValidZipcode("10024");
		boolean z3 = ui.isValidZipcode("95070");
		
		assertEquals(z1, true);
		assertEquals(z2, true);
		assertEquals(z3, false);
	}

}
