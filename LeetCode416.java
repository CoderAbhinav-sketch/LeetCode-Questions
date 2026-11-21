   
// 416. Partition Equal Subset Sum (Midum Level On LeetCode)


// This prblm are solve at recursion method 
// Time limit excceced 

class Solution {
    static boolean solve(int target,int[]nums,int index){
        // Base case
        if(target == 0){
            return true;
        }
        if(target < 0){
            return false;
        }
        if(index >= nums.length){
            return false;
        }
        // 1 case tum sambhalo baki recursion sambhalege 
        // Include & Ecxlude method
        boolean include = solve(target- nums[index], nums ,index+1);
        boolean  exclude = solve(target,nums,index+1);

        return include || exclude;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+= num;
        }
        if(sum%2== 1){
            return false;
        }
        int index = 0;
        int target = sum/2;

        boolean  ans = solve(target,nums,index);
        return ans;
    }
}
  
  // Same problem are solved by (Recursion & Dp)
  // They sumbition Are Accepted No Time limit EXcessed

class Solution {
    static boolean solve(int target,int[]nums,int index,Boolean[][] dp){
        // Base case
        if(target == 0){
            return true;
        }
        if(target < 0 || index >= nums.length){
            return false;
        }
        if(dp[index][target]!= null){
            return dp[index][target];
        }
        // 1 case tum sambhalo baki recursion sambhalege 
        // Include & Ecxlude method
        boolean include = solve(target- nums[index], nums ,index+1,dp);
        boolean  exclude = solve(target,nums,index+1,dp);

        return dp[index][target] = include || exclude;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+= num;
        }
        if(sum%2== 1){
            return false;
        }
        int index = 0;
        int target = sum/2;
        Boolean [][]dp = new Boolean[nums.length][target+1];

        return solve(target,nums,index ,dp) ;
        
    }
}