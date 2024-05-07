package hw_5.part1;

import java.util.*;

public class ListOperations {

    public int countOccurrence(List<String> listOfOccurrences, String occurrenceWord){
        int count = 0;
        for(String s : listOfOccurrences){
            if(s.equals(occurrenceWord)){
                count++;
            }
        }
        return count;
    }

    public List<Integer> toList(int[] arrayOfIntegers){
        List<Integer> list = new ArrayList<>();
        for(int i : arrayOfIntegers){
            list.add(i);
        }
        return list;
    }

    public Set<Integer> findUnique(List<Integer> listOfIntegers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int i : listOfIntegers){
            uniqueNumbers.add(i);
        }
        return uniqueNumbers;
    }
    // how can I insert that Map into list? Because I have no idea how to do that :)
    public void findOccurrence(List<String> listOfOccurrences){
        Map<String, Integer> occurrences = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String s : listOfOccurrences){
            occurrences.put(s, occurrences.getOrDefault(s, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : occurrences.entrySet()){
            System.out.println("{name: \"" + entry.getKey() + "\" occurrence: " + entry.getValue() + "}");
        }
    }


}
