class Solution {
    public ListNode oddEvenList(ListNode head) {
        int idx=1;

        ListNode headO=new ListNode(-1);
        ListNode headE=new ListNode(-1);

        ListNode tailO=headO;
        ListNode tailE=headE;

        ListNode start=head;

        while(start!=null){
            ListNode n=new ListNode(start.val);
            if(idx%2!=0){
                tailO.next=n;
                tailO=n;
            }
            else{
                tailE.next=n;
                tailE=n;
            }
            idx++;
            start=start.next;
        }
        tailO.next=headE.next;
        return headO.next;
    }
}