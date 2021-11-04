import java.util.*;

// Link: https://www.algoexpert.io/questions/Two%20Number%20Sum
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
    
        Set<Integer> set = new HashSet<>();
		for (int num : array) {
			int complement = targetSum - num;
			if (set.contains(complement)) {
				return new int[] {num, complement};
			}
			else {
				set.add(num);
			}
		}
		
		return new int[0];
  }
}
