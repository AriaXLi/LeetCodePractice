import java.util.*;

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
