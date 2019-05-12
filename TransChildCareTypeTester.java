import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransChildCareTypeTester {

	@Test
	void test() {
		/**
		 * This JUnit test tests the transChildcareType method of the userInput class.
		 * 
		 * userInput asks the user for the type of child care sought, presenting a
		 * numbered menu of options:
		 * 
		 * 1. Child Care - Pre School
		 * 2. Child Care - Infants/Toddlers
		 * 3. School Based Child Care
		 * 4. Camp
		 * 
		 * transChildcareType maps the number chosen by the user to the appropriate
		 * child care type. This choice is then used by other methods in other classes
		 * to extract relevant options for the user.
		 */
		
		userInput ui = new userInput();
		
		String test1 = ui.transChildcareType(1);
		String test2 = ui.transChildcareType(2);
		String test3 = ui.transChildcareType(3);
		String test4 = ui.transChildcareType(4);
		
		assertEquals(test1, "Child Care - Pre School");
		assertEquals(test2, "Child Care - Infants/Toddlers");
		assertEquals(test3, "School Based Child Care");
		assertEquals(test4, "Camp");
	}

}
