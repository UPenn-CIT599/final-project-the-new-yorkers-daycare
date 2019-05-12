# final-project-the-new-yorkers-daycare
final-project-the-new-yorkers-daycare created by GitHub Classroom

1. Class name: DataRetriever by Xiaoya H
Method: A class to access the public childcare center data through its API and download the file in JSON format; returns a string which is used by DataParser to create an ArrayList of DayCareProviderModel objects

2. Class name: JSONGetter by Steve W
This was an early attempt to learn to deal with JSON data. It won't be used in the final program.

3. Class name: Recommender by Steve W
Method: assignRatings: assigns a rating to each day care center, compareAgainstCityAverage: helper method for assignRatings, sortByInspectionRate: sorts inspection records from most to least recent

4. Class name: DataParser by Steve W
Methods: convertToJSONArray: takes data in string format (i.e., the data retrieved from the NYC Open Data Set by DataRetriever class) and converts it into a JSONArray, createInspectionsArrayList: Iterates through JSONArray and extracts the data from each JSONObject to create a DayCareProviderModel object representing the outcome of each inspection

5. Class name: DayCareProviderModel by Anna J
Method: Getters and setters for variables in the dataset

6. Class name: DayCareGenie by Anna J
Method: getDayCaresByZipcode that pass in String zipcode and/or Date inspectionDate

7. Class name: Main (shared class)
Method: main method to run the program. Briefly, the sequence is as follows:
A. Creates a DataRetriever object to download the data from the NYC Open Data site
B. Creates a DataParser object to process this data and store it in an ArrayList of DayCareModelProvider object
C. Creates an UserInput object to get zipcode and type of daycare sought from user
D. Creates a DayCareGenie object to select the most recent inspection records for day care centers in the desired zipcode that offer the desired type of daycare
E. Creates a Recommender object to evaluate those day care centers
F. Reports the results to the user
G. Asks the user if he or she would like to conduct another search; if yes, then the process repeats from Step C

8. Class name: userInput by Xiaoya H
Method: isValidZipcode - to validate the zipcode that user enters
is validChildAge - to validate the child age that user enters
getUserInput - to communicate with user to get the valid inputs (zipcode, child age)
continueSearch - asks user if he or she would like to search again

JUnit Tests
1. Class name: RecommenderTester by Steve Wang
Method: Junit test that creates a toy HashMap of DayCareProviderModel objects and uses that to test the assignRatings method of the Recommender class

2. Class name: SorterTester by Steve Wang
JUnit test for sortByInspectionDate method of Recommender class

3. Class name: CompareTester by Steve Wang
JUnit test to test the compareAgainstCityAverage method ofthe Recommender class

4. Class name: CentersByZipCodesTester by Steve Wang
JUnit test for the getDayCaresByZipcode method of the DayCareGenie class.

5. Class name: CentersByTypeTester by Steve Wang
JUnit test for the getDayCaresByChildcareType method of the DayCareGenie class.

6. Class name: MostRecentInspectionsTester by Steve Wang
JUnit test for the getMostRecentInspections method of the DayCareGenie class.

7. Class name: ValidZipCodeTester by Steve Wang
JUnit test for the isValidZipCode method of the userInput class.
