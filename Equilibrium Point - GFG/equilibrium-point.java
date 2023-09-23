//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        long totalSum = 0;
        long leftSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        // Iterate through the array and check for equilibrium point
        for (int i = 0; i < n; i++) {
            // Subtract the current element from the total sum to get the right sum
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                return i + 1; // Equilibrium point found at index i
            }

            leftSum += arr[i]; // Update the left sum
        }

        return -1; // No equilibrium point found
    }
}

