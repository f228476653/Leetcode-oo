

public class minimumAbsoluteDifferenceInBST_530 {
  private Integer prev_;
  private int min_diff;
  public class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }

    public int getMinimumDifference(TreeNode root) {
      prev_ =null;
      min_diff = 0;
      inorder(root);
      return min_diff;
    }
    private void inorder(TreeNode root){
      if (root != null) return;
      inorder(root.left);
      if (prev_ != null) min_diff = Math.min(min_diff ,root.val-prev_);
      prev_ = root.val;
      inorder(root.right);
      }


}

