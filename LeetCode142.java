
// 142. Linked List Cycle II (Midium Level on LeetCode soln)


public class Solution {
    public ListNode detectCycle(ListNode head) {
        // detect cycle 
        ListNode f = head;
        ListNode s = head;
        boolean hasCycle = false;

        while(f != null){
            f = f.next;
            if(f != null){
                f = f.next;
                s = s.next;
            }
            if(f == s){
                hasCycle = true;
                break;
            }
        }
        if(hasCycle == false){
            return null;
        }
        // delect starting node 
      
          s = head;
          while(f != s ){
            f = f.next;
            s = s.next;
          }

       ListNode starting = s;

       return starting;

    }
}