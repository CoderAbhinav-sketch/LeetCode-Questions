
// 1981. Minimize the Difference Between Target and Chosen Elements (Medium level on LeetCode)

 
// Solve this problem at Recursion 
// Time Limit Exceeded 14 / 81 testcases
 

class Solution {

static int solve(int sum,int target,int[][]mat,int row ){
    // Base Case 
   if(row>= mat.length){
    // Invalid Row
    // Sum is Ready
    // Find min diff btw sum and target;
    // return ans

    int ans = Math.abs(target-sum);
    return ans;
   }

   int mini = Integer.MAX_VALUE;
   // 1 case  khud sambhalo bakki recursion sambhalega 
    
    for(int num : mat[row]){
      int ans =  solve(sum+num,target,mat,row+1);
      mini = Math.min(mini, ans);
    }
    
    return mini;
}


    public int minimizeTheDifference(int[][] mat, int target) {
        int sum = 0;
        int row = 0;
        int ans = solve(sum,target,mat,row);
        return ans;
    }
}