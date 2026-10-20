
// 2. Add Two Numbers


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        //Create Dummy Node
        ListNode ansH = new ListNode(-1);
        ListNode ansT = ansH;

        while(l1 != null || l2 != null || carry != 0){
            int sum = 0;
            if(l1 != null){
             sum += l1.val;
             l1 = l1.next;
            }
            if(l2 != null){
                sum+= l2.val;
                l2 = l2.next;
            }
            sum+= carry;
            int digit = sum %10;
               carry = sum / 10;
            ListNode newNode = new ListNode(digit);
             ansT.next = newNode;
             ansT = newNode;

        }
        // remove dummy Nodes 
         ansH = ansH.next;

         return ansH;
    }
}