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

            System.out.println("??????!");

            String message = in.readLine();
            System.out.println("Server received: " + message);


            while(!message.equalsIgnoreCase("exit")){
                if(message.matches(".*[??????].*")){
                    out.println("?? ???? ?????????");
                    String response = in.readLine();
                    String correctAnswer = "????????";
                    if(response != null && response.equalsIgnoreCase(correctAnswer)){
                        out.printf("Current date is:", LocalDate.now());
                        out.println("?? ?????????");
                        out.println("????? ???????!");
                    }
                    else{
                        out.println("??????????? ?????????");
                    }
                }
            }
            client.close();
            in.close();
            System.out.println("Client disconnected");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
