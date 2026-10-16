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
    // crate get middle point to brak 
    public ListNode getMid(ListNode head){
        ListNode f = head;
        ListNode s = head;
        while(f!=null){
            f = f.next;
            if(f!=null){
                f = f.next;
                s = s.next;
            }
        }
        return s;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }








    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        if(head.next == null){
            return true;
        }
        // break at middle point
        ListNode list2 = getMid(head);

        // sepearte 
        ListNode temp = head;
        while(temp.next != list2){
            temp = temp.next;
        }
        temp.next = null;
        // reverse list2 

        ListNode head2 = reverse(list2);
        // compare 
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while(temp1!=null&& temp2!= null){
            if(temp1.val!= temp2.val){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;

    }
}