
// 151 . Reverse  Words in a String

class Solution {
    public String reverseWords(String s) {
        // Create string builder
        StringBuilder ans = new StringBuilder();
        int i = s.length() -1;

        while(i>=0){
            // Reove space
            while(i>=0 && s.charAt(i)== ' '){
                i--;
            }
            // check value of i
            if(i<0){
                break;
            }
            int j =i;
            // find the start index of the word
            while(j>=0 && s.charAt(j)!= ' '){
                j--;
            }
            // jaise hi j space index par aayega to ruk jayega
            // ab is word ko apne ans mai append karo
            ans.append(s.substring(j+1,i+1));
            // remove faltu ka space j is space  add in ans
            while(j>=0 && s.charAt(j)== ' '){
                j--;
            }
            if(j>=0){
                ans.append(' ');
            }
            i = j;
        }
        return ans.toString();
    }
}