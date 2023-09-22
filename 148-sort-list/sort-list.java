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
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        int count=0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        temp = head;
        int[] ar = new int[count];
        for(int i=0;i<count;i++){
            ar[i] = temp.val;
            temp = temp.next;
        }
        temp =head;
        Arrays.sort(ar);
        for(int i=0;i<count;i++){
            temp.val = ar[i];
            temp = temp.next;
        }
        return head;
    }
}