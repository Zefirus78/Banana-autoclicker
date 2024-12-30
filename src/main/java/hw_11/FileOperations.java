package hw_11;

import java.io.*;
import java.util.Map;

public class FileOperations {

    public static String read(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
           String line;
           while ((line = br.readLine()) != null) {
               content.append(line);
           }
        }
        return content.toString();
        }

    public void write(String fileName, Map<String, Integer> mostOccurredWords, int totalWords) throws IOException {
        String filePath = "{" + fileName + "}" + "_statistics.txt";
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
    }
}
