/*
32. Longest Valid Parentheses (Hard Level )

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 */
// This Problem are solved by Stack

class Solution {
    public int longestValidParentheses(String s) {
    // step 1 create stack
    // step 2 push(-1)
    // step 3 travel string 
    // covert to character
    // if(ch== 'c') push(i)
    // else{
    // pop(),empty check ,invalid case ,left part neglate
    // valid 
    // current len calculate = i-st.peek();
    // maxLen update
   
   Deque<Integer> st = new ArrayDeque<>();
   int maxLen = 0;
   st.push(-1);
   for(int i =0;i<s.length();i++){
    char ch = s.charAt(i);
    if(ch == '('){
        st.push(i);
    }else{
        st.pop();
        if(st.isEmpty()){
            // Invalid case
            // reset 
            st.push(i);
        }else{
            // valid 
            int currLen = i-st.peek();
            // max Update
            maxLen = Math.max(maxLen,currLen);

        }
    }
   }
  return maxLen;

    }
}
// Time Complexity = O(N)
// Space Complexity = O(N);

// Optimization Code through Variable 

class Solution {
    public int longestValidParentheses(String s) {
        // Another approch 
        // Step 1  (2 variable (open ,close))
        // step 2  (1 variable ( MaxLen)
        // step 3 travel (Left to right)
        // covert to character
        // step 5 condition (ch == '()') open++; else close ++;
        // step 6 Invalis aur valid conditio 
        //  if(close > open) reset open =0;close =0;
        // Valid hai to (open == close) maxLen = 2 * close 
        // Step 6 right to left 
        // step 7 ccondition check 
        // if (ch == '(') open++ else,close++
        // step 8 Valid or Invalid 
        // if(open > close) open =0;,close =0;
        // valid (2 * open)
        // find max len 
            int open =0;
            int close = 0;
            int maxLen = 0;
            // Left to rigth
            for(int i =0;i<s.length();i++){
                char ch = s.charAt(i);
                if(ch == '('){
                    open++;
                }else{
                    close++;
                }
                // Valid or Invalid 

                if(close > open){
                    // invalid 
                    // reset 
                    open =0;
                    close = 0;
                }else if(open == close){
                    maxLen = Math.max(maxLen,2*close);
                }
            }
            // rigth to left 
            open =0;
            close =0;
        
            for(int i = s.length()-1;i>=0;i--){
                char ch = s.charAt(i);
                if(ch == '('){
                    open++;
                }else{
                    close++;
                }
                // Valid or Invalid 
                if(open > close){
                    // Invalid
                    // reset 
                    open = 0;
                    close = 0;
                } else if(open == close){
                    maxLen = Math.max(maxLen,2* open);
                }
            }
            return maxLen;
    }
}

// Time Compexity = O(N)
// Space Complexity = O(1)