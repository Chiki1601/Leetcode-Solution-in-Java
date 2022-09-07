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
  public String tree2str(TreeNode t) {
    return dfs(t);
  }

  private String dfs(TreeNode root) {
    if (root == null)
      return "";
    if (root.right != null)
      return root.val + "(" + dfs(root.left) + ")(" + dfs(root.right) + ")";
    if (root.left != null)
      return root.val + "(" + dfs(root.left) + ")";
    return root.val + "";
  }

}
