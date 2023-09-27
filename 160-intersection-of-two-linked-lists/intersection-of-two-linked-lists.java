public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Step 1: Traverse both lists to find their lengths and last nodes.
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode tailA = getTail(headA);
        ListNode tailB = getTail(headB);
        
        // Step 2: If the last nodes are different, there's no intersection.
        if (tailA != tailB) {
            return null;
        }
        
        // Step 3: Reset pointers to the heads and advance the longer list.
        ListNode shorter = lengthA < lengthB ? headA : headB;
        ListNode longer = lengthA < lengthB ? headB : headA;
        for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
            longer = longer.next;
        }
        
        // Step 4: Iterate through both lists to find the intersection node.
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        
        return shorter; // This is the intersection node.
    }
    
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    
    private ListNode getTail(ListNode node) {
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
