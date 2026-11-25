
/*
   
20. Valid Parentheses (Easy level)

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false
 */



class Solution {
    public boolean isValid(String s) {
        Deque <Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            // if this is a open bracket 
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else{
                // if ch is closing bracket 
                // we are goicng to check stack ka top 
                // but best practice to check wheather stack is empty or not 

                if(st.isEmpty()){
                    return false;
                }
                if(ch == ')' && st.peek() != '('){
                    return false;
                }
                  if(ch == ']' && st.peek() != '['){
                    return false;
                }
                  if(ch == '}' && st.peek() != '{'){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        // check if stack is empty 
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
}
// Time compexity is O(N);