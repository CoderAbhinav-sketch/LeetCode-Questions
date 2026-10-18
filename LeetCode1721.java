
// 1721. Swapping Nodes in a Linked List


class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for(int i =1;i<= k-1;i++){
            first = first.next;
        }
        ListNode temp = first.next;
        ListNode sec = head;
        while(temp!= null){
            sec = sec.next;
            temp = temp.next;
        }
        // Swap Value 
        int tempVal = first.val;
        first.val = sec.val;
        sec.val = tempVal;

        return head;
    }
}