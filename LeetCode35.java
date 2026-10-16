
// 35. Search Insert Position



class Solution {
    public int searchInsert(int[] arr, int target) {
        int n  = arr.length;
        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                // move to right side
            
                s = mid +1;
            }else{
                // store potential solutio
                
                // move to lift side;
                e = mid -1;
            }
        }
        return s;
    
    }
}