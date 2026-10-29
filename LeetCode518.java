
// 518. Coin Change II on LeetCode(Mid Level)
// This problem solved by (recursion & Dp)


class Solution {

  static int solution(int amount,int[]coins,int index,int [][]dp){
    // Base Case 

    if(amount == 0){
        return 1;
    }
    if(amount < 0){
        return 0;
    }
    if(index >= coins.length){
        return 0;
    }
    if(dp[index][amount] != -1){
        return dp[index][amount];
    }

    // 1 case ham solve karenge baaki Ka recursion karega 
    // Maanlo hamare pass 5 coins hai aur jo ammount hai 40 hai 
    // Agar mai 5 coins include karu to 40 -5 = 35 hai joyeg 

    int include = solution(amount-coins[index],coins,index,dp);

    // Ab Maan lo ki ammount 40 hai mai current coin ko use nhi kar rha hu 
    // Iska Mtlb amount mai koi change nhi hoga 
    // But kyokimai cuurnt coin lo exclude kar rha hu to isliye mujhe next coin pe move karna hoga 

    int exclude = solution(amount,coins,index+1,dp);

    return dp[index][amount] = include + exclude; 

  }
    public int change(int amount, int[] coins) {
        int[][]dp = new int[coins.length][amount+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
    
        return solution(amount,coins,0,dp);
    }
}