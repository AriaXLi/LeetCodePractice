// Link:
// Difficulty:
// Time complexity: O(n) --> whatever the length of the initial LinkedList is
// Space complexty: O(1)
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {

            // keeping track of where they are in the passed in LinkedList
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;

            // goes back to where they were in the passed in LinkedList
            curr = nextNode;
        }
        return prev;
    }
}