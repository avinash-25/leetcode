//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int answer = -1;
        Map<Character, Integer> charCount = new HashMap<>();
        int distinctChars = 0;
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            while (j < n && (distinctChars < k || charCount.containsKey(s.charAt(j)))) {
                if (!charCount.containsKey(s.charAt(j))) {
                    distinctChars++;
                }
                charCount.put(s.charAt(j), charCount.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            
            if (distinctChars >= k) {
                answer = Math.max(answer, j - i);
            }
            
            charCount.put(s.charAt(i), charCount.get(s.charAt(i)) - 1);
            if (charCount.get(s.charAt(i)) == 0) {
                charCount.remove(s.charAt(i));
                distinctChars--;
            }
        }

        return answer;
    }
} 
