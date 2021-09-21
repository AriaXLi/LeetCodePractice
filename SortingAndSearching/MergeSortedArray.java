// Link: https://leetcode.com/problems/merge-sorted-array/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // make a copy of nums1 so nums1 can be used to hold the sorted array
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++){
            nums1Copy[i] = nums1[i];
        }
        
        int pos1 = 0;
        int pos2 = 0;
        
        // move through both nums1Copy and nums2 and compare them
        for (int i = 0; i < nums1.length; i++) {
            if (pos2 >= n || (pos1 < m && nums1Copy[pos1] < nums2[pos2])) {
                nums1[i] = nums1Copy[pos1];
                pos1++;
            }
            else {
                nums1[i] = nums2[pos2];
                pos2++;
            }
        }
    }
}