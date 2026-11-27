/*
921. Minimum Add to Make Parentheses Valid

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 */


// This problem are solved by stack 

class Solution {
    public int minAddToMakeValid(String s) {
    Deque<Character> st = new ArrayDeque<>();
    int addition =0;
     for(char ch :  s.toCharArray()){
        if(ch == '('){
            st.push(ch);
        }else{
            // Agar hamare paas opening bracket hai stack mai 
            // to closing bracket ke liye hame 1 opening bracket cancel karna hoga 
            if(st.isEmpty()){
              addition++;
            }else{
                st.pop();
            }
        }
     }
     int finalAns = addition + st.size();
     return finalAns;

    }
}

// Time Complexity O(N)
// Space Complexity O(N)

// Another Apprcoh 
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int addition = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
            }else{
                // char == ')'
                if(open>0){
                    open--;
                }else{
                    addition++;
                }
            }
        }
        int finalAns = open+addition;
        return finalAns;
        
    }
}

// Time Complexity = O(N)
// Space Complexity = O(1)
