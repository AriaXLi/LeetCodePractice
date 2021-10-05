import java.util.HashMap;

// Link: https://leetcode.com/problems/two-sum/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numVals = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numVals.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (numVals.containsKey(complement) && numVals.get(complement) != j) {
                return new int[] {j, numVals.get(complement)};
            }
        }
        return null;
    }
}