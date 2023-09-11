class Solution {
    public int maximumWealth(int[][] accounts) {
        //person = row;
        //account = col;
        int ans = Integer.MIN_VALUE;
        for(int[] ints: accounts){
            int sum = 0;
            for(int anInt:ints){
                sum += anInt;
            }
            if(sum>ans){
                ans = sum;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int maximumWealth(int[][] accounts) {
//         // person = row;
//         // account = col;
//         int ans = Integer.MIN_VALUE;
        
//         // Loop through each person (row)
//         for (int i = 0; i < accounts.length; i++) {
//             int sum = 0;
            
//             // Loop through each account (column) for the current person
//             for (int j = 0; j < accounts[i].length; j++) {
//                 sum += accounts[i][j]; // Add the account balance to the sum
//             }
            
//             if (sum > ans) {
//                 ans = sum; // Update the maximum wealth if necessary
//             }
//         }
        
//         return ans; // Return the maximum wealth among all the people
//     }
// }
