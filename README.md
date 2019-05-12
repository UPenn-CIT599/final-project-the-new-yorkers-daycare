# final-project-the-new-yorkers-daycare
final-project-the-new-yorkers-daycare created by GitHub Classroom
By: Anna Jones, Steve Wang, Xiaoya Huang

This project helps New York families find the best child care providers (within a specified zip code and for a specified child care type--e.g., Preschool, Infant/Toddler, School-based programs, or camps). We use New York City’s Department of Health and Mental Hygiene’s database of day care center inspection records to determine which centers have the lowest rates of violations. We believe this will greatly reduce the time spent in researching for a suitable service based on verbal recommendations or Google search that does not sort the options via area more efficiently. 

How to Run the Program

Download the program files (although the JUnit tests are not necessary) and the nycZipcodes file.
Then run the "Main.java" file (i.e., Main class).
The program will then ask you for your zipcode and type of child care sought and return a list of recommended choices.

Overview of Program

Retreive Data

The dataset we used is New York City’s Department of Health and Mental Hygiene’s database of day care center inspection records, which is available through NYC’s Open Data website (https://opendata.cityofnewyork.us/). This data is retrieved by the DataRetriever class, which returns a string. When retrieving the data, we have to specify the number of data/set limit parameter we wish to be retrieved, otherwise, it fetches only 1000.

Process Data

In the next step, the DataParser class processes the string outputted by DataRetriever into a JSONArray. DataParser then loops through the JSONArray and for each JSONArray, extracts the attributes of each inspection record to create a DayCareProviderModel object, which is then stored in an ArrayList. We account for missing data by using an ‘if’ condition to store a DayCareProviderModel object in the ArrayList, only if it includes all of the necessary data.

Get User Input
	Next, we ask the user to enter his or her zip code (a proxy for the neighborhood where they are search for day care options). We then ask the user to provide the type of day care sought--Preschool, Infant/Toddlers, School-based programs, or camp.

Build Recommendation Engine

The bulk of the work here is done by two classes.

First, DayCareGenie extracts the most recent inspection records for day care centers within the user’s zipcode that provide the type of day care sought. This data is stored in a HashMap that maps each day care center name to its most recent inspection record.

Next, Recommender users this HashMap to partition all of the centers with the desired zip code and child care type into three categories (each stored in an ArrayList): Green Centers, Yellow Centers, and Red Centers.
	
In partitioning the centers, Recommender focuses on three fields:

ViolationRatePercent: the percent of initial inspections of that center that resulted in at least one public health hazard or critical violation

PublicHealthHazardViolationRate: the percent of Public Health Hazard violations among all violations issued at initial inspections of that center during the past 3 years. Public Health Hazard Violations are the most serious violations and must be remedied within 24 hours of a citation.

CriticalViolationRate: the percent of Critical violations among all violations issued at initial inspections of that center during the past 3 years. Critical violations must be remedied within 2 weeks. Examples of Critical violations include fire escape drill logs that are not up to date or bathrooms that are not properly maintained.

For each center, Recommender compares each center’s violation rate in each category to the citywide average violation rate that category. If a center’s violation rates are lower than the citywide average in all three categories, it earns a Green rating; if a center’s violation rates are lower than the citywide average in two categories, it earns a Yellow rating; otherwise, it earns a Red rating.

Provide recommendation based on user requirements

Next, we provide our recommendations to the user.

If there are any Green centers for that zip code and that type of child care, we present the names, address, phone number, and website for those centers.

If there are no Green centers for that zip code and that type of child care, we present the names, address, phone number, and website of the Yellow centers.

If there are no Green or Yellow centers, we advise the user that there are no adequate child care centers within that zip code that offer the desired type of child care.

We then present the user with the option to search again.

Program Classes

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

8. Class name: DataParserTester by Steve Wang
JUnit test for DataParser; confirms that it properly builds an ArrayList of DayCareProviderModels when a JSONArray 
is passed to it

9. Class name: YellowCenterTester by Steve Wang
JUnit test to ensure that Recommender class returns Yellow-rated day care centers (i.e., adequate day care centers, but not 
the best ones in the city)

10. Class name: RedCenterTester by Steve Wang
JUnit test to ensure that Recommender class returns Red-rated day care centers (i.e., day care centers with unacceptably high violation rates)

11. Class name: AssignRatingsTester by Steve Wang
JUnit test for the assignRatings method in Recommender class

12. Class name: ZipcodeAndDateTester by Steve Wang
JUnit test for the getDayCaresByZipcode(String, Date) method of the DayCareGenie class.

13. Class name: CompareToTest by Steve Wang
JUnit test for the compareTo method of the DayCareProviderModel class.

14. Class name: TransChildCareTypeTester by Steve Wang
JUnit test for the transChildcareType method of the userInput class.

15. Class name: ValidChildCareTester by Steve Wang
JUnit test for the isValidChildcareType method of the userInput class.
