//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] frequency = new int[n]; // Create an array to keep track of the frequency of each element
        
        // Iterate through the input array
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n; // Calculate the index to update the frequency
            frequency[index]++;
        }
        
        // Check for duplicates based on the frequency array
        for (int i = 0; i < n; i++) {
            if (frequency[i] > 1) {
                result.add(i);
            }
        }
        
        if (result.isEmpty()) {
            result.add(-1); // If no duplicates are found, add -1 to the result
        }
        
        return result;
    }
}

