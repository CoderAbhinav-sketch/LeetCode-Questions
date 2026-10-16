

//905. Sort Array By Parity

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int idx = 0;
        int n = nums.length;
        int[]res = new int[n];
        for(int i =0; i<n;i++){
            if(nums[i] %2 == 0){
                res[idx] = nums[i];
                idx++;

            }
        }
        for(int i =0;i<n;i++){
            if(nums[i] % 2== 1){
                res[idx] = nums[i];
                idx++;
            }     
               }

        return res;
    }
}