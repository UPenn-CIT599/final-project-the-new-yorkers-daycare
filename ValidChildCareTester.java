import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidChildCareTester {

	@Test
	void test() {
		/**
		 * This JUnit test tests the isValidChildcareType method of the userInput class.
		 * 
		 * userInput asks the user for the type of child care sought, presenting a
		 * numbered menu of options:
		 * 
		 * 1. Child Care - Pre School
		 * 2. Child Care - Infants/Toddlers
		 * 3. School Based Child Care
		 * 4. Camp
		 * 
		 * This method ensures that the user inputs a valid choice.
		 */
		
		userInput ui = new userInput();
		
		boolean test0 = ui.isValidChildcareType(0);
		boolean test1 = ui.isValidChildcareType(1);
		boolean test2 = ui.isValidChildcareType(2);
		boolean test3 = ui.isValidChildcareType(3);
		boolean test4 = ui.isValidChildcareType(4);
		boolean test5 = ui.isValidChildcareType(5);
		boolean test6 = ui.isValidChildcareType(-1);
		
		assertEquals(test0, false);
		assertEquals(test1, true);
		assertEquals(test2, true);
		assertEquals(test3, true);
		assertEquals(test4, true);
		assertEquals(test5, false);
		assertEquals(test6, false);
	}

}
