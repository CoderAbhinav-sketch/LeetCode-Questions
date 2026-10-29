
// 322. Coin Change on LeetCode(mid -Level)
// This problem soved as using (recursion & dp);



class Solution {
    static int solution(int [] coins, int amount,int[]dp){
        // Base Case 
        if(amount==0){
            return 0;
        }
        if(amount < 0){
      // Invalid Case 
          return Integer.MAX_VALUE-1;
        }
        if(dp[amount] != -1){
            return dp[amount];
        }
        int mini = Integer.MAX_VALUE-1;
  // Maan Lo hamare pass 1 ammount hai aur uss amount ke liye aur us amount ke liye ham sare coin ko try kar rahe hai taaki all hame posible combinatation mil sake min find karne ke liye 
    for(int coin :coins){
    int recAns = solution(coins , amount-coin ,dp);
     if(recAns != Integer.MAX_VALUE){
        // Valid case ---> Integer.MAX_VALUE;
        int totalCoinused = recAns + 1;

              mini = Math.min(mini,totalCoinused);

           }
       }

      return dp[amount] = mini;

    }
    public int coinChange(int[] coins, int amount) {
        int[]dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        int ans = solution(coins,amount,dp);

        return ans >= Integer.MAX_VALUE-1?-1:ans;

    }
}