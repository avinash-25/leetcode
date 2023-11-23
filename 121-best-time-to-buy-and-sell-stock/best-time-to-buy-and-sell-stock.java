class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; 
        int currPrice = prices[0];

        for(int i=1; i<prices.length; i++){
            if(currPrice < prices[i])
                maxProfit = Math.max(maxProfit, prices[i]-currPrice);
            else
                currPrice = prices[i];
        }
        return maxProfit;
        
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//        int len = prices.length;
//        if (len == 0) {
//             return 0;
//         }
//        int min = prices[0];
//        int minIndex = 0;
//         for(int i=1;i<len;i++){
//             if(min>prices[i]){
//                 min = prices[i];
//                 minIndex = i;
//             }
//         }
//         if(minIndex == len - 1)
//           return 0;
//         int max = prices[minIndex];
//         for(int i = minIndex+1;i<len;i++){
//            if(max < prices[i])
//              max = prices[i];
//         }
//         return max-min;
//     }
// }
