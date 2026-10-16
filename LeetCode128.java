
// Longest Cosecutive Sequence 

class Solution {
    public int longestConsecutive(int[] nums) {
        // Ceeate a HashSet 
        HashSet<Integer>set = new HashSet<>();
        // Traver array to stored 
        for(int num : nums){
            set.add(num);
        }
        int maxLen = 0;
        for(int num : set){
            // Squence ka starting number 
            if(!set.contains(num-1)){
                int current = num;
                int count = 1;

            while(set.contains(current+1)){
                current++;
                count++;
            }
            maxLen = Math.max(maxLen,count);
            }
        }
        return maxLen;
    }
}