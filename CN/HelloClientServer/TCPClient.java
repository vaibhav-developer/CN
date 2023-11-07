
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read user input and send it to the server
            String message;
            while ((message = userInput.readLine()) != null) {
                System.out.println("Server: " + in.readLine());
                out.println(message);

            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: localhost");
        } catch (IOException e) {
            System.err.println("Error in communication with the server: " + e.getMessage());
        }
    }
}
