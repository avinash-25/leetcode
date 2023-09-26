/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list.
        }

        ListNode sortedList = null; // Initialize the sorted list.

        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = null; // Disconnect current node from the original list.

            if (sortedList == null || current.val < sortedList.val) {
                // If the current node is smaller than the sorted list's head,
                // update the sorted list's head.
                current.next = sortedList;
                sortedList = current;
            } else {
                // Traverse the sorted list to find the right position to insert the current node.
                ListNode temp = sortedList;
                while (temp.next != null && current.val > temp.next.val) {
                    temp = temp.next;
                }
                // Insert the current node into the sorted list.
                current.next = temp.next;
                temp.next = current;
            }
        }

        return sortedList;
    }
}
