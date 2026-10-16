
// LeetCode 2181 . Merge Nodes in Between Zeros


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
    public ListNode mergeNodes(ListNode head) {
        ListNode read = head.next;
        ListNode write = head;

        // Condition Applied 
        while(read!=null){
            int sum = 0;

            while(read.val != 0){
                sum+= read.val;
                read = read.next;
            }
            // Insaert sum at write position
            write.val = sum;
            // deletion 
            write.next = read.next;
            // update read at 1 step;
            read = read.next;
            // update write at 1 step
            write = write.next;
        }
        return head;
    }
}