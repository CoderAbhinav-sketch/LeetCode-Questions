
// 1051 . Height Checker

class Solution {
    public int heightChecker(int[] nums) {
        int n = nums.length;
        int[]res = new int[n];
        for(int i =0;i<n;i++){
            res[i] = nums[i];// copy
        }
        Arrays.sort(res);
        int count = 0;
        for(int i =0;i<n;i++){
        if(nums[i] != res[i]){
            count++;
        }
        }
        return count;
    }
}