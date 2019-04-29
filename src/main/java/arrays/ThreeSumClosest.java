package arrays;

import java.util.*;

public class ThreeSumClosest {
    public static void main(String[] args) {
        // In this case, the solution would be 3 (new int[]{0, 1, 2})
        int data = threeSumClosest(new int[]{-1, 2, 1, -4}, 7);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Set<List<Integer>> dataSet = new HashSet<>();
        int targetDelta = nums[0] + nums[1] + nums[nums.length-1];

        Arrays.sort(nums); // O(nlog(n))
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(sum-target) < Math.abs(targetDelta - target)) {
                    targetDelta = sum;
                }
            }
        }

        return targetDelta;
    }
}
