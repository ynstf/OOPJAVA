# Sockets

## Overview
This project includes two Java-based client-server applications demonstrating the use of sockets for communication. Each exercise showcases different functionalities:

1. **Exercise 1**: A "Guess the Magic Number" game using a multithreaded server.
2. **Exercise 2**: A simple file server that allows clients to request files from the server.

---

## Exercise 1: Guess the Magic Number
### Description
This exercise involves a server generating a random "magic number" between 0 and 100. Clients can connect to the server and guess the number. The server responds with hints like "Too low!", "Too high!", or "Congratulations!" upon guessing correctly.

### Key Code Snippet (Server)
```java
// Generate a random magic number between 0 and 100
magicNumber = new Random().nextInt(101);
System.out.println("Magic number (for debugging): " + magicNumber);
```
*This line generates a random number that clients must guess. The number is logged to the console for debugging purposes.*

```java
// Accept a new client connection
Socket socket = serverSocket.accept();
System.out.println("New client connected");
```
*The server waits for a client to connect and logs the connection to the console.*

```java
// Handle the client in a separate thread
new ClientHandler(socket).start();
```
*Each client is handled in its own thread to allow multiple clients to connect simultaneously.*

### Key Code Snippet (Client)
```java
// Connect to the server
Socket socket = new Socket("localhost", 12345);
```
*The client establishes a connection to the server using the specified hostname and port.*

```java
// Send guess to server
System.out.print("Enter your guess (0-100): ");
int guess = scanner.nextInt();
out.println(guess);
```
*The client reads a guess from the user and sends it to the server.*

```java
// Display server response
String response = in.readLine();
System.out.println(response);
```
*The client displays the server's feedback about the guess.*

---

## Exercise 2: File Server
### Description
This exercise implements a file server that allows clients to request specific files. The server checks if the requested file exists in its directory and sends its content to the client. If the file does not exist, the server informs the client.

### Key Code Snippet (Server)
```java
// Read file name from client
String fileName = in.readLine();
File file = new File(fileName);
```
*The server reads the file name requested by the client and checks if the file exists.*

```java
if (file.exists() && !file.isDirectory()) {
    BufferedReader fileReader = new BufferedReader(new FileReader(file));
    String line;
    while ((line = fileReader.readLine()) != null) {
        out.println(line);  // Send file content to client
    }
    fileReader.close();
} else {
    out.println("File not found");
}
```
*If the file exists, the server reads its contents line by line and sends them to the client. Otherwise, it informs the client that the file was not found.*

### Key Code Snippet (Client)
```java
// Request file from server
System.out.print("Enter the name of the file you want to request: ");
String fileName = scanner.nextLine();
out.println(fileName);
```
*The client prompts the user for the file name and sends the request to the server.*

```java
// Display file content or error message
String response;
while ((response = in.readLine()) != null) {
    System.out.println(response);
}
```
*The client displays the file content received from the server or an error message if the file is not found.*

---

## Dependencies
- Java 8 or later

---

## Notes
- Ensure the server and client run on the same machine or adjust the IP address in the client code to point to the server's address.
- For Exercise 2, the server must have access to the requested files.

