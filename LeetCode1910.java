
// 1910 . Remove All Occurrances of a Substring


class Solution {
    public String removeOccurrences(String s, String part) {
        // Kab tak same 2 step karenge
        // jab tak part exist karta ho s substring mai 

        while(s.contains(part)){
            // search part inside s 
            int index = s.indexOf(part);
            // Create a new substring;

            s = s.substring(0,index)+ s.substring(index + part.length());
        }
        return s;
    }
}