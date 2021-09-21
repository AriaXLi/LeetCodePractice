// Link: https://leetcode.com/problems/add-two-numbers/
// Difficulty: Medium
// Time Complexity: O(n) --> whatever the length of the longest passed in LinkedList is
// Space Complexity: O(n) --> whatever the length of the new list is (which is at max 1 node longer than the longest LinkedList that's passed in)

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead, node1 = l1, node2 = l2;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int num1 = (node1 != null) ? node1.val : 0;
            int num2 = (node2 != null) ? node2.val : 0;
            int sum = carry + num1 + num2;
            carry = sum / 10; 
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}