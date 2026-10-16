
// Sort Colors
class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int low  = 0;
        int  mid = 0;
        int high = n-1;

        while(mid <= high){
            //3 condition are applied 
            // 1st condition
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
                // 2nd condition arre applied
            }else if(arr[mid] == 1){
                mid++;
                // 3rd Conditon are applied
            }else{
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}