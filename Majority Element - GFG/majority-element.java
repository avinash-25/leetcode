//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int majorityElement(int a[], int size) {
        int maxElement = 100000; // Assuming the maximum element in your input
        int[] count = new int[maxElement * 2 + 1]; // Adjust the size accordingly
        int maxCount = 0;
        int majorityElement = 0;

        for (int i = 0; i < size; i++) {
            count[a[i] + maxElement]++; // Shift to non-negative indices
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                majorityElement = i - maxElement; // Shift back to original range
            }
        }

        if (maxCount > size / 2) {
            return majorityElement;
        } else {
            return -1;
        }
    }

}
