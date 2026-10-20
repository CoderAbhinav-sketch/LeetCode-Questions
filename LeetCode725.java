
// 725. Split Linked List in Parts

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Steps Follow to Solve in this Problem ----->


        // 1.create ans List 
        // 2.Calculate length of LL
        // 3.Calculate Base Size
        // 4.Calculate Extra Node 
        // 5.Condition check curr== Null
        // 6.create sub list 
        // 7.return ans;

        ListNode []ans = new ListNode[k];
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int baseSize = (len/k);
        int extraNode = (len%k);

        ListNode prev = null;
        ListNode curr = head;

        for(int part = 0;part<k;part++){
            if(curr == null){
                ans[part] = null;
                continue;
            }
            ans[part] = curr;

            // Width calculate 
            int width = baseSize + (extraNode >0 ? 1 : 0);
            extraNode--;
            for(int i =1;i<=width;i++){
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            prev = null;
        }
      return ans;
    }
}