
//7 . Reverse Integer

class Solution {
    public int reverse(int x) {
    // 4 condition apply to solve in  this problem
     int rev = 0;
     while(x !=0){
        int digit = x%10;

        // is condition applied 
        if(rev > Integer.MAX_VALUE/10){
            return 0;
        }
        // 2nd case applied
        if(rev == Integer.MAX_VALUE /10 && digit > 7){
            return 0;
        }
        // 3rd negative case applied
        if(rev < Integer.MIN_VALUE/10){
            return 0;
        }
        // 4th case applied 
        if(rev == Integer.MIN_VALUE /10 && digit < -8){
            return 0;
        }
        rev = rev *10 + digit;
        x = x/10;
     }
     return rev;
    }
}