
// 1089. Duplicate Zeros

class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int posibleDups = 0;
        int lastIdx = n-1;

        // Itrate idex to cut last discard value
        for(int i =0; i<= lastIdx - posibleDups; i++){
            if(arr[i] == 0){
                // edge case
                if(i == lastIdx - posibleDups){
                    arr[lastIdx] = 0;
                    lastIdx-= 1;
                    break;
                }
                posibleDups++;
            }
        }
        int newLastIdx = lastIdx - posibleDups;
         for(int i = newLastIdx ;i>=0;i--){
            if(arr[i] == 0){
                arr[i+ posibleDups] = 0;
                posibleDups --;
                arr[ i +posibleDups] = 0;
            }else{
                arr[i+posibleDups] = arr[i];
            }
         }
    }
}