
/*
40. Combination Sum II (mid level on  LeetCode )


Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

 */



class Solution {
static void solve(int[]candidates,int target,int index,List<List<Integer>> ans,List<Integer> output){
    // Base Case
    if(target == 0){
        ans.add(new ArrayList<>(output));
        return;
    }
    if(index >= candidates.length){
        return;
    }
    if(target < 0){
        return;
    }
// 1     case ham sambhalenge baaki recursion sambhalega 
   // Include & Exclude 
   output.add(candidates[index]);
   // include 
   solve(candidates,target-candidates[index], index+1,ans,output);

   // BackTracking 
   output.remove(output.size()-1);
   // not contail duplicate 
   while(index+1 < candidates.length && candidates[index] == candidates[index+1]){
    index++;
   }

// Exclude 
solve(candidates,target,index+1,ans,output);




}
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(candidates,target,index,ans,output);
        return ans ;
    }
}