class Solution {
    public ListNode removeNodes(ListNode head) {

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        List<Integer> nodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp.val);
            temp = temp.next;
        }

        
        Set<Integer> indexDeleted = new HashSet<>();

        for (int i = nodes.size() - 1; i >= 0; i--) {
            if (tm.higherKey(nodes.get(i)) != null && tm.higherKey(nodes.get(i)) > nodes.get(i)) {
                indexDeleted.add(i);
            }
            tm.put(nodes.get(i), tm.getOrDefault(nodes.get(i), 0) + 1);
        }

        ListNode ptr = new ListNode(-1);
        ptr.next = head;

        ListNode cur = head;
        ListNode prev = ptr;

        int curr = 0;

        while (cur != null) {
            if (indexDeleted.contains(curr++)) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return ptr.next;

    }
}
