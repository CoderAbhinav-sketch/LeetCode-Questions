
/*

37. Sudoku Solver (On LeeTcode (Hard Level ))


Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:
   

   This Problem are solved by Recursion and Backtracking Mehod on Leetcode solution(Hard Leval )

 */






class Solution {
    // Find Empty cell
    static boolean FindemptyCell(char[][] board, int[]emptyCell){
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    // store empty cell in row
                    emptyCell[0] = i;
                    // store empty cell in col
                    emptyCell[1] = j;
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isSafeToPlace(char[][]board, char charValue,int rowIndex,int colIndex){
        // Check for horizonal same row 
        for(int col =0;col<9;col++){
            if(board[rowIndex][col] == charValue){
                return false;
            }
        }
        // Check for vertical Same column 
        for(int row =0;row <9;row++){
            if(board[row][colIndex] == charValue){
                return false;
            }
        }
        // Check for current 3*3 vala sub box 
        int sRow = rowIndex -rowIndex%3;
        int sCol = colIndex  - colIndex%3;

        for (int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                int aRow = sRow+i;
                int aCol = sCol+j;
                if(board[aRow][aCol] == charValue){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean solveSudokuProb(char[][] board){
        // Base case 
        // mai tab maanunga ki mera puzzle solved hai jab saare empty cell fill hojayenge
        // Where there is no empty space inside the board then problem is solved 
        int[] emptyCell = new int [2];
        if(!FindemptyCell(board,emptyCell)){
            return true;
        }
    // empty cell  ke andar fill karna 
    // let say i found in empty cell
    int rowIndex = emptyCell[0];
    int colIndex = emptyCell[1];

// convert integer to String 
  for(int value =1;value <=9;value++){
    char charValue = (char)(value + '0');
    if(isSafeToPlace(board,charValue,rowIndex,colIndex)){
        // place kardo 
        // recursion technique 
        board[rowIndex][colIndex] = charValue;
        // Bakki recursion sambhalega 
        if(solveSudokuProb(board) == true){
            return true;
        }
        // Backtracking approch 
        board[rowIndex][colIndex] = '.';
     }
        }
        return false;

    }
    public void solveSudoku(char[][] board) {
        solveSudokuProb(board);
    }
}