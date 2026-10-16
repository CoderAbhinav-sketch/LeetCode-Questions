/**
 * Odd Even LinkedList on LeetCode -----> 328
 * 
 * 
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
    public ListNode oddEvenList(ListNode head) {

      if(head == null){
        return head;
      }
      if(head.next == null){
        return head;
      }





      ListNode Oh = head;
      ListNode Ot = head;
      ListNode Eh = head.next;
      ListNode Et = head.next;

      //condition applied 
      while(Et!=null && Et.next != null){
         Ot.next = Et.next;
         Ot = Et.next;
         Et.next = Ot.next;
         Et = Ot.next;
      }
     // connect 
       Ot.next = Eh;
       return Oh;
        
    }
}