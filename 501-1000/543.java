/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=1;
    public int diameterOfBinaryTree(TreeNode root) {
        goDeep(root);
        // The number of edges is required and not nodes
        return ans-1;
    }
    private int goDeep(TreeNode root){
        if(root==null)return 0;

        int left = goDeep(root.left);
        int right = goDeep(root.right);
        // Global answer
        ans = Math.max(ans,1+left+right);
        
        // Value that can be used by parent
        return Math.max(left,right)+1;
    }
}
