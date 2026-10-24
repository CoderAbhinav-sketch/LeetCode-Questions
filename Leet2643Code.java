// Row with Max 1s in Rowwise Sorted
// Ye Question Gfg ka hai 
class Solution {
    // Find First Occurancess 
    
    static int getFirstOc(int[][]arr,int rowIndex){
        int totalRow = arr.length;
        int totalCol = arr[0].length;
        int target = -1;
        int ans = -1;
        
        // Case handle no 1's Present in row
        if(arr[rowIndex][totalCol-1] == 0){
            return totalCol;
        }else{
            int s = 0;
            int e = totalCol -1;
            
        while(s <= e){
            int mid = s + (e-s)/2;
            
            if(arr[rowIndex][mid] == 0){
                // Move to right side 
                s = mid +1;
            }else{
                  
               ans = mid ;
               // move to left side 
               
               e = mid -1;
                  
                  
            }
            
            }
            
        }
        return ans;
    }
    
    
    public int rowWithMax1s(int[][] mat) {
        // code here
        
       int totalrow = mat.length;
       int totalcol = mat[0].length;
       
        
        int max = -1;
        int maxWaliIndex = -1;
        
        // Travel Each Row 
        for(int row = 0; row < totalrow ; row++){
            
            // Find first Occurances 
            
            int firstOccur = getFirstOc(mat ,row );
            
            // calculate count of Ones
              int oneCount = totalcol - firstOccur;
              
              // Update ax Value 
              
              if(oneCount != 0 && oneCount > max){
                  max = oneCount;
                  maxWaliIndex = row;
              }
        }
        return maxWaliIndex;
    }
}