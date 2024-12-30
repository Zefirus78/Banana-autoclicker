package hw_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();

        String filePath = "src/hw_11" + bookName + ".txt";

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found");
            System.out.println("Do you want to create a file with the same name? (y/n)");
            String answer = scanner.next();
            switch (answer) {
                case "y":
                    new File(filePath);
                case "n":
                    System.exit(0);
            }
        }
        try {
            String content = FileOperations.read(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        List<Map.Entry<String, Integer>> top10Words = dataOperations.getTop10Words();
//        for (Map.Entry<String, Integer> entry : top10Words) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }





    }
}
