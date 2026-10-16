/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int currJumps = n;

        ListNode curr = head;

        while(currJumps>0){
            curr = curr.next;
            currJumps--;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(curr!= null){
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}