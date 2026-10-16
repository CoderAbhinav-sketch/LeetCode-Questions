
// 1047 . Remove All Adjecent Duplicates in String 

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);

            // compare ans k rightmost character ka current character se 
            if(ans.length()>0 && ans.charAt(ans.length()-1) == ch){
                ans.deleteCharAt(ans.length()-1);
            }
            else{
                //if these are 2 different char
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}