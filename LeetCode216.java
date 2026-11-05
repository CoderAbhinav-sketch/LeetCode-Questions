
/*
216. Combination Sum III on LeetCode (Mid level solutiuon)



Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

 */

class Solution {
    static void solve(int[]candidates,int target,int index,List<List<Integer>> ans,List<Integer> output ,int count,int k){
    // Base Case
    if(count > k){
        return;
    }
    if( count == k && target == 0){
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
   solve(candidates,target-candidates[index], index+1,ans,output,count+1,k);

   // BackTracking 
   output.remove(output.size()-1);
   // not contail duplicate 
   while(index+1 < candidates.length && candidates[index] == candidates[index+1]){
    index++;
   }

// Exclude 
    solve(candidates,target,index+1,ans,output,count ,k);
    }



    public List<List<Integer>> combinationSum3(int k, int n) {
           List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        int target = n;
        int []candidates = {1,2,3,4,5,6,7,8,9};
        int count = 0;
        solve(candidates,target,index,ans,output,count,k);
        return ans ;
    }
}