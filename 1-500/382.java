import java.math.*;
class Solution {
    List<ListNode> ans = new ArrayList<>();
    public Solution(ListNode head) {
        while(head!=null){
            ans.add(head);
            head = head.next;
        }
    }
    
    public int getRandom() {
        return ans.get((new Random()).nextInt(ans.size())).val;
    }
}
