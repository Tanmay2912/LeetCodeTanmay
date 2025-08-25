/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node copyNode;
        Node temp = head;

        while (temp != null) {
            copyNode = new Node(temp.val);
            copyNode.next = temp.next;   
            temp.next = copyNode;
            temp = copyNode.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;  
            }
            temp = temp.next.next;
        }

        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        temp = head;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
