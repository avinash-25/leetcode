import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Create a HashSet to store visited nodes
        HashSet<ListNode> visitedNodes = new HashSet<>();

        ListNode current = head;

        while (current != null) {
            // If the current node is already in the set, a cycle is detected
            if (visitedNodes.contains(current)) {
                return true;
            }

            // Otherwise, add the current node to the set and move to the next node
            visitedNodes.add(current);
            current = current.next;
        }

        // No cycle was detected
        return false;
    }
}
