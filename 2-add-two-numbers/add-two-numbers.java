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
    public void insertAtEnd(ListNode dummy, int sum, int carry) {
        int data = sum + carry;
        ListNode newNode = new ListNode(data);
        ListNode temp = dummy;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;

        ListNode dummy = new ListNode(-1);
        int carry = 0;
        
        while (first != null || second != null) {
            int x = (first != null) ? first.val : 0;
            int y = (second != null) ? second.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            int digit = sum % 10;

            insertAtEnd(dummy, digit, 0);

            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        if (carry > 0) {
            insertAtEnd(dummy, carry, 0);
        }

        return dummy.next;
    }
}
