/*
394. Decode String (Miduim level)

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */

class Solution {
    public String decodeString(String s) {
        // 1.Create count stack 
        // 2.create stringStack ---> StringBuilder
        // 3.crete number variable 
        // 4.create curr StringBuilder
        // 5. traversal 
        // . 4 case handle 
        //  if(Character.isDigit(ch))
            // No calculate = number *10 + (ch-'0')

            // case 2 else if(ch== '[') // opening bracket hai 
              // countStack.push(nmber)
              // StringStack.push(curr)
              // new value initalize
              // number = 0,curr = new StringBuilder();

        // case 3 else if(ch == ']') closing bracket
           // count repeation---> countStack.pop()
           // prev ----- stringStack.pop();
           // traversal i =1 to reoeation
           // prev.append(curr);

           // curr = prev;

           // case 4
           //curr.append(ch)

           Deque<Integer> countStack = new ArrayDeque<>();
           Deque<StringBuilder> stringStack = new ArrayDeque<>();
           int number = 0;
           StringBuilder curr = new StringBuilder();
           for (char ch : s.toCharArray()){
            // 4 case handle 
            // 1 case 
            if(Character.isDigit(ch)){
                number = number*10+(ch-'0');
            }
            // CASE 2
            else if(ch == '['){
                countStack.push(number);
                stringStack.push(curr);
                // initalize number 
                number =0;
                curr = new StringBuilder();          
                  }
           
           // Case 3 
           else if(ch == ']'){
            // count repeation 
            int repeation = countStack.pop();
            StringBuilder prev = stringStack.pop();
        // traversal i=1to repeation
        for(int i =1;i<=repeation;i++){
            prev.append(curr);
        }
        curr = prev;
           }else{
            // case 4 ;
            curr.append(ch);
           }
    }
       return curr.toString();
}
        }
