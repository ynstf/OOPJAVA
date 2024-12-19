import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    private static final int PORT = 12345; // Port number for the server
    public static int magicNumber; // The magic number to be guessed

    public static void main(String[] args) {
        // Generate a random magic number between 0 and 100
        magicNumber = new Random().nextInt(101);
        System.out.println("Magic number (for debugging): " + magicNumber);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Accept a new client connection
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle the client in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                int guess = Integer.parseInt(inputLine);
                if (guess < Server.magicNumber) {
                    out.println("Too low!");
                } else if (guess > Server.magicNumber) {
                    out.println("Too high!");
                } else {
                    out.println("Congratulations! You've guessed the magic number!");
                    break; // Exit the loop if the guess is correct
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}