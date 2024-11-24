import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WiFiClient {
    public static void main(String[] args) {
        String serverAddress = "192.168.43.1"; // Replace with your Android server's (static not gateway)IP address
        int port = 8080; // Ensure this matches the server's port

       
        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server: " + serverAddress+"\n enter message to send\n");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            String st= sc.nextLine();
            out.println(st);
            String response = in.readLine();
            System.out.println("Response from server: " + response);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}