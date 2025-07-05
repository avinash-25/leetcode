class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];  // values are in range [1, 500]
        
        // Step 1: Count frequencies
        for(int num : arr) {
            freq[num]++;
        }
        
        // Step 2: Find largest lucky number
        for(int i = 500; i >= 1; i--) {
            if(freq[i] == i) {
                return i;
            }
        }
        
        return -1;
    }
}
