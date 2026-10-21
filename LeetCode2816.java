
// (2816. Double a Number Represented as a Linked List --> (Midium Level))


class Solution {
    public static ListNode  reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;

    }
    public ListNode doubleIt(ListNode head) {

        // Reverse
        head = reverse(head);

       // Create new Dummy ListNode
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
         // add double value ;
        ListNode temp = head;
        int carry = 0;
        while(temp!= null){
            int value = temp.val;
            int sum = value + value + carry;
            int digit = sum %10;

            // Insert at dummy node to digit 
            curr.next = new ListNode(digit);
            curr = curr.next;
            carry = sum/10;
            temp = temp.next;
        }
        // Extra condition 
        if(temp == null && carry!=0){
            curr.next = new ListNode(carry);
        }
        // remove dummy Node;
        dummy = dummy.next;
        // reverse dummy Node 
        head = reverse(dummy);

        return head;
    }
}
