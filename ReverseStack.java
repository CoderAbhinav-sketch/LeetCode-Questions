/*
      Reverse a Stack
Given a stack st[], reverse the order of its elements.

Note: The input array represents the stack from bottom to top, where the last element is the top. The output should display the elements from top to bottom after reversing the stack.

Examples:

Input: st[] = [1, 2, 3, 4]
Output: [1, 2, 3, 4]
Explanation: After reversing, the elements of stack are in opposite order.

 */



class Solution {
    public static void insertBootom(Stack<Integer> st,int value){
            // base Case 
            if(st.empty()){
                st.push(value);
                return;
            }
            // 1 case ham sambhale baaki recursion sambhalega 
            int topVal = st.peek();
            st.pop();
            // recursion call 
            insertBootom(st,value);
            // insert previous element 
            st.push(topVal);
        }
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.empty()){
            return;
        }
        int topV = st.peek();
        st.pop();
        // baaki recursion 
        reverseStack(st);
        // insert
        insertBootom(st ,topV);
    }
}