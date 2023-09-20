// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int i=1;
        int count=0;
        ListNode tempOne = new ListNode();
        ListNode temptwo = new ListNode();
        ListNode tempthree = new ListNode();
        tempOne = temptwo = tempthree = head;
        
        while(temptwo != null){
            temptwo = temptwo.next;
            count++;
        }
        if(count<0 || k>count)
           return head;

        while(i<k){
            tempOne = tempOne.next;
            i++;
        }
        i = (count-k+1);
        while(i>1){
            tempthree = tempthree.next;
            i--;
        }
        i = tempOne.val;
        tempOne.val = tempthree.val;
        tempthree.val = i;
        return head;
    }
}