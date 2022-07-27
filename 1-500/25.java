class Solution {

       public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
    
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {  
           
            if (tail == null) {
        
                return head;
            }
            tail = tail.next;
        }
    
        ListNode newHead = reverse(head, tail);
        
        head.next = reverseKGroup(tail, k);

        return newHead;
    }
    private ListNode reverse(ListNode curr, ListNode tail) {
    
        ListNode pre = null;
        ListNode next = null;
        while (curr != tail) { 
    
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
