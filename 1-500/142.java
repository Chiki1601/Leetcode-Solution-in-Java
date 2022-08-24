public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;//
        Set<ListNode> nodeSet = new HashSet<>();//
        while (head.next != null) {//
            if (nodeSet.contains(head)) return head;//
            nodeSet.add(head);//
            head = head.next;//
        }
        return null;
    }
}
