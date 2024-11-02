# 1 - Library Management Application

## Description
This application is designed to manage the information of members, authors, and books in a library. It implements object-oriented programming principles to model these entities and their interactions effectively.

## Problem Statement
The goal of this exercise is to create a Java application that can handle the following functionalities:
1. Store and manage the details of library members.
2. Store and manage the details of authors.
3. Manage the information of books, including their ISBN and associated authors.

## Code Structure

### 1. Class `Person`
- **Purpose**: This is the base class representing a person in the library system.
- **Attributes**:
  - `nom`: The last name of the person.
  - `prenom`: The first name of the person.
  - `email`: The email address of the person.
  - `telephone`: The phone number of the person.
  - `age`: The age of the person.
- **Methods**:
  - `afficher()`: Displays the personal information of the person.

### 2. Class `Adherent`
- **Purpose**: This class represents a library member who inherits from `Person`.
- **Additional Attribute**:
  - `numAdherent`: A unique identifier for the member.
- **Overridden Method**:
  - `afficher()`: Displays the member's information, including the member number.

### 3. Class `Auteur`
- **Purpose**: This class represents an author, also inheriting from `Person`.
- **Additional Attribute**:
  - `numAuteur`: A unique identifier for the author.
- **Overridden Method**:
  - `afficher()`: Displays the author's information, including the author number.

### 4. Class `Livre`
- **Purpose**: Represents a book in the library.
- **Attributes**:
  - `ISBN`: The book's ISBN number.
  - `titre`: The title of the book.
  - `auteur`: An instance of the `Auteur` class, representing the book's author.
- **Method**:
  - `afficher()`: Displays the book's ISBN, title, and author's information.

### 5. Class `Application`
- **Purpose**: Contains the `main` method to test the functionality of the application.
- **Functionality**:
  - Instantiates an `Adherent` and displays their information.
  - Instantiates an `Auteur`.
  - Instantiates a `Livre` associated with the `Auteur` and displays the book's information.

## Conclusion
This library management application effectively demonstrates object-oriented programming concepts, including inheritance, method overriding, and encapsulation. It serves as a foundational model for building more complex library systems with additional features and functionalities.

![image](https://github.com/user-attachments/assets/0f43515b-1343-4e7d-92d3-cc955cd58aa8)


# 2 - Salary Management Application

## Description
This application is designed to manage the salaries of employees within a software development company. It implements object-oriented programming principles to differentiate between engineers and managers, calculating their salaries based on specific criteria.

## Problem Statement
The goal of this exercise is to create a Java application that can handle the following functionalities:
1. Store and manage the details of employees, including their roles and salaries.
2. Differentiate between engineers and managers and apply specific salary calculation rules for each role.

## Code Structure

### 1. Abstract Class `Employe`
- **Purpose**: This abstract class serves as the base for all employee types within the company.
- **Attributes**:
  - `nom`: The last name of the employee.
  - `prenom`: The first name of the employee.
  - `email`: The email address of the employee.
  - `telephone`: The phone number of the employee.
  - `salaire`: The base salary of the employee.
- **Methods**:
  - `calculerSalire()`: An abstract method that will be implemented in derived classes to calculate the employee's salary.

### 2. Class `Ingenieur`
- **Purpose**: This class represents an engineer, inheriting from `Employe`.
- **Additional Attribute**:
  - `specialite`: The specialization of the engineer (e.g., Python Developer).
- **Overridden Method**:
  - `calculerSalire()`: Calculates the salary of the engineer, applying a 15% increase to the base salary.

### 3. Class `Manager`
- **Purpose**: This class represents a manager, also inheriting from `Employe`.
- **Additional Attribute**:
  - `service`: The department or service the manager oversees (e.g., IT).
- **Overridden Method**:
  - `calculerSalire()`: Calculates the salary of the manager, applying a 20% increase to the base salary.

### 4. Class `Application`
- **Purpose**: Contains the `main` method to test the functionality of the application.
- **Functionality**:
  - Instantiates an `Ingenieur` and displays their information, including name, specialization, and calculated salary.
  - Instantiates a `Manager` and displays their information, including name, service, and calculated salary.

## Conclusion
This salary management application effectively demonstrates the use of abstract classes and method overriding in object-oriented programming. It allows for clear differentiation between different types of employees while applying specific salary calculation rules. This structure can serve as a foundation for more complex employee management systems with additional features and functionalities.

![image](https://github.com/user-attachments/assets/2b4547d1-8f15-447a-b56e-f3be5a8943d5)


# 3 - Computer Management System

## Description
This application is designed to manage a system of computers, allowing for the management of computer categories, clients, orders, and associated order lines. The system is built using Java and consists of several interconnected classes that work together to provide a comprehensive management solution.

## Problem Statement
The goal of this exercise is to create a Java application that can handle the following functionalities:
1. Manage computers and their attributes, including name, brand, price, description, stock quantity, and category.
2. Manage categories of computers, allowing for the addition and removal of computers from these categories.
3. Manage client information and their associated orders, providing the ability to add and remove orders.
4. Handle order details and the specific items within each order.

## Code Structure

### 1. Class `Ordinateur`
- **Attributes**:
  - `nom`: The name of the computer.
  - `marque`: The brand of the computer.
  - `prix`: The price of the computer.
  - `description`: A brief description of the computer.
  - `nombreEnStock`: The number of units available in stock.
  - `categorie`: The category to which the computer belongs.
- **Methods**:
  - Getters and setters for accessing and modifying attributes.
  - `calculerPrixTotal(int quantite)`: Calculates the total price based on the quantity requested and the unit price.
  - `afficherDetails()`: Displays the details of the computer.

### 2. Class `Categorie`
- **Attributes**:
  - `nom`: The name of the category.
  - `description`: A brief description of the category.
  - `ordinateurs`: A list of computers belonging to the category.
- **Methods**:
  - Getters and setters for accessing and modifying attributes.
  - `ajouterOrdinateur(Ordinateur ordinateur)`: Adds a computer to the category if it is not already present.
  - `supprimerOrdinateur(Ordinateur ordinateur)`: Removes a computer from the category.
  - `afficherOrdinateurs()`: Displays all computers in the category.
  - `rechercherParPrix(double prix)`: Displays computers with the specified price.

### 3. Class `Client`
- **Attributes**:
  - `nom`: The name of the client.
  - `prenom`: The first name of the client.
  - `adresse`: The address of the client.
  - `email`: The email address of the client.
  - `ville`: The city where the client resides.
  - `telephone`: The phone number of the client.
  - `commandes`: A list of orders placed by the client.
- **Methods**:
  - Getters and setters for accessing and modifying attributes.
  - `ajouterCommande(Commande commande)`: Adds an order to the client's order list.
  - `supprimerCommande(Commande commande)`: Removes an order from the list.
  - `afficherDetailsClient()`: Displays the client's details along with their orders.

### 4. Class `Commande`
- **Attributes**:
  - `reference`: The unique reference of the order.
  - `client`: The client associated with the order.
  - `dateCommande`: The date the order was placed.
  - `etatCommande`: The current state of the order (e.g., in progress, completed).
- **Methods**:
  - Getters and setters for accessing and modifying attributes.
  - `afficherDetailsCommande()`: Displays the details of the order.

### 5. Class `LigneCommande`
- **Attributes**:
  - `quantite`: The quantity of computers ordered.
  - `commande`: The order associated with this order line.
  - `ordinateur`: The computer associated with this order line.
- **Methods**:
  - Getters and setters for accessing and modifying attributes.
  - `calculerPrixTotal()`: Calculates the total price of the order line based on quantity.
  - `afficherDetailsLigneCommande()`: Displays the details of the order line.

### 6. Class `Application`
- **Purpose**: Contains the main entry point of the program.
- **Functionality**:
  - Creates computers and displays their details.
  - Creates a computer category and adds computers to that category.
  - Displays computers within a given category.
  - Searches for computers by price.
  - Creates a client and adds an order.
  - Creates order lines associated with an order and displays order details.

## Conclusion
This computer management system efficiently manages computers, clients, and their orders. By utilizing classes and methods, the code is structured, easy to understand, and extensible. This project can serve as a foundation for developing additional features according to future needs.

![image](https://github.com/user-attachments/assets/ff9ff7cd-0224-4429-b9c3-815aefe41e5c)


# 4 - Product Management System

## Objective
The goal of this exercise was to create a product management system that allows various operations on a collection of `Product` objects using lists and interfaces in Java. The system should support functionalities such as adding, searching, deleting, and displaying products, while utilizing object-oriented programming (OOP) principles.

## Project Structure

### 1. `Product` Class
- **Attributes**:
  - `id`: Unique identifier for the product.
  - `name`: Name of the product.
  - `brand`: Brand of the product.
  - `price`: Price of the product.
  - `description`: Description of the product.
  - `stockQuantity`: Number of units available in stock.
  
- **Methods**:
  - Getters and Setters for accessing and modifying attributes.
  - `displayInfo()`: Method to display product information.

### 2. `IMetierProduct` Interface
- Declaration of methods to manage `Product` objects:
  - `add(Product p)`: Adds a product to the list.
  - `getAll()`: Returns all products as a list.
  - `findByName(String keyword)`: Searches for products by name.
  - `findById(long id)`: Finds a product by ID.
  - `delete(long id)`: Deletes a product by ID.

### 3. `MetierProductImpl` Class
- Implements the `IMetierProduct` interface.
  
- **Attribute**:
  - `products`: List of products managed by this class.

- **Methods**:
  - Implementation of the declared methods for managing the product collection.

### 4. `Application` Class
- The entry point of the program, containing the `main` method.
- Presents a menu to the user in a `while` loop to perform various operations:
  1. Display the list of products.
  2. Search for products by keyword.
  3. Add a new product.
  4. Retrieve and display a product by ID.
  5. Delete a product by ID.
  6. Exit the program.

## Conclusion
This product management system, built using OOP principles in Java, enables efficient manipulation of a collection of `Product` objects. Through the creation of classes and interfaces, the code is structured, extensible, and easy to maintain. This project can be further enhanced by adding new features as future requirements arise, such as managing product categories or integrating a database for data persistence.
