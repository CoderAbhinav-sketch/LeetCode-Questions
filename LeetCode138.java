
// 138. Copy List with Random Pointer (Medium Level on LeetCode)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node temp = head;
        while(temp!= null){
            Node cloneNode = new Node(temp.val);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }
        // Step 2 
        temp = head;
        while(temp!= null){
            Node oldN = temp;
            Node newN = temp.next;

            if(oldN.random!= null){
                newN.random = oldN.random.next;
            }
            temp = newN.next;
        }
        // Step 3
        temp = head;
        Node ansL = head.next;
        while(temp!= null){
            Node old = temp;
            Node clone = temp.next;
            // detech logic 
            old.next = clone.next;

            if(clone.next != null){
                clone.next = clone.next.next;
            }
            temp = temp.next;
        }
        return ansL;
    }
}