package hw_11;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class DataOperations {

    Map<String, Integer> wordCount = new HashMap<>();

    public void totalWords(Scanner fileScanner){
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine().toLowerCase();
            String[] words = line.split("\\s+");
            for(String word : words){
                if(word.length()>2){
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
    }

    public List<Map.Entry<String, Integer>> getTop10Words() {
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue() - a.getValue());
        return sortedWords.subList(0, Math.min(10, sortedWords.size()));
    }
}
