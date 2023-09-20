public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Detect the intersection point if there's a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // There's a cycle, exit the loop
            }
        }

        // Check if there's no cycle
        if (fast == null || fast.next == null) {
            return null; // No cycle
        }

        // Move one pointer back to the head and advance both pointers at the same pace
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // The node where they meet is the start of the cycle
        return slow;
    }
}
