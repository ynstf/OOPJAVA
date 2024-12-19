import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);  // Connect to the server
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            String response;
            int guess;
            do {
                System.out.print("Entrez votre supposition (0-100): ");
                guess = scanner.nextInt();
                out.println(guess);  // Send guess to server
                response = in.readLine();  // Read server response
                System.out.println(response);  // Display response to user
            } while (!response.equals("Correct!"));

            System.out.println("Félicitations! Vous avez trouvé le nombre magique!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}