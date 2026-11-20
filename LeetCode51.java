
/*
. 
51. N-Queens (Hard Level on LeetCode )


The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 (Hard Level on Leetcode )

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 */

/*
    This problem are solved by Recursion and Bactracking  */

class Solution {

static boolean isSafeToPlace(int rowIndex,int colIndex,int n,char[][] board){
    // left lower horizontal
    int row = rowIndex;
    int col = colIndex;
    while(col >=0){
       if(board[row][col] == 'Q'){
        return false;
      }
      col--;
    }
    // left upper diagonal 
    row = rowIndex;
    col = colIndex;

    while(row >=0 && col >=0){
        if(board[row][col] == 'Q'){
            return false;
        }
        row = row-1;
        col = col-1;
    }
    // left lower 
    row = rowIndex;
    col = colIndex;

    while(row <n && col >=0){
        if(board[row][col] == 'Q'){
            return false;
        }
        row = row +1;
        col = col -1;
    }
    return true;

}


static void solve(char[][] board,int n,int colIndex,List<List<String>> ans){
    // Base case 
    if(colIndex >= n){
        // To iska mtlb hame 1 valid queen  mil gyi hai to isse ham ans mai store kar sakte hai string mai convert karke 
        List<String> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
         temp.add(new String (board[i]));
        }
        ans.add(temp);
        return;
    }
// 1 case ham solve karenge baaki ka recursin se karwayenge 
// current colum ke har cell pr jaake ya fir current col ke har row pe jaake queen place karenge 
   for(int rowIndex = 0;rowIndex < n;rowIndex++){
     if(isSafeToPlace(rowIndex,colIndex,n,board)){
    // Place queen
      board[rowIndex][colIndex] = 'Q';
    // Baaki recursin sambhalega 
    solve(board,n,colIndex+1,ans);
    // BackTracking Approch
     board[rowIndex][colIndex] = '.';
     }
     }

}

    public List<List<String>> solveNQueens(int n) {
        //  1. Create  a char Board 
        char [][] board = new char[n][n];

        for(int i=0;i<n;i++){
        Arrays.fill(board[i],'.');
        }

        int colIndex = 0;
        List<List<String>> ans = new ArrayList<>();
        solve(board ,n, colIndex,ans);
        return ans ;
    }
}
 /*
 Current:
Backtracking
/
Recursion
Suggested:
Backtracking
/
Recursion
Key Idea:
Place queens column by column, checking safety constraints, and backtrack when a valid placement is impossible.
Consider:
Can you optimize the isSafe check to O(1) using boolean arrays for columns and diagonals instead of scanning?


Current complexity:
O
(
N
2
)
O(N 
2
 )
Suggested complexity:
O
(
N
2
)
O(N 
2
 )
Suggestions:
Excellent work. The complexity is optimal for generating all solutions. No further algorithmic changes needed.
  */