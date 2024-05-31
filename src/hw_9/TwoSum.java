package hw_9;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (map.containsKey(secondNumber)) {
                return new int[] { map.get(secondNumber), i };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
