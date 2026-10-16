
// 1346. Check If N and Its Double Exist

class Solution {
    public boolean checkIfExist(int[] arr) {
        // Create a set
        Set<Integer> set = new HashSet<>();
        // Traverse all element
        for(int num : arr){
            if(set.contains(num * 2) || (set.contains(num /2) && (num % 2 == 0))){
                return true;
            }
            set.add(num);
        }
        return false;
        
    }
}