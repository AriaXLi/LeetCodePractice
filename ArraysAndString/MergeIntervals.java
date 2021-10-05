import java.util.Arrays;
import java.util.LinkedList;

// Link: https://leetcode.com/problems/merge-intervals/
// Difficulty: Medium
// Time complexity: O(nlogn) --> the logn comes from sort
// Space complexity:

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> ret = new LinkedList<>();
        for (int[] interval : intervals) {
            if (ret.isEmpty() || ret.getLast()[1] < interval[0]) {
                ret.add(interval);
            }
            else {
                ret.getLast()[1] = Math.max(ret.getLast()[1], interval[1]);
            }
        }
        return ret.toArray(new int[ret.size()][2]);
    }
}