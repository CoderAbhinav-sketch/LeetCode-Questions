
  // 55. Jump Game (Mid Level On LeetCode )
//  This question are solve by Recursion Method 
    // Time Limit Exceeded   77 / 178 testcases passed



class Solution {
   static boolean solve(int[]nums,int index){
        // Base Case 
        // Reached positon 
        if(index == nums.length-1){
            return true;
        }
        // Index > Nums.length
        if(index >= nums.length-1){
            return false;
        }
        if(nums[index] == 0){
            return false;
        }


        // 1 case tum handle karo bakki recursion karega 
        int jumps = nums[index];
        // Itration max jump posible for current position
        boolean overAllans = false;
        for(int jump = 1;jump <= jumps; jump++){
       boolean recAns = solve(nums,index+jump);

       overAllans = overAllans || recAns;

        }
        return overAllans;
}



    public boolean canJump(int[] nums) {
        int index = 0;
        boolean  ans = solve(nums,index);
        return ans;
    }
}
// Optimized Approach (Greedy)
// All test case passed 

class Solution {
    public boolean canJump(int[] nums) {
        int mxReach = 0;
        for(int i =0;i< nums.length;i++){
            if(i > mxReach){
                return false;
            }
            mxReach = Math.max(mxReach , i+nums[i]);

            if(mxReach >= nums.length-1){
                return true;
            } 
        }
        return true;
    }
}