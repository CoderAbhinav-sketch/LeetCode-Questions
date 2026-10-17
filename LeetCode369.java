/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/


// 369 . Plus One on Linked List 

class Solution {
    public Node rev(Node head){
        Node prev = null;    
        Node curr = head;
        
        while(curr!=null){
            Node forw = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    
    public Node addOne(Node head) {
        // code here.
        //reverse 
        head = rev(head);
        // plus one approch
        Node curr = head;
        int carry = 1;
        
        while(curr!= null){
            int NodeValue = curr.data;
            int sum = NodeValue + carry;
            
            int digit = sum %10;
            
            // inseart this  digit in curr node 
            curr.data = digit;
            
            // find out if there is any carry to pass or not 
            
            carry = sum /10;
            
            if(curr.next == null && carry >0){
                curr.next = new Node(carry);
                carry = 0;
            }
            curr = curr.next;
        }
        
        // reverse 
        head = rev(head);
        return head;
    
        
    }
}