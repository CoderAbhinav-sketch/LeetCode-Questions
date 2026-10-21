
// (2058. Find the Minimum and Maximum Number of Nodes Between Critical Points --> Medium Level )

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Check condition
        if(head == null){
            return new int[]{-1,-1};
        }
        ListNode prev = head;
        ListNode curr = head.next;
        int i =1;
        List<Integer> CriticalPoints = new ArrayList<>();

        while(curr!=null && curr.next!=null){
            // Compare maxIma
            if(curr.val > prev.val && curr.val > curr.next.val){
                CriticalPoints.add(i);
            }
            // Compare minIma
            if(curr.val < prev.val && curr.val < curr.next.val){
                CriticalPoints.add(i);
            }
            curr = curr.next;
            prev = prev.next;
            i++;
        }
        if(CriticalPoints.size() <2){
            return new int[]{-1,-1};
        }
        // Find minDist
        int minDist = Integer.MAX_VALUE;
        for(int j =1;j<CriticalPoints.size();j++){
            minDist = Math.min(minDist,CriticalPoints.get(j) - CriticalPoints.get(j-1));
        }
        int maxDist  = CriticalPoints.get(CriticalPoints.size()-1) - CriticalPoints.get(0);

        return new int[]{minDist,maxDist};
    }
}