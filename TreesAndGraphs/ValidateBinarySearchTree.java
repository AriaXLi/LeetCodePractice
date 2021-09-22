// Link: https://leetcode.com/problems/validate-binary-search-tree/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class ValidateBinarySearchTree {
    
    public boolean isValidBSTHelper(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
}