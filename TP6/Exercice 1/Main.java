import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the directory path you want to explore: ");
        String directoryPath = scanner.nextLine();
        
        File directory = new File(directoryPath);
        
        // Check if the path exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("\nContents of directory: " + directory.getAbsolutePath());
            System.out.println("----------------------------------------------------------------------");
            System.out.printf("%-50s %-8s %s%n", "Name", "Type", "Permissions");
            System.out.println("----------------------------------------------------------------------");
            
            // List all files and directories
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Determine type
                    String type = file.isDirectory() ? "<DIR>" : "<FILE>";
                    
                    // Build permissions string
                    StringBuilder permissions = new StringBuilder();
                    if (file.canRead()) permissions.append("r");
                    if (file.canWrite()) permissions.append("w");
                    if (file.isHidden()) permissions.append("h");
                    
                    // Print formatted output
                    System.out.printf("%-50s %-8s %s%n", 
                        file.getName(),
                        type,
                        permissions.toString());
                }
            }
        } else {
            System.out.println("Error: The specified path is not a valid directory");
        }
        
        scanner.close();
    }
}
