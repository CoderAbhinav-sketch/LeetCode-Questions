
// 66 .Plus ONE

class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length;
        for(int i = n-1;i>=0;i= i-1){
            if(arr[i] == 9){
                arr[i] = 0;
            }else{
                arr[i] = arr[i] + 1;
                return arr;
            }
        }
        int[]res = new int[n+1];
        res[0] = 1;
        return res;
        
    }
}