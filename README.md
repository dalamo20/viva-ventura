# Viva Ventura

## Introduction

Viva Ventura is more than just an itinerary app, it's your ultimate travel companion. Whether you're planning a relaxing getaway or embarking on an adventurous journey, Viva Ventura empowers you to create and manage detailed itineraries for your trips. Say goodbye to the hassle of disorganized travel plans and hello to a more enjoyable travel experience.

## Key Features

- **Detailed Itinerary**: Create and manage detailed itineraries, including reservations, flights, activities, and more.

- **Organization**: Keep your travel plans organized with times and dates for all your activities.

- **Perfect for Digital Nomads**: Ideal for digital nomads and travel bloggers who want to document their adventures.

- **Customization**: Tailor your itineraries to your unique travel style.

## Why Viva Ventura?

- Tired of disorganized travel plans? Viva Ventura helps you stay on top of your travel itinerary, making every trip unforgettable.

- Whether you're a solo traveler, a couple, or a family, Viva Ventura is designed for everyone.

## JUnit Tests for Domains
### User Tests (Email & Password Tests)
<img width="1061" alt="userTest" src="https://github.com/dalamo20/viva-ventura/assets/35320043/dbe0636d-a575-4726-a805-34fd4cadb1a3">

- validateValidEmail tests a variation of emails that are valid.
- validateInvalidEmail tests a variation of emails that are invalid.
- validateValidPassword tests possible passwords that are valid.
- validateInvalidPassword tests possible passwords that are invalid.

## JUnit Tests for Services
### Login Service Tests
<img width="1016" alt="loginService" src="https://github.com/dalamo20/viva-ventura/assets/35320043/abfdf1ce-7df3-4491-abee-e157f05043be">
- authenticateUser checks whether the user is authenticated.

### User Service Tests
<img width="994" alt="userService" src="https://github.com/dalamo20/viva-ventura/assets/35320043/eba1db9b-f4a3-4d4c-823f-7b71d1ee3e03">

- createUser creates a user and stores them in an arraylist.
- getUserByUsername finds a user by username.
- updateUser updates the user information.
- deleteUser deletes the user from the arrayList.

### Itinerary Service Tests
<img width="1676" alt="itineraryService" src="https://github.com/dalamo20/viva-ventura/assets/35320043/acee6629-4a86-4cbd-b77e-9c0673b713a5">

- createItinerary() creates an instance of Itinerary, adds it to the ItineraryService, and returns true if the service contains the created itinerary.
- getItinerary() retrieves an itinerary using an itinerary's name from the ItineraryService and checks if it exists. 
- getAllItineraries() checks the list of itineraries is not null.
- updateItinerary() updates an existing itinerary.
- deleteItinerary() deletes an itinerary by its name. 


## WEEK 4 
<img width="1438" alt="serviceFactoryTest2" src="https://github.com/dalamo20/viva-ventura/assets/35320043/c83fb5ac-546a-4485-83d6-4c73138b4d66">

- Here I am utilizing the getImplName method from ServiceFactory to read the implementation class name from the application.properties file and then dynamically loads the class using reflection.
- The unit tests confirm that I am dynamically loading the implementation class. 

## WEEK 5
### Unit Test for CompositeServiceImplTest 
<img width="1680" alt="compositeImpl" src="https://github.com/dalamo20/viva-ventura/assets/35320043/89a4f924-b81e-4e13-a098-093234c1215e">

- Here are tests that I am running on my composite service class that performs CRUD operations on Itineraries and Activities inside the itinerary. 
- This is an example of updating an existing itinerary. 
- A User is created, then the list of Activities.
- The itinerary is then named and the list of Activities are stored in it. 
- An itinerary composite is created storing the user information and itinerary. 
- The method then goes on showing an example of how I can update the name of the existing itinerary.

### Unit Test for LoginServiceImplTest
<img width="1678" alt="LoginServiceImplTest" src="https://github.com/dalamo20/viva-ventura/assets/35320043/54b6cf53-4c65-4c11-9d3f-e97c7619407e">

- Here I am testing the LoginServiceImplTest service class with the new PropertyManger.
- The manager class is responsible for loading the property file into memory and make it available for all other classes to use.
- The tests shows that my file is loaded and that the authenticateCustomer method works accordingly.

### Presentation Layer
<img width="1677" alt="driverSuccess" src="https://github.com/dalamo20/viva-ventura/assets/35320043/df5fc690-4044-4ef8-bde7-3915bbf144a3">

- Here I was able to instantiate and configure the composite object and pass it to a service.

## WEEK 6
### SQLite Create Database
<img width="1680" alt="createDB" src="https://github.com/dalamo20/viva-ventura/assets/35320043/61f6798a-677c-4a66-8c4b-f363d343a492">

- Using createNewDatabase(String fileName) from CreateDB class, I was able to create vivaventura.db
- The call was executed in the Driver class. 

### SQLite Connection
<img width="1680" alt="connection" src="https://github.com/dalamo20/viva-ventura/assets/35320043/2d9f59f0-699c-4982-9afa-155cfb803994">

- To create a connection, I would create an instance of Connnect class and call connect(); 

### SQLite CREATE Table
<img width="1680" alt="tableCreation" src="https://github.com/dalamo20/viva-ventura/assets/35320043/7464e0d1-0188-4f28-8030-66903a0c82ee">

- By calling CreateTable.createNewTable() in my Driver class, I was able to generate all tables in CreateTable class.
- It then defines SQL statements to create several tables (itinerary, activity, location, profile, subscription, and user) with specific columns and foreign key relationships. 
- It executes these SQL statements to create the tables in the SQLite database, handling potential SQL exceptions by printing error messages to the console.

### SQLite INSERT Into Table
<img width="1680" alt="insertTable" src="https://github.com/dalamo20/viva-ventura/assets/35320043/dea43202-bdbf-4698-adf2-8e6114256eea">

- InsertRecord class provides methods for inserting records into various tables (itinerary, activity, location, profile, subscription, and user) using parameterized SQL statements. 
- The getProfileId and getSubscriptionId private methods generate random IDs for the profile and subscription tables. 
- It handles potential SQL exceptions by printing error messages to the console.

### SQLite SELECT ALL Tables
<img width="1680" alt="selectTables" src="https://github.com/dalamo20/viva-ventura/assets/35320043/59921aa8-d136-4991-a89a-b5a84786320b">

- In SelectRecord class, the selectAll method retrieves metadata about all tables in the database using the DatabaseMetaData class. 
- It iterates through each table, printing its name and column names. 
- For each table, it executes a SELECT * query to fetch and display all data in that table, printing the results to the console. 
- The code handles potential SQL exceptions by printing error messages to the console.

## WEEK 7
### SQLite SELECT ALL Table
<img width="1611" alt="selectSingleTable" src="https://github.com/dalamo20/viva-ventura/assets/35320043/abdf518d-5370-445c-8c13-c796d899ff0b">

- Different from the above SelectAll method, rather than printing all tables and their respective data, selectTable allows me to print a single table and its' records. 

### SQLite UPDATE Table
<img width="1680" alt="updateRecord" src="https://github.com/dalamo20/viva-ventura/assets/35320043/f695e51d-e697-43ea-86f1-a5d9e400f5be">

- The UpdateRecord class provides methods to update records in different tables of a SQLite database. 
- Each method corresponds to a specific table, such as itinerary, activity, location, profile, subscription, and user. 
- The methods take parameters representing the new values for the record and perform SQL UPDATE statements to modify the corresponding records in their respective tables based on the provided ID.

### SQLite DELETE from Table
<img width="1676" alt="deleteRecord" src="https://github.com/dalamo20/viva-ventura/assets/35320043/c485654a-0660-425e-a5af-ea85d5221421">

- DeleteRecord class deletes a record from a specified table in the SQLite database. 
- The deleteRecord method takes two parameters: the ID of the record to be deleted and the name of the table from which the record should be deleted. 

### JAVAFX & SceneBuilder (Itinerary Page)
<img width="1507" alt="javaSceneBuilder" src="https://github.com/dalamo20/viva-ventura/assets/35320043/626ed83a-1a37-4968-8164-9d9cf2362693">

- SceneBuilder assisted in helping me create the UI & controller for the Itierary Page. 
- Using the sample controller, I was able to create logic for 'Create Itinerary' and 'Delete Itinerary' button. 
- The image shows that the input appends to the view after clicking the 'Create' button.
- By clicking on the name inside the 'View Itineraries' view, I can then click the 'Delete' button to remove that row.

### JAVAFX & SceneBuilder (Activity Page)
<img width="1267" alt="activityPage" src="https://github.com/dalamo20/viva-ventura/assets/35320043/ab60bb6d-5f0c-436b-a8d9-d3376777fd1d">

- Using SceneBuilder, I created the Activity Page where the inputs would append to the tableView in their respective columns. 
- The image shows that my UI is visible and when I create an activity, a grid displays which is a good indicator that an object was created. 
- Unfortunately, there is a slight bug in the AddActivityController where the inputs are not appending to the tableView. 
- Other than that, I am able to click on the empty row and delete it with the 'Delete' button.

## WEEK 8
### JAVAFX ADD Activity
<img width="1667" alt="addActivity" src="https://github.com/dalamo20/viva-ventura/assets/35320043/f2ac325d-4b19-4d5c-a297-8886d08fecbf">

- The addActivity method in the AddActivityController adds a new activity to the database based on the input provided in the text fields (activity name, date, and time). 
- It establishes a connection to the database, prepares an SQL statement for insertion, executes the statement, refreshes the table view, and initiates a new search to update the displayed activities.

### JAVAFX UPDATE Activity
<img width="1676" alt="updateActivity" src="https://github.com/dalamo20/viva-ventura/assets/35320043/df80bc6a-2b75-49e2-ada9-4bf2102c9c0a">

- The updateActivity method in the AddActivityController updates the selected activity in the database with the modified information entered into the text fields (activity name, date, and time). 
- It establishes a connection, prepares an SQL update statement, executes the statement, refreshes the table view, and initiates a new search to reflect the changes.

### JAVAFX DELETE Activity
<img width="1643" alt="deleteActivity" src="https://github.com/dalamo20/viva-ventura/assets/35320043/928fd8c3-f1fc-4014-8842-92daf87db350">

- The deleteActivity method in the AddActivityController deletes the selected activity from the database. 
- It establishes a connection, prepares an SQL delete statement based on the selected activity's ID, executes the statement, refreshes the table view, and initiates a new search to update the displayed activities.

### JAVAFX FILTER Activity
<img width="1598" alt="filterActivity" src="https://github.com/dalamo20/viva-ventura/assets/35320043/87e4581c-572b-4ac1-af5a-ed52f5832218">

- The searchActivity method in the AddActivityController facilitates dynamic searching in the TableView. 
- It begins by setting up column-value factories to link table columns with properties in the Activity class. 
- The method initializes an ObservableList<Activity> called dataList by fetching all activities from the database. 
- It then creates a FilteredList<Activity> named filterList based on dataList, initially displaying all activities. 
- A listener on the search input detects changes and updates the filterList based on the entered search criteria. 
- The filtering logic compares the search input with each activity's name, date, and time in a case-insensitive manner. 
- Matches are retained in the filterList, and a SortedList<Activity> is created for sorting compatibility. 
- The table_activity is then updated to display the sorted and filtered data, providing users with an efficient search functionality for activities.

## MSSE 672 WEEK 1
### Added Log4J Library
<img width="733" alt="Screenshot 2024-01-21 at 1 59 01 PM" src="https://github.com/dalamo20/viva-ventura/assets/35320043/096df558-3771-43e6-b64d-b67098dd6251">

- All instances of System.out.println statements have been replaced with Log4j logging for improved code readability and maintainability.

---