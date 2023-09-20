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
class Solution{
public ListNode swapNodes(ListNode head, int k) {
    // Initialize pointers for the kth node from the beginning and the end
    ListNode kthFromBegin = head;
    ListNode kthFromEnd = head;
    ListNode currentNode = head;

    // Move kthFromBegin to the kth node from the beginning
    for (int i = 1; i < k; i++) {
        if (kthFromBegin == null) {
            return head; // k is out of bounds
        }
        kthFromBegin = kthFromBegin.next;
    }

    // Move currentNode to k+1th node from the beginning
    currentNode = kthFromBegin.next;

    // Move both pointers until currentNode reaches the end
    while (currentNode != null) {
        kthFromEnd = kthFromEnd.next;
        currentNode = currentNode.next;
    }

    // Swap the values of kthFromBegin and kthFromEnd
    int temp = kthFromBegin.val;
    kthFromBegin.val = kthFromEnd.val;
    kthFromEnd.val = temp;

    return head;
}
}



// class Solution {
//     public ListNode swapNodes(ListNode head, int k) {
//         int i=1;
//         int count=0;
//         ListNode tempOne = new ListNode();
//         ListNode temptwo = new ListNode();
//         ListNode tempthree = new ListNode();
//         tempOne = temptwo = tempthree = head;
        
//         while(temptwo != null){
//             temptwo = temptwo.next;
//             count++;
//         }
//         if(count<0 || k>count)
//            return head;

//         while(i<k){
//             tempOne = tempOne.next;
//             i++;
//         }
//         i = (count-k+1);
//         while(i>1){
//             tempthree = tempthree.next;
//             i--;
//         }
//         i = tempOne.val;
//         tempOne.val = tempthree.val;
//         tempthree.val = i;
//         return head;
//     }
// }