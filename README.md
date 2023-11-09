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

---