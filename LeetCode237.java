/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        // 4--> 5--> -->1-->9
        //       n
        // 4--->1--->1---->9
        // 4---->1-------->9
        node.val= node.next.val;
        node.next = node.next.next;
    }
}