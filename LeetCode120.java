  // 120. Triangle (LeetCode 120 (MidLevel ))
 // This problem are solved by recursion method 
 // the run runtime they are show that TimeLimt(TLE)


class Solution {
    static  int solve(List<List<Integer>> triangle,int rowIndex,int colIndex){
        // Base Case 
        // Last index 
        if(rowIndex == triangle.size()-1){
           return triangle.get(rowIndex).get(colIndex);
        }
        // 1 case tum sambhalo baki recursion sambhalege 
        int downAns = solve(triangle,rowIndex+1,colIndex);
        int diagonalAns = solve(triangle,rowIndex+1,colIndex+1);

         int recAns = triangle.get(rowIndex).get(colIndex) + Math.min(downAns , diagonalAns);

         return recAns;

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowIndex = 0;
        int colIndex = 0;
        int ans = solve(triangle,rowIndex,colIndex);
        return ans;
    }
}

// Another Approched solve this problem 
// sumbition time All test case Accepted 
// Dp method are solved this problem 


class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
     int[]dp = new int[n];
     // step 1 last row copy
     for(int j =0;j<n;j++){
        dp[j] = triangle.get(n-1).get(j);
        }
        // step 2 bootom to top 
        for(int i = n-2; i>=0;i--){
            for(int j =0;j<=i;j++){
                int down = dp[j];
                int diagonal = dp[j+1];

                dp[j] = triangle.get(i).get(j) + Math.min(down,diagonal);
            }
        }
        return dp[0];
    }
}