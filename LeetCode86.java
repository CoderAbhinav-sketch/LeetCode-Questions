
// 86. Partition List


class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessH = new ListNode(-1);
        ListNode lessT = lessH;

        ListNode greH = new ListNode(-1);
        ListNode greT = greH;


        ListNode temp = head;
        while(temp!= null){
            // Seperate 

            if(temp.val < x){
                ListNode InsertToNode = temp;
                temp = temp.next;
                InsertToNode.next = null;

                // Insert to lessT
                lessT.next = InsertToNode;
                lessT = InsertToNode;
            }else{
                ListNode InsertToNode = temp;
                temp = temp.next;
                InsertToNode.next = null;

                // Insert to greT 
                greT.next = InsertToNode;
                greT = InsertToNode;
            }
        }
        // Merged Node 
        // Join Them 
        lessT.next = greH.next;
         greT.next = null;

         //Delete less Head 
         lessH = lessH.next;

         return lessH;
    }
}