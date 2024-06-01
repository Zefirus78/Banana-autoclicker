package hw_9;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // Runtime 7ms Memory 61.02 mb
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
