//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends




class Solution {
    // Function to check if two arrays are equal or not.
    public static boolean check(long A[], long B[], int N) {
        if (A.length != B.length) {
            return false; // If arrays have different lengths, they can't be equal.
        }
        
        // Create a HashMap to store the frequency of elements.
        HashMap<Long, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1); // Count occurrences of elements in array A.
            freqMap.put(B[i], freqMap.getOrDefault(B[i], 0) - 1); // Decrement for array B.
        }
        
        // Check if the frequency map contains only zeros.
        for (int freq : freqMap.values()) {
            if (freq != 0) {
                return false; // If any non-zero frequency, arrays are not equal.
            }
        }
        
        return true; // Frequency map contains all zeros, arrays are equal.
    }
}

