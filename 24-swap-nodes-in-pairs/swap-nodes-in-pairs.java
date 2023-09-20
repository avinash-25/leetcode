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
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode tempAdd = new ListNode();
        tempAdd = head;
        int tempVal=0;
        if(tempAdd == null){
            return head;
        }
        while(tempAdd != null && tempAdd.next != null){
            tempVal = tempAdd.val;
            tempAdd.val = tempAdd.next.val;
            tempAdd.next.val = tempVal;
            tempAdd = tempAdd.next.next;
        }
        return head;
    }
}