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
  public ListNode deleteMiddle(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode slow = dummy;
    ListNode fast = dummy;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Delete the middle node
    slow.next = slow.next.next;
    return dummy.next;
  }
}
