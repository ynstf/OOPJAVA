# TP6: Java File System Management

## Exercise 1: File System Explorer

In this exercise, we created a Java program that explores the file system and displays information about files and directories. The program allows users to:

1. Input any directory path they want to explore
2. View the contents of the specified directory
3. For each file/directory, the program shows:
   - Name of the file/directory
   - Type: `<DIR>` for directories and `<FILE>` for files
   - Access permissions:
     - 'r' if readable
     - 'w' if writable
     - 'h' if hidden

### What I Learned
- How to use Java's `File` class to work with the file system
- How to check file permissions and attributes
- How to format console output using `printf`
- How to handle user input using `Scanner`

### Code Features
- User-friendly table format display
- Error handling for invalid directories
- Clear separation between files and directories
- Permission information display

### Sample Output
```
Enter the directory path you want to explore:

Contents of directory: C:\MyDirectory
----------------------------------------------------------------------
Name                                               Type     Permissions
----------------------------------------------------------------------
document.txt                                       <FILE>   rw
images                                            <DIR>    rw
```

### Technical Skills & Code Examples

#### 1. File System Operations
```java
// Creating a File object
File directory = new File(directoryPath);

// Checking if path exists and is a directory
if (directory.exists() && directory.isDirectory()) {
    // Get list of files and directories
    File[] files = directory.listFiles();
}
```

#### 2. Permission Checking
```java
// Building permissions string
StringBuilder permissions = new StringBuilder();
if (file.canRead()) permissions.append("r");
if (file.canWrite()) permissions.append("w");
if (file.isHidden()) permissions.append("h");
```

#### 3. User Input Handling
```java
// Creating Scanner for user input
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the directory path you want to explore: ");
String directoryPath = scanner.nextLine();
```

#### 4. Formatted Output
```java
// Table header formatting
System.out.printf("%-50s %-8s %s%n", "Name", "Type", "Permissions");
System.out.println("----------------------------------------------------------------------");

// File information formatting
System.out.printf("%-50s %-8s %s%n", 
    file.getName(),
    type,
    permissions.toString());
```

#### 5. File Type Detection
```java
// Determining if item is file or directory
String type = file.isDirectory() ? "<DIR>" : "<FILE>";
```

### Key Java Concepts Used
1. **Classes & Objects**
   - `File` class for file system operations
   - `Scanner` class for input
   - `StringBuilder` for string manipulation

2. **Control Structures**
   - `if` statements for condition checking
   - `for` loops for iterating through files

3. **String Formatting**
   - `printf` for formatted output
   - String concatenation

4. **Exception Handling**
   - Checking for valid directory paths
   - Handling file access permissions

5. **File System API**
   - File attributes
   - Directory listing
   - Permission checking


## Exercise 2: Phone Directory with File Management

### Project Overview
In this exercise, we developed a Java program to manage a phone directory using file-based storage. Each contact is saved in a separate file, where the filename represents the contact's name and contains their associated phone number.

### Implementation Details

#### 1. DossierContact Class
This class handles all file operations for contact management:

```java
public class DossierContact {
    private File dossier;
    private boolean modifie;

    // Constructor: creates 'contacts' directory if it doesn't exist
    public DossierContact() {
        dossier = new File("contacts");
        if (!dossier.exists()) {
            dossier.mkdir();
        }
        modifie = false;
    }
}
```

#### Technical Skills Demonstrated:

1. **File Operations:**
   ```java
   // Adding a contact example
   public void ajouterContact(String nom, String numero) {
       try {
           File fichier = new File(dossier, nom + ".txt");
           BufferedWriter writer = new BufferedWriter(new FileWriter(fichier));
           writer.write(numero);
           writer.close();
           modifie = true;
       } catch (IOException e) {
           System.out.println("Error adding contact: " + e.getMessage());
       }
   }
   ```

2. **File Reading:**
   ```java
   public String rechercherContact(String nom) {
       try {
           File fichier = new File(dossier, nom + ".txt");
           if (fichier.exists()) {
               BufferedReader reader = new BufferedReader(new FileReader(fichier));
               String numero = reader.readLine();
               reader.close();
               return numero;
           }
       } catch (IOException e) {
           System.out.println("Error reading contact: " + e.getMessage());
       }
       return null;
   }
   ```

#### 2. Main Class
Interactive console interface with a menu system:

```java
public class Main {
    public static void main(String[] args) {
        DossierContact dossier = new DossierContact();
        Scanner scanner = new Scanner(System.in);
        // Menu with 5 options
        while (continuer) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Search for a phone number");
            System.out.println("2. Add a new contact");
            // ...
        }
    }
}
```

### Key Features
1. **Contact Creation:**
   - Saves contacts in .txt files
   - One file per contact
   - Handles I/O errors

2. **Contact Search:**
   - Reads existing files
   - Returns phone number if found
   - Handles non-existent contacts

3. **Contact Deletion:**
   - Physical file deletion
   - Existence verification

4. **Number Modification:**
   - File rewriting with new number
   - Maintains same filename

### Technical Skills Acquired
1. **Java File Handling:**
   - File class usage
   - File/directory creation and deletion
   - Path management

2. **I/O Operations:**
   - BufferedWriter for writing
   - BufferedReader for reading
   - Proper resource closing

3. **Exception Handling:**
   - Try-catch blocks for file operations
   - User-friendly error messages
   - Failure case management

4. **User Interface:**
   - Interactive console menu
   - Input validation
   - Confirmation messages

### Potential Improvements
1. Phone number format validation
2. Duplicate contact handling
3. Contact backup system
4. Graphical user interface (GUI)

### Learning Outcomes
This project helped me understand:
- File manipulation in Java
- I/O exception handling
- Interactive user interface creation
- Object-oriented code organization

### Code Structure
The project follows a clear separation of concerns:
- DossierContact: Handles all file operations
- Main: Manages user interaction
- Each contact stored in individual files for easy management

## Exercise 3: Product and Client Management System

In this exercise, we developed a Java application for managing products and clients with file-based persistence using serialization. The system is split into two separate applications: one for product management and another for client management.

### Features

#### 1. Product Management Application
- View all products
- Search products by name
- Add new products with details (name, brand, price, description, stock)
- Delete products by name
- Save products to file (produits.dat)

#### 2. Client Management Application
- View all clients
- Search clients by name
- Add new clients with details (name, surname, address, phone, email)
- Delete clients by name
- Save clients to file (clients.dat)

### Architecture

1. **Entity Layer**
   ```java
   // Product entity
   public class Produit implements Serializable {
       private String nom;
       private String marque;
       private double prix;
       private String description;
       private int nombreEnStock;
   }

   // Client entity
   public class Client implements Serializable {
       private String nom;
       private String prenom;
       private String adresse;
       private String tel;
       private String email;
   }
   ```

2. **Data Access Layer**
   ```java
   // Generic interface for CRUD operations
   public interface IMetier<T> {
       void add(T o);
       List<T> getAll();
       T findByNom(String nom);
       void delete(String nom);
       void saveAll();
   }

   // Implementations for Product and Client
   public class MetierProduitImpl implements IMetier<Produit> { ... }
   public class MetierClientImpl implements IMetier<Client> { ... }
   ```

3. **Application Layer**
   ```java
   // Separate applications for Products and Clients
   public class ApplicationProduit { ... }
   public class ApplicationClient { ... }
   ```

### Technical Features

1. **Serialization**
   - Objects are serialized to binary files
   - Automatic file creation if not exists
   - Data persistence between sessions

2. **Generic Programming**
   - Generic interface for data operations
   - Type-safe implementations

3. **File Management**
   - Automatic directory creation
   - Binary file handling
   - Error handling for file operations

4. **User Interface**
   - Menu-driven console interface
   - Input validation
   - Clear feedback messages

### How to Run

1. **Compile the Applications**
   ```bash
   javac application/ApplicationProduit.java
   javac application/ApplicationClient.java
   ```

2. **Run Product Management**
   ```bash
   java application.ApplicationProduit
   ```

3. **Run Client Management**
   ```bash
   java application.ApplicationClient
   ```

### What I Learned
- Implementation of serialization in Java
- Generic interface design
- File-based persistence
- Separation of concerns (entities, DAO, application)
- Menu-driven console application design
- Error handling and user input validation

### Key Java Concepts Used
1. **Object-Oriented Programming**
   - Inheritance
   - Interfaces
   - Encapsulation

2. **Generics**
   - Generic interfaces
   - Type-safe implementations

3. **File I/O**
   - Binary file handling
   - Serialization/Deserialization

4. **Collections**
   - List interface
   - ArrayList implementation

5. **Exception Handling**
   - Try-catch blocks
   - Custom error messages
