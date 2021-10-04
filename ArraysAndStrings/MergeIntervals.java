// Link: https://leetcode.com/problems/merge-intervals/
// Difficulty: Medium
// Time complexity:
// Space complexity:

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int start = -1;
        int end = -1;
        int numPairs = 0;
         int[][] retVal = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                int curr = intervals[i][j];
                if (start == -1 && j == 0) {
                    start = curr;
                }
                else if (j == 1 && curr > end) {
                    end = curr;
                }
                else if (j == 0 && curr > end) {
                    retVal[numPairs] = new int[]{start, end};
                    numPairs++;
                    start = curr;
                    end = -1;
                }
            }
        }
        retVal[numPairs] = new int[]{start, end};
        numPairs++;
        int[][] newRet = new int[numPairs][2];
        int k = 0;
        while (k < numPairs) {
            newRet[k] = retVal[k];
            k++;
        }
        return newRet;
    }
}