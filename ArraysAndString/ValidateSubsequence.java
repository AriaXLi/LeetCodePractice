import java.util.*;

// Link: https://www.algoexpert.io/questions/Validate%20Subsequence
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class ValidateSubsequence {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		if (sequence.size() > array.size()) {
			return false;
		}
		int prevIndex = -1;
		int currIndex = -1;
		
		// iterates over array 
		for (int seqVal : sequence) {
			
			// looking for sequences
			boolean containsNum = array.contains(seqVal);
			if (containsNum) {
				if (prevIndex == -1) {
					prevIndex = array.indexOf(seqVal);
					array.remove(prevIndex);
				}
				else {
					currIndex = array.indexOf(seqVal);
					if (currIndex < prevIndex) {
						return false;
					}
					else {
						prevIndex = currIndex;
						currIndex = -1;
						array.remove(prevIndex);
					}
				}
			}
			else {
				return false;
			}
		}
    return true;
  }
}
