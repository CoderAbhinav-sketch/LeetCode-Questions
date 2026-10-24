
/*/

2643. Row With Maximum Ones

Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the number of ones in that row.

In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.

Return an array containing the index of the row, and the number of ones in it.

Example 1:

Input: mat = [[0,1],[1,0]]
Output: [0,1]
Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0, and the maximum count of ones (1). So, the answer is [0,1]. 

 */





class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        int max = 0;
        int maxWaliIndex = 0;

        for(int row = 0;row < mat.length;row++){
            int oneCount = 0;
            for(int col = 0;col< mat[0].length;col++){
                if(mat[row][col] ==  1){
                    oneCount++;
                }
            }
            if(oneCount > max){
                max = oneCount;
                maxWaliIndex = row;
            }
        } 
        return new int[]{maxWaliIndex, max};
    }
}