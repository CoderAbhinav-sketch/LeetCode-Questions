/*

   Count Inversions (Difficulty: Medium)


Given an array of integers arr[]. You have to find the Inversion Count of the array. Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
 */

class Solution {
        static int merge(int[]arr,int s,int e,int mid){
            // left array and right array create 
            int leftALen = mid-s+1;
            int rightALen = e-mid;

            int Larr[] = new int[leftALen];
            int Rarr[] = new int[rightALen];

            // value copy to original array 
            int k =s;
            for(int i =0;i<leftALen;i++){
                Larr[i] = arr[k];
                k++;
            }
             
            for(int j =0;j<rightALen;j++){
                Rarr[j] = arr[k];
                k++;
            }
            // merge logic 
            int i =0;
            int j = 0;
            int kk =s;
            int invCount = 0;
            while(i <leftALen && j < rightALen){
                if(Larr[i] <= Rarr[j]){
                    arr[kk] = Larr[i];
                
                    i++;
                    kk++;
                }
                else {
                    arr[kk] = Rarr[j];
                    j++;
                    kk++;

                    invCount = invCount + (leftALen -i);
                }
            }
            while(i < leftALen){
                arr[kk] = Larr[i];
                i++;
                kk++;
            }
            while(j < rightALen){
                arr[kk] = Rarr[j];
                j++;
                kk++;
             
            }
            return invCount;
        }
        static int mergeSort(int[]arr,int s,int e){
            // Base Case
            if(s > e){
                // invalid array
                return 0;
            }
            if(s == e){
                return 0;
            }
            // Break array are 2 part 
            int mid = (s+e)/2;
            // Left array sort karwate hai 
             int  leftInv =  mergeSort(arr,s,mid);
              //Right array sort karwate hai 
              int rightInv = mergeSort(arr,mid+1,e);
              // Merge both parts 
            int intermidateInv = merge(arr,s,e,mid);
            int invCount = leftInv + rightInv + intermidateInv;
            return invCount;
        }
    public int inversionCount(int arr[]) {
        // code here
        int s =0;
        int e = arr.length-1;
      int ans =   mergeSort(arr,s,e);
      return ans;
    }
}