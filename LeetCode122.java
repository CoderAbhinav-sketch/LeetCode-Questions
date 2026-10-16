
// 122. Best Time to Buy and Sell Stock II


class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // agar next day ka price bachane se aaj ka kharidne ke price se bada hota hai 
        // to mujhe profit hoga
        for(int i =1;i<prices.length;i++){
            if(prices[i]> prices[i-1]){
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }

     return maxProfit;
        
    }
}