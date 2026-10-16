

// 567 . Permutation in String

class Solution {
static boolean compareFreq(int[]count1, int[]count2){
    for(int i =0;i<26;i++){
     if(count1[i]!= count2[i]){
        return false;
       }
    }
    return true;
}


    public boolean checkInclusion(String s1, String s2) {
      // algowise
      //basics check ---> wheather s1 char parsent s2 or not
      //s1 ka table ready karo
      //s2 first window process
      // s2 remaning window ko process kar 
      if(s1.length() > s2.length()){
        return false;
    }

// s1 ka frequency table
    int count1[] = new int[26];
    for(int i =0;i<s1.length();i++){
        char ch = s1.charAt(i);
        int index = ch - 'a';
        count1[index]++;
    }
    // s2 ka frequency table
      int i = 0;
    int windowLength = s1.length();
    if(s1.length() > s2.length()){
        return false;
    }
    int count2[] = new int[26];
      
    for(i =0;i<windowLength;i++){
        char ch = s2.charAt(i);
        int index = ch - 'a';
        count2[index]++;
    }

    if(compareFreq(count1,count2)== true){
        return true;
    }
     else{
        // Both frequency are not matching
        //process remaning windoww
        while(i < s2.length()){
            // new window pr move kare ho toh new character ko frq table
            char newChar = s2.charAt(i);
            int newCharIndex = newChar -'a';
            count2[newCharIndex]++;
            // old character ki entry ko table se remove karo 
            int oldCharIndex = i - windowLength;
            char oldChar = s2.charAt(oldCharIndex);
            int freqTableIndexOfOldChar = oldChar -'a';
            count2[freqTableIndexOfOldChar]--;

            // aapke pass updated  table aaya h new window ke liye 
            // isko compare karo s1 k refrence table se 
            if(compareFreq(count1,count2) == true){
            return true;
           }  
           i++;
        }
    }
        return false ;
    }
}