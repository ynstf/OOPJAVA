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
