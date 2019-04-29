package arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        List<List<Integer>> data = threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> dataSet = new HashSet<>();
        Arrays.sort(nums); // O(nlog(n))
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) dataSet.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum < 0) j++;
                else if (sum > 0) k--;
            }
        }

        return new ArrayList<>(dataSet);
    }
}
