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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 0;
        ListNode temp = head;
        ListNode tail = null;
        while (temp != null) {
            n++;
            tail = temp;
            temp = temp.next;
        }

        k = k % n;
        if (k == 0) return head; 

        int stepsToNewTail = n - k - 1;
        ListNode curr = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;
    }
}
