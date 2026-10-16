
// 1299. Replace Elements with Greatest Element on Right Side

class Solution {
    public int[] replaceElements(int[] arr) {

        int max = -1;
        int n = arr.length;
        // traverse in the for n-1 index
        for(int i = n-1;i>=0;i--){
            // element are stored in temp variable
            int temp = arr[i];
            arr[i] = max;
            // update max value;
            max = Math.max(max, temp);
        }
        return arr;
    }
}