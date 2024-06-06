package hw_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        BufferedReader in;
        PrintWriter out;
        try(Socket clientSocket = new Socket("localhost", 8081)) {
            System.out.println("Connected");
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner keyboard = new Scanner(System.in);

            out.println(keyboard.nextLine());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String line = "";
        while (!line.equals("Over")) {
            try {
                line = in.readLine();
                out.writeUTF(line);
            } catch(IOException i) {
                System.out.println(i);
            }
        }
    }
}
