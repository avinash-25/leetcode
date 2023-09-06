class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int partSize = length / k;
        int extraElements = length % k;

        // Step 3: Initialize the result array
        ListNode[] result = new ListNode[k];

        // Step 4: Iterate through the linked list to create parts
        temp = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = temp;
            
            // Calculate the size of this part
            int partLength = partSize + (i < extraElements ? 1 : 0);
            
            // Move current to the end of this part
            for (int j = 0; j < partLength - 1 && temp != null; j++) {
                temp = temp.next;
            }
            
            // Save the current part as an element in the result array
            if (temp != null) {
                ListNode next = temp.next;
                temp.next = null; // Cut off the list
                result[i] = partHead;
                temp = next;
            }
        }

        // Step 5: Return the result array
        return result;
    }
}
