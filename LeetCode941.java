
// 941. Valid Mountain Array

class Solution {
    public boolean validMountainArray(int[] arr) {
        // 3 step arr followed by to solve this problem
        // step 1 ....
        // Increasing order
        int i = 0;
        int n =  arr.length;
        while(i+1<n && arr[i] < arr[i+1]){
            i++;
        }
        // step 2 
        // not inc and dec
        if(i == 0 || i == n-1){
            return false;
        }
        // step 3 
        // Decreasing Array
        while(i + 1 < n && arr[i] > arr[i+1]){
            i++;
        }
        return i == n-1;
    }
}