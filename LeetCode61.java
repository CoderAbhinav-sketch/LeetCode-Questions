
// 61. Rotate List


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int len = 1;
        ListNode temp = head;

        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        // Make it circular ll
        temp.next = head;
       // K ko update karo

         k = k % len;

        // Step 2 line break
        temp = head;
        for(int i =1;i<=len-k-1;i++){
            temp = temp.next;
        }
        ListNode forward = temp.next;
          temp.next = null;
          return forward;
    }
}