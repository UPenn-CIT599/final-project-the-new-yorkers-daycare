import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class userInput {

	/*
	 * In order to customize our recommendation to each user, we need to know the
	 * area (zipcode) they are looking for and the age of their kids to begin with.
	 * And this class will process all the input we get from the user, including
	 * handling all invalid inputs
	 */

	private String zipcode;
	private int childAge;

	public String getZipcode() {
		return zipcode;
	}

	public int getChildAge() {
		return childAge;
	}

	boolean isValidZipcode(String zipcode) {
		/*
		 * This function checks whether the user-inputed zipcode is a valid zipcode
		 * TODO: building the following 2 check rules 1. the string contains 5 numbers
		 * 2. this is a zipcode in NYC area (check it against a complete list of NYC
		 * zipcodes)
		 */
		File nycZipcodes = new File("nycZipcodes");
		try {
			String zip = "";
			Scanner scanner = new Scanner(nycZipcodes);
			while(scanner.hasNextLine()) {
				zip = scanner.nextLine();
				if(zipcode.equals(zip.substring(0, 5))) {
					scanner.close();
					return true; 
				}
			}
			scanner.close();
			return false; 
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file, try again.");
			return false; 
		}  
		
	}

	boolean isValidChildAge(int childAge) {
		/*
		 * This function checks whether the user-inputed child age is a valid child age
		 * between 0-18. TODO: building the below 2 check rules 1. the input is an
		 * integer 2. the input is an integer between 0-18
		 */
		if(childAge>=0 && childAge <18) {
			return true;
		}else {
			return false; 
		}
		
	};

	void getUserInput() {
		// Asking user for the zipcode input
		Scanner scanner = new Scanner(System.in);
		System.out.println("In which area are you looking for a childcare? Please enter a valid zipcode in NYC.");

		while (true) {
			String zipcode = scanner.nextLine();
			if (isValidZipcode(zipcode)) {
				this.zipcode = zipcode;
				break;
			}
			System.out.println("This is not an valid zipcode in NYC, please enter again.");
		}
		// Asking user for the child age input
		System.out.println("What's the age of your child?");
		while (true) {
			try {
				String userChildAgeSting = scanner.nextLine();
				int userChildAge = Integer.parseInt(userChildAgeSting);
				if (isValidChildAge(userChildAge)) {
					this.childAge = userChildAge;
					break;
				}
			} catch (NumberFormatException e) {
				// Ask the user to try again using the printout line below. 
			}
			System.out.println("This is not a valid child age, please enter a number between 0-18.");		
		}
		scanner.close();
	}

	// Keep a main function here for testing purposes, will consolidate with the
	// project's main function later
//	public static void main(String[] args) {
//		userInput testing = new userInput();
//		testing.getUserInput();
//		System.out.println(testing.childAge + "\n" + testing.zipcode);
//	}

}
