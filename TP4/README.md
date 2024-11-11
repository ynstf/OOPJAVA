# Practical Activity 1: Collections

## Exercise 1: Lists

### Description

The goal is to create a simple application to manage a list of product objects.

### Steps

1. **Create a `Produit` class**:
   - The `Produit` class will have the following attributes: `id` (long), `nom` (String), and `prix` (double).
   - We'll generate getters and setters for these attributes.
   - The class will also have a constructor that takes these three parameters.

```java
class Produit {
    private long id;
    private String nom;
    private double prix;

    public Produit(long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    // Getters and Setters
    // ...
}
```

2. **Create a `GestionProduitsApp` class with a `main` method**:
   - In the `main` method, we'll create an `ArrayList` to store `Produit` objects.
   - We'll then perform the following operations on the list:
     - Add products to the list.
     - Remove a product by index.
     - Display the list of products.
     - Modify a product by index.
     - Search for a product by name entered by the user.

```java
import java.util.*;

class GestionProduitsApp {
    public static void main(String[] args) {
        List<Produit> listeProduits = new ArrayList<>();

        // Add products to the list
        listeProduits.add(new Produit(1, "PC", 20000.5));
        listeProduits.add(new Produit(2, "Phone", 24400.5));
        listeProduits.add(new Produit(3, "Car", 2077800.5));

        // Remove a product by index
        listeProduits.remove(1);

        // Display the list of products
        listeProduits.forEach(p -> System.out.println(p.getNom()));

        // Modify a product by index
        listeProduits.set(0, new Produit(2, "Phone", 24400.5));

        // Search for a product by name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a product name: ");
        String searchName = scanner.nextLine();
        for (Produit p : listeProduits) {
            if (p.getNom().equalsIgnoreCase(searchName)) {
                System.out.println("Found product: " + p.getId() + ", " + p.getNom() + ", " + p.getPrix());
            }
        }
    }
}
```

### Conclusion

In this exercise, we've created a simple application to manage a list of product objects. We've used an `ArrayList` to store the products and performed various operations on the list, such as adding, removing, modifying, and searching for products.

## Exercise 2: Maps

### Description

In this exercise, we want to create a `HashMap` that stores student grades, where the key is the student's name and the value is the grade.

### Steps

1. **Create a `HashMap` to store student grades**:
   - We'll use a `HashMap<String, Double>` to store the student names and their corresponding grades.
   - We'll perform the following operations on the map:
     - Insert student grades into the map.
     - Increase a student's grade.
     - Remove a student's grade.
     - Display the size of the map.
     - Display the average, maximum, and minimum grades.
     - Check if there is a grade equal to 20.
   - After each operation, we'll display the list using the `forEach` loop with a lambda expression.

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<String, Double> grades = new HashMap<>();

        // Insert student grades
        grades.put("Youness", 14.5);
        grades.put("Said", 16.75);
        grades.put("Ahmad", 12.25);
        // ... (more students)

        // Increase a student's grade
        grades.put("Youness", grades.get("Youness") + 1);

        // Remove a student's grade
        grades.remove("Ahmad");

        // Display the size of the map
        System.out.println("Map size: " + grades.size());

        // Display the average, maximum, and minimum grades
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (double grade : grades.values()) {
            sum += grade;
            max = Math.max(max, grade);
            min = Math.min(min, grade);
        }
        double average = sum / grades.size();
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        // Check if there is a grade equal to 20
        boolean hasGrade20 = grades.containsValue(20.0);
        System.out.println("Grade of 20 exists: " + hasGrade20);

        // Display the map using forEach with lambda
        grades.forEach((name, grade) -> System.out.println(name + ": " + grade));
    }
}
```

### Conclusion

In this exercise, we've created a `HashMap` to store student grades, where the key is the student's name and the value is the grade. We've performed various operations on the map, such as inserting, modifying, and removing grades, as well as displaying statistics and iterating over the map using a lambda expression.

## Exercise 3: Sets

### Description

In this exercise, we want to create two `HashSet` instances, `groupeA` and `groupeB`, to store the names of students in two groups, and then perform operations on these sets.

### Steps

1. **Create two `HashSet` instances**:
   - We'll create two `HashSet<String>` instances, `groupeA` and `groupeB`, to store the student names.
   - We'll add student names to each set.
   - Then, we'll perform the following operations:
     - Display the intersection of the two `HashSets`.
     - Display the union of the two `HashSets`.

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> groupeA = new HashSet<>();
        HashSet<String> groupeB = new HashSet<>();

        // Add student names to each HashSet
        groupeA.add("Youness");
        groupeA.add("Said");
        groupeA.add("Ahmad");
        // ... (more students in groupeA)
        groupeB.add("imane");
        groupeB.add("akram");
        // ... (more students in groupeB)

        // Display the intersection of the two HashSets
        Set<String> intersection = new HashSet<>(groupeA);
        intersection.retainAll(groupeB);
        System.out.println("Intersection of the two groups: " + intersection);

        // Display the union of the two HashSets
        Set<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB);
        System.out.println("Union of the two groups: " + union);
    }
}
```

### Conclusion

In this exercise, we've created two `HashSet` instances, `groupeA` and `groupeB`, to store the names of students in two groups. We've then performed operations to display the intersection and union of these two sets.

Overall, this practical activity has covered the use of common data structures in Java, such as `ArrayList`, `HashMap`, and `HashSet`, and the various operations that can be performed on them. These data structures are fundamental to building more complex applications and solving a wide range of problems.

# Practical Activity 2: Streams

This project contains two exercises using Java streams.

## Exercise 1: Operations on a List of Words

In this exercise, we will perform various operations on a list of words.

```java
// Definition of the list of words
List<String> words = new ArrayList<>();
words.add("Hello");
words.add("everyone");
words.add("in");
words.add("this");
words.add("TP");
words.add("thank");
words.add("you");
words.add("very");
words.add("match");
```

### 1. Filter words containing the letter "a"

```java
List<String> filteredListA = words.stream()
                            .filter(s -> s.contains("a"))
                            .collect(Collectors.toList());
System.out.println("Words containing the letter 'a': " + filteredListA);
```

**Conclusion:** The `filter()` method allows you to select only the elements of a stream that meet a certain criterion (here, the presence of the letter 'a' in the word).

### 2. Filter words longer than 3 characters and transform each word to its reverse

```java
List<String> filteredList3 = words.stream()
                            .filter(s -> s.length() > 3)
                            .map(r -> new StringBuilder(r).reverse().toString())
                            .collect(Collectors.toList());
System.out.println("Words longer than 3 characters, reversed: " + filteredList3);
```

**Conclusion:** The `map()` method allows you to transform each element of the stream. Here, we reverse the order of the characters of each word.

### 3. Filter strings containing the letter "e" and flatten each string into a list of characters

```java
List<Character> flattenedListE = words.stream()
                                    .filter(s -> s.contains("e")) // Filter strings containing "e"
                                    .flatMap(s -> s.chars() // Convert each string to a stream of integers (ASCII codes of characters)
                                                .mapToObj(c -> (char) c)) // Convert integers to characters
                                    .collect(Collectors.toList()); // Collect the result in a list
System.out.println("Characters of words containing 'e': " + flattenedListE);
```

**Conclusion:** The `flatMap()` method allows you to flatten a stream of streams into a single stream. Here, we convert each string into a stream of characters, then collect them into a single list.

### 4. Transform each string to its uppercase version

```java
List<String> upperCaseList = words.stream()
                                .map(s -> s.toUpperCase()) //.map(String::toUpperCase) Transform each string to uppercase
                                .collect(Collectors.toList());  // Collect the transformed strings in a list
System.out.println("Words in uppercase: " + upperCaseList);
```

**Conclusion:** The `map()` method allows you to transform each element of the stream. Here, we convert each word to uppercase.

### 5. Convert each string to its length

```java
List<Integer> upperCaseListLen = words.stream()
                                    .map(s -> s.length())
                                    .collect(Collectors.toList());  // Collect the transformed strings in a list
System.out.println("Lengths of words: " + upperCaseListLen);
```

**Conclusion:** The `map()` method allows you to transform each element of the stream. Here, we convert each word to its length.

### 6. Transform each string into a list of characters, then flatten all the lists into a single one

```java
List<Character> flattenedList = words.stream()
                                   .flatMap(s -> s.chars()  // Convert each string to a stream of ASCII codes of characters
                                                 .mapToObj(c -> (char) c))  // Convert ASCII codes to characters
                                   .collect(Collectors.toList());  // Collect all the characters in a list
System.out.println("Characters of all words: " + flattenedList);
```

**Conclusion:** The `flatMap()` method allows you to flatten a stream of streams into a single stream. Here, we convert each string into a stream of characters, then collect them into a single list.

### 7. Transform each word into "Name - Index"

```java
List<String> listIndex = IntStream.range(0, words.size())  // Create a stream of indexes
                                .mapToObj(i -> words.get(i) + " - " + i)  // Create the "Name - Index" string
                                .collect(Collectors.toList());  // Collect the results in a list
System.out.println("Words with index: ");
listIndex.forEach(System.out::println);
```

**Conclusion:** The `mapToObj()` method allows you to create a new stream from an index stream. Here, we create a string in the form "Name - Index" for each word.

## Exercise 2: Operations on a List of Employees

In this exercise, we will perform various operations on a list of employees.

```java
// Definition of the Employe class
class Employe {
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employe(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }

    // toString method to display employee information
    @Override
    public String toString() {
        return "Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

// Definition of the list of employees
List<Employe> employees = new ArrayList<>();
employees.add(new Employe("Alice", "IT", 55000));
employees.add(new Employe("Bob", "Marketing", 45000));
employees.add(new Employe("Charlie", "Human Resources", 50000));
employees.add(new Employe("David", "IT", 60000));
```

### 1. Calculate the total sum of salaries

```java
double totalSalary = employees.stream()
                              .mapToDouble(Employe::getSalary)  // Convert each employee to their salary
                              .sum();  // Calculate the sum of salaries
System.out.println("Total sum of salaries: " + totalSalary);
```

**Conclusion:** The `mapToDouble()` method allows you to create a stream of doubles from the salaries of the employees, and the `sum()` method allows you to calculate the sum of these values.

### 2. Sort the list of employees alphabetically by name

```java
List<Employe> sortedEmployees = employees.stream()
                                     .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))  // Compare names
                                     .collect(Collectors.toList());  // Collect the results in a list
System.out.println("Sorted list of employees: ");
System.out.println(sortedEmployees);
```

**Conclusion:** The `sorted()` method allows you to sort the elements of the stream using a `Comparator`. Here, we compare the names of the employees.

### 3. Find the employee with the lowest salary

```java
Optional<Employe> employeeWithLowestSalary = employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())); // Compare salaries
System.out.println("Employee with the lowest salary: " + employeeWithLowestSalary);
```

**Conclusion:** The `min()` method allows you to find the minimal element of the stream according to a `Comparator`. Here, we compare the salaries of the employees.

### 4. Filter employees with a salary higher than a threshold

```java
double threshold = 50000;
List<Employe> employeesAboveThreshold = employees.stream()
                                    .filter(s -> s.getSalary()>threshold)
                                    .collect(Collectors.toList());
System.out.println("Employees with salary above the threshold: " + employeesAboveThreshold);
```

**Conclusion:** The `filter()` method allows you to select only the elements of the stream that meet a certain criterion (here, a salary higher than a threshold).

### 5. Find the employee with the highest salary

```java
Optional<Employe> employeeWithHighestSalary = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2); //.max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));  Compare salaries
System.out.println("Employee with the highest salary: " + employeeWithHighestSalary);
```

**Conclusion:** The `reduce()` method allows you to reduce a stream to a single value. Here, we compare the salaries of the employees to find the one with the highest salary.

### 6. Concatenate the names of all employees

```java
String employeeNamesConcat = employees.stream()
                               .map(Employe::getName)
                               .reduce((name1, name2) -> name1 + " " + name2)
                               .orElse("No employees");
System.out.println("Concatenated employee names: " + employeeNamesConcat);
```

**Conclusion:** The `reduce()` method allows you to reduce a stream to a single value. Here, we concatenate all the names of the employees.
