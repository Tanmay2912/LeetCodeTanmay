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
/*class Solution {
    public ListNode deleteFromList(ListNode head, int key) {
        while (head != null && head.val == key) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == key) {
                temp.next = temp.next.next; 
            } 
            else {
                temp = temp.next; 
            }
        }
        return head;
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int key : nums) {
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }
            map.put(key, 1);
        }
        ListNode temp = head;
        while(temp != null) {
            if(map.containsKey(temp.val)) {
                head = deleteFromList(head, temp.val);
            }
        }
        return head;
    }
}*/
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> removeSet = new HashSet<>();
        for (int num : nums) {
            removeSet.add(num);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (removeSet.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } 
            else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
