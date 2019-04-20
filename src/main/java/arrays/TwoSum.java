package arrays;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static void main(String[] args) {
        int[] data = TwoSum.twoSum(new int[]{1, 4, 10, 19, 20}, 11);
        System.out.println(data[0]);
        System.out.println(data[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (data.containsKey(target - nums[i])) {
                return new int[]{data.get(target - nums[i]), i};
            }
            data.put(nums[i], i);
        }
        return null;
    }
}
