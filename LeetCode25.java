
// 25. Reverse Nodes in k-Group (Hard Level)


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Length calculate
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        // condition check len < k;
        if(len < k){
            return head;
        }
        // k th length node reverse 
        ListNode prev = null;
        ListNode curr = head;
        for(int i =1;i<=k;i++){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        // remaning node recursion to solve 
      ListNode recursionKaHead =   reverseKGroup(curr,k);
        // join the node 
        head.next = recursionKaHead;
        // return modify LL
        return prev;
    }
}