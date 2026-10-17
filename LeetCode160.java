
// 160. Intersection of Two Linked Lists


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Empty List 

        if(headA == null && headB == null){
            return null;
        }
       ListNode a = headA;
       ListNode b = headB;

      while(a!=null && b!=null){
        a = a.next;
        b = b.next;
      }
      //   B ki length calculate 
     if (a== null){
        int bExtraLen = 0;
        while(b!=null){
            bExtraLen++;
            b = b.next;
        }
        while(bExtraLen-- > 0){
            headB = headB.next;
        }
     }else{
        // A ki length badi ho tb 
       int aExtraLen = 0;
       while(a!=null){
        aExtraLen++;
        a = a.next;
       }
       while(aExtraLen-- > 0){
        headA = headA.next;
       }

     }

    // Match position
    while(headA!=null && headB !=null){
        if(headA == headB){
            return headA;
        }else{
            headA = headA.next;
            headB = headB.next;
        }
    }
    return null;

    }
}