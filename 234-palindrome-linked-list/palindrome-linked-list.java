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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
    //     ListNode secondHalf = reverse(slow);
    //     ListNode p1 = head;
    //     ListNode p2 = secondHalf;
    //     while (p2 != null) {
    //         if (p1.val != p2.val) {
    //             return false;
    //         }
    //         p1 = p1.next;
    //         p2 = p2.next;
    //     }
    //     return true;
    // }
    // public ListNode reverse(ListNode head) {
    //     ListNode prev = null;
    //     ListNode curr = head;
    //     while (curr != null) {
    //         ListNode nextTemp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = nextTemp;
    //     }
    //     return prev;