This is a small user app for a Cat Cafe made in java, using a database in order to store data.
The code uses a local database in postgres, but the lines refferencing it can simply be changed for it to work with any other database.
For the sake of the app, it also includes a declaration code for a sql database with which one can test it out.
The frontend is done using java swing and it's incredibly barebones. :]


The cat cafe app has the following functions:

  -  Log in - self explanatory
  -  Register - you can make an account which will be saved on the database
  -  Order - you can make an order for a bag of coffee and also check your current orders
  -  Reservation - you can make a reservation where you choose the location, number of seats and date; check current reservations; delete a reservation and check the cats at each location
  -  Menu - check the menu of each location
  -  Adopt - adopt a cat
  -  Check user - check your own account details, as well as the cats you adopted using this site



<img width="611" height="529" alt="image" src="https://github.com/user-attachments/assets/2ed87b64-4e38-4c34-8a83-b9c196bd18e0" />
<img width="1239" height="894" alt="image" src="https://github.com/user-attachments/assets/86105620-7a06-4ff4-b6fa-5f2588cb473b" />
<img width="1232" height="863" alt="image" src="https://github.com/user-attachments/assets/9310f38e-0cf0-411d-9f96-168a44859071" />
<img width="1233" height="611" alt="image" src="https://github.com/user-attachments/assets/e2b30f41-d004-4a8b-969d-8c1c282d7aa8" />
<img width="1231" height="988" alt="image" src="https://github.com/user-attachments/assets/d7911d16-26bf-474a-88b7-9c25f00589b7" />
<img width="1232" height="609" alt="image" src="https://github.com/user-attachments/assets/8ea10d37-53db-47ac-a273-6b6dc2858d48" />
<img width="1226" height="610" alt="image" src="https://github.com/user-attachments/assets/7b19b2ed-0864-4d6b-ba98-27ea87c8e6e9" />
<img width="1231" height="612" alt="image" src="https://github.com/user-attachments/assets/9a8a4fb4-0443-4c1e-9ef2-b41eaa1b7e71" />



Used classes:
  -  Admin - a class used for the interaction between java and sql - it generates the code to retrieve elements and verifies data that will be added to the databases; it can registrate a new user, check data such that it's correct, get all database elements and check the current time
  -  DatabaseElement - an abstract class which classifies elements with concrete characteristics from the database; describes the basic functionalities by having getter functions for encapsulation and a printData
  -  Cat - a class which stores the data found in the cat and cat_races databases for easy access; it extends DatabaseElement and allows access their data for display
  -  Coffee - a class which stores the data found in coffee, coffee_types and providers databases; it extends DatabaseElement and allows easy printable data
  -  FoodType - a class which stores the food types found in food_type; it extends DatabaseElement and allows easy printable data, as well as access to every item from the menu which is in that food type
  -  Locations - a class which extends DatabaseElement which records and can print data from the locations database
  -  Shelters - a class which extends DatabaseElement which records and can print data from the shelters database
  -  User - a class which extends DatabaseElement which records and can print data from the users database
  -  RelationalDatabase - an interface which describes the functionality of a class which corresponds to a relational database (one-to-one, one-to-many, many-to-one) and allows searching every element associated to a single item ( by id )
  -  Adoptions - a RelationalDatabase which keeps the link between users and their adopted cats; they can also add a new adoption, which deletes the cat from cats_in_locations and cats_in_shelters and sets isadopted to 1 ( true )
  -  CatsLocation - a RelationalDatabase which records the link between cats with isadopted to 0 ( false ) and the cafe it's at
  -  CatsShelters - a RelationalDatabase which records the link between cats with isadopted to 0 ( false ) and the shelter it lives in
  -  LocationsTypes - a RelationalDatabase which records what food types each location serves
  -  Orders - a RelationalDatabase which records the orders placed ( link between users and coffee ) while also allowing the addition of new links
  -  Reservations - a RelationalDatabase which records the reservations made ( link between users and locations ) while also allowing the addition of new links and deleting reservations
  -  adopt, details, logInScreen, mainMenu, menuSearcher, order, registerScreen, reservation - the pages made in java swing which generate the front-end
  -  Main - the class which starts the app ( opens the logInScreen)


Instalation steps:

  -  Install all files
  -  Using a sql app like DBeaver, create a PostGreSQL connection named project
  -  Run declatation.sql to create the tables
  -  Create a java project using something like IntelliJ
  -  Run the main file
