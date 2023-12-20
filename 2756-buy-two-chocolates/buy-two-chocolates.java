class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int min = Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i] + prices[i+1] <= money){
                if(min < money - (prices[i] + prices[i+1])){
                   min = money - (prices[i] + prices[i+1]);
                 }
            }
        }
        if(min >= 0)
         return min;
        else
         return money;
    }
}