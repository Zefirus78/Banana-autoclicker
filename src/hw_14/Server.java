package hw_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class Server {
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(8081)){
            System.out.println("Server is listening on port 8081");

            Socket client = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            out.println("Привіт!");

            String message = "";
            Number val = 5;
            while (!(message = in.readLine()).equalsIgnoreCase("exit")) {
                if (message.matches(".*[эъыЭЫЪ].*")){
                    out.println("What's palyanutsya?");
                    String response = in.readLine();
                    String correctAnswer = "полуниця";
                    if (response != null && response.equalsIgnoreCase(correctAnswer)) {
                        out.println("Current date is: " + LocalDate.now());
                        out.println("Bye!");
                        out.println("Glory to Ukraine!");
                    } else {
                        out.println("Bye moskal");
                        client.close();
                        out.println("You've been disconnected!");
                    }
                }
            }
            client.close();
            System.out.println("Client disconnected");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
