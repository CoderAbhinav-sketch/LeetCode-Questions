
/*
    . Insert at Bottom of Stack

Given a stack st containing n integers and an integer x, insert x at the bottom of the stack.


Note: While displaying the stack, the bottommost element is printed first.

Examples :

Input: st = [4, 3, 2, 1, 8], x = 2
Output: [2, 4, 3, 2, 1, 8]
Explanation: After insertion of 2, the final stack will be [2,4,3,2,1,8].
Input: st = [5, 3, 1], x = 4
Output: [4, 5, 3, 1]
Explanation: After insertion of 4, the final stack will be [4,5,3,1].
 */


class Solution {
     public static void helper(Stack<Integer> st,int value){
         // base Case 
         if(st.empty()){
             st.push(value);
             return;
         }
         // 1 case ham sambhale baaki recursion sambhalega 
         int topVal = st.peek();
         st.pop();
         // recursion call 
         helper(st,value);
         // insert previous element 
         st.push(topVal);
     }
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        // code here
        int value = x;
          helper(st,x);
          return st;
    }
}