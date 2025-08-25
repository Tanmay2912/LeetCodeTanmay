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
    public ListNode findKthNode(ListNode temp, int k) {
        k -= 1;
        while(temp != null && k>0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = head;
        ListNode prevNode = null;
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                    break;
                }
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            ListNode reverseHead = reverseLinkedList(temp); // Always store reverseHead to escape null pointer exception
            if(temp == head) {
                head = reverseHead;
            }
            else {
                prevNode.next = reverseHead;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}