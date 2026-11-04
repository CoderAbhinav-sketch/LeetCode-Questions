
// 78 .Subset (LeetCode -- MidLevel )
  // This problem are solved by Recursion Method 
  // All Test Case Are passed 
  


 class Solution {
static void solve(int[]nums,int index, List<Integer> output, List<List<Integer>> ans){
    // Base Case 
    if(index >= nums.length){
        // Subsequence ready hai 
        //  isse Ans mai  add kar do 
        ans.add(new ArrayList<>(output));
        return;
    }
    // Ab 1 case ham solve karenge Baaki ka recursion karega 
    int currVal = nums[index];
    output.add(currVal);
    // include 
    solve(nums,index+1,output,ans);
    
    // Backtracking 
    output.remove(output.size()-1);
    // exclude 
    solve(nums,index+1,output,ans);

}

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(nums,index,output,ans);
        return ans;
    }
}