
// 73 . Set Matrix Zeros 


class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstrow = false;
        boolean firstcol = false;
        // Step 1 check First row 
        for(int j =0;j<m;j++){
            if(matrix[0][j] == 0){
                firstrow = true;
                break;
            }
        }
        // Step 2 check firstColum
        for(int i =0;i<n;i++){
            if(matrix[i][0] == 0){
                firstcol = true;
                break;
            }
        }
        // step 3 marke row and colum
        for(int i =1;i<n;i++){
            for(int j =1;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // step marked row to zero
        for(int i =1;i<n;i++){
            if(matrix[i][0] == 0){
                for(int j =1;j<m;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        //step marked column
        for(int j =1;j<m;j++){
            if(matrix[0][j] == 0){
                for(int i =1;i<n;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        // first handle row 
        if(firstrow){
            for(int j =0;j<m;j++){
              matrix[0][j] = 0;
            }
        }
        if(firstcol){
            for(int i =0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
    }
}