
/* 
17. Letter Combinations of a Phone Number(Medium level on LeetCode )

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]
 */


class Solution {
  static void solve(String digits,int index,String[] mapping,List<String> result,StringBuilder output ){
    // Base case 
    // Jab hamara ip string ka index string ke length se bahar nikal jaayega tab isse hame 
    // output string wali list mai store kar lenge 
     
     if(index >= digits.length()){
        result.add(output.toString());
        return;
     }
  // 1 block ham sambhalenge baaki ka recursion sambhalege 
  // iske liye hame pahle cuurnt value ke index pe jaana hoga 
  // uske baad usse string mai maaping karke store karna hboga 

  int value = digits.charAt(index)- '0';
  String mappedString = mapping[value];

  // current value and and usska mapped String mere pass ready hai 
  // // current block mai usse rakh dete haibaaki recursion sambhalega 
   for(int i =0;i<mappedString.length();i++){
    output.append(mappedString.charAt(i));

// recursion call
    solve(digits,index+1,mapping,result,output);
    //Backracting remove
    output.deleteCharAt(output.length()-1);
    }

  }

    public List<String> letterCombinations(String digits) {
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        StringBuilder output   = new StringBuilder();

        int index = 0;
        solve(digits,index,mapping,result,output);
        return result;
    }
}