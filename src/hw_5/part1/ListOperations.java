package hw_5.part1;

import java.util.*;

public class ListOperations {

    public int countOccurrence(List<String> list, String str){
        int count = 0;
        for(String s : list){
            if(s.equals(str)){
                count++;
            }
        }
        return count;
    }

    public List<Integer> toList(int[] arr){
        List<Integer> list = new ArrayList<Integer>();
        for(int i : arr){
            list.add(i);
        }
        return list;
    }

    public Set<Integer> findUnique(List<Integer> list){
        Set<Integer> uniqueNumbers = new HashSet<Integer>();
        for(int i : list){
            uniqueNumbers.add(i);
        }
        return uniqueNumbers;
    }
    // how can I insert that Map into list? Because i have no idea how to do that :)
    public void findOccurrence(List<String> list){
        Map<String, Integer> occurrences = new HashMap<String, Integer>();
        List<String> result = new ArrayList<>();
        for(String s : list){
            occurrences.put(s, occurrences.getOrDefault(s, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : occurrences.entrySet()){
            System.out.println("{name: \"" + entry.getKey() + "\" occurrence: " + entry.getValue() + "}");
        }
    }


}
