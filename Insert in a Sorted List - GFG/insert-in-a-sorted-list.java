//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

class Solution {
    Node sortedInsert(Node head1, int key) {
        Node newNode = new Node(key);
        
        // If the new node should be the new head
        if (key < head1.data) {
            newNode.next = head1;
            newNode.data = key;
            return newNode;
        }
        
        Node current = head1;
        
        // Find the correct position to insert the new node
        while (current.next != null && current.next.data < key) {
            current = current.next;
        }
        
        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;
        
        return head1;
    }
}
