import java.util.Arrays;

// Link: https://leetcode.com/problems/maximum-units-on-a-truck/
// Difficulty: Easy
// Time complexity: O(nlogn);
// Space complexity: O(1)

public class MaxUnitsTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        // sorting by unit size
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int boxesLeft = truckSize;
        int totalUnits = 0;
        
        // starting from end of sorted array because they are sorted from least to biggest unit size
        for (int i = boxTypes.length - 1; i >= 0 && boxesLeft > 0; i--) {
            int numBoxes = boxTypes[i][0];
            int numUnits = boxTypes[i][1];
            
            if (numBoxes > boxesLeft) {
                totalUnits += numUnits * boxesLeft;
                boxesLeft = 0;
            }
            else {
                boxesLeft -= numBoxes;
                totalUnits += numUnits * numBoxes;
            }
        }
        return totalUnits;
    }
}
