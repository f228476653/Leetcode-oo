public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        s = Integer.parseInt(Integer.toString(s)+Integer.toString(n.val));
        if (n.left == null && n.right == null) return s;
        int leftSum = sum(n.left, s);
        int rightSum = sum(n.right, s);
        return leftSum + rightSum;
    }
}
