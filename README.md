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

### SQLite Table Creation
<img width="1680" alt="tableCreation" src="https://github.com/dalamo20/viva-ventura/assets/35320043/7464e0d1-0188-4f28-8030-66903a0c82ee">
- By calling CreateTable.createNewTable() in my Driver class, I was able to generate all tables in CreateTable class.
- It then defines SQL statements to create several tables (itinerary, activity, location, profile, subscription, and user) with specific columns and foreign key relationships. 
- It executes these SQL statements to create the tables in the SQLite database, handling potential SQL exceptions by printing error messages to the console.

### SQLite Insert Into Table
<img width="1680" alt="insertTable" src="https://github.com/dalamo20/viva-ventura/assets/35320043/dea43202-bdbf-4698-adf2-8e6114256eea">
- InsertRecord class provides methods for inserting records into various tables (itinerary, activity, location, profile, subscription, and user) using parameterized SQL statements. 
- The getProfileId and getSubscriptionId private methods generate random IDs for the profile and subscription tables. 
- It handles potential SQL exceptions by printing error messages to the console.

### SQLite Select ALL Tables
<img width="1680" alt="selectTables" src="https://github.com/dalamo20/viva-ventura/assets/35320043/59921aa8-d136-4991-a89a-b5a84786320b">
- In SelectRecord class, the selectAll method retrieves metadata about all tables in the database using the DatabaseMetaData class. 
- It iterates through each table, printing its name and column names. 
- For each table, it executes a SELECT * query to fetch and display all data in that table, printing the results to the console. 
- The code handles potential SQL exceptions by printing error messages to the console.

### SQLite MORE METHODS TO COME... 

---