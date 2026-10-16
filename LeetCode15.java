
// 3 sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>uniqueTriplets = new HashSet<>();
        int n = nums.length;
    for(int i =0;i<n;i++){
        int tar = -nums[i];
        Set<Integer> s = new HashSet<>();
        for(int j = i+1;j<n;j++){
            int third = tar - nums[j];
        if(s.contains(third)){
            List<Integer>trip = Arrays.asList(nums[i],nums[j],third);
            Collections.sort(trip);
             uniqueTriplets.add(trip);
            }
            s.add(nums[j]);
        }  
        }
        return new ArrayList<>(uniqueTriplets);
    }
}