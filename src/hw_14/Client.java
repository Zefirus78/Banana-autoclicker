package hw_14;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8081);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Server: " + response);
                if (response.equals("Bye!")) {
                    break;
                }

                String userInput = "????????";

                out.println(userInput);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
