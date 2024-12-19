
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345); // Connect to the server
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the name of the file you want to request: ");
            String fileName = scanner.nextLine();
            out.println(fileName); // Send file name to server

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response); // Display file content or error message
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}