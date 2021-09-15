package LinkedListCycleII;
import java.util.*;  

//Link: https://leetcode.com/problems/linked-list-cycle-ii/
// Hash Table solution
// Time complexity: O(n)
// Space complexity: O(n)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head.next != null) {
            if (nodes.contains(head)) {
                return head;
            }
            nodes.add(head);
            head = head.next;
        }
        return null;
    }
}