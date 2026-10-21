
// (430. Flatten a Multilevel Doubly Linked List --> (Medium Level))

class Solution {
    public Node flatten(Node head) {
        // Condition Checked
        if(head == null){
            return head;
        }
        Node p = head;
        // p has no child 
        while(p!= null){
            if(p.child == null){
                p = p.next;
            }else{
                // P has child 
                Node temp = p.child;
                while(temp.next!= null){
                    temp = temp.next;
                }
                // Link Manupulation
                temp.next = p.next;
                if(temp.next !=null)
                p.next.prev = temp;
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
        }
        return head;
    }
}