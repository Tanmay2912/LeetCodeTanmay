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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        ListNode curr = head, temp;
        int index = 1; 
        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = null;
            if (index % 2 == 1) {   
                oddTail.next = temp;
                oddTail = temp;
            } else {                
                evenTail.next = temp;
                evenTail = temp;
            }
            index++;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}
