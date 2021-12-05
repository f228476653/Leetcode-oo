import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Balance_a_Binary_Search_Tree_1382 {
    List<TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }
    void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }
    TreeNode sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid= (end-start)/2;
        TreeNode balance = new TreeNode();
        balance.val = sortedArr.get(mid).val;
        balance.left = sortedArrayToBST(start,mid-1);
        balance.right = sortedArrayToBST(mid+1,end);
        return balance;
    }
    public static void main(String[] args){
        TreeNode balance1 = new TreeNode(1);
        TreeNode balance2 = new TreeNode(2);
        TreeNode balance3 = new TreeNode(3);
        TreeNode balance4 = new TreeNode(4);
        TreeNode balance5 = new TreeNode(5);
        TreeNode balance6 = new TreeNode(6);
        balance1.left=balance2;
        balance2.left=balance3;
        balance3.left=balance4;
        balance4.left=balance5;
        balance5.left=balance6;
        TreeNode re = new Balance_a_Binary_Search_Tree_1382().balanceBST(balance1);
        System.out.println(re);
    }
}
