import java.io.*;
import java.net.*;

public class WiFiServer {
    public static void main(String[] args) {
        int port = 8080; // Port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for a client...");
        //
        //w    
            Socket clientSocket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read message from client
            String message = in.readLine();
            System.out.println("Message from client:\n " + message);

            // Send response to client
            out.println("\n ok message\n");

            // Close connections
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("end message \nClient disconnected.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
