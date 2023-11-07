import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress IPAddress = InetAddress.getByName("localhost");

            byte[] sendData;
            byte[] receiveData = new byte[1024];
            while (true) {
                String sentence = inFromUser.readLine();
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1234);
                clientSocket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("FROM SERVER: " + modifiedSentence);
            }
        } catch (IOException e) {
            System.err.println("Error in communication with the server: " + e.getMessage());
        }
    }
}
