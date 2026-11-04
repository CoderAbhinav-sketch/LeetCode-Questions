
// 90. Subsets II on leetCode Solution(Mid Level)
//  This problem are solved by recursion Method 


/*/
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

 The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

/*/
class Solution {
    static void solve(int[]nums,int index,  List<Integer> output ,List<List<Integer>> ans ){
        // Base Case
        if(index >= nums.length){
            // Subsequence ready hai 
            // Isse ans mai stored kar do 
            ans.add(new ArrayList<>(output));
            return;
        }
        // Ab 1 case ham sambhalenge bakki recursion sambhalega 
        int currVal = nums[index];
       // Include & Exclude pattern
       output.add(currVal);

       // include 
       solve(nums,index+1,output,ans);
       // Back tracking step
          output.remove(output.size()-1);
       // While exclude , same elemnt and move on the new element
       while(index +1 < nums.length && nums[index] == nums[index+1]){
            index++;
       }
       // Exclude 
       solve(nums,index+1,output,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(nums,index,output,ans);
        return ans;
    }
}