
// Subsequence with Sum K
// Given an array arr[] and target sum k, check if there exists a subsequence such that the sum of all elements in the subsequence equals to k.
// Input: arr = [10, 1, 2, 7, 6, 1, 5], k = 8.
  //Output: true
// Explanation: Subsequences like [2, 6], [1, 7] sum upto 8
   //  (Mid level)

class Solution {
    
    static boolean solve(int[]arr,int k, int sum,int index){
        // Base Case
        if(index >= arr.length){
            //Subsequence ready hai 
            // Check sum 
            if(sum == k)
                return true;
            else
            return false;
        }
        // 1 case ham sambhalenge baaki ka recursion sambhalega 
        // Pattern include & Exclude 
        int currVal = arr[index];
        boolean Exclude = solve(arr,k,sum,index+1);
        boolean include  = solve(arr,k,sum + currVal,index+1);
        
        boolean ans = include || Exclude;
        return ans;
        
        
    }
    
    
    
    
    
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
         int index = 0;
         int sum = 0;
          boolean ans =   solve(arr,k,sum,index);
           return ans;
    }
}