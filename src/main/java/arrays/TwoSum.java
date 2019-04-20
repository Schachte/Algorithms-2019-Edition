package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> dataMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!dataMap.containsKey(target - nums[i])) {
                dataMap.put(nums[i], i);
            } else {
                return new int[]{dataMap.get(target - nums[i]), i};
            }
        }
        return null;

    }
}
