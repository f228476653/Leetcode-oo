import java.util.*;

public class allPossibleTree_894 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<TreeNode> allPossibleFBT(int N) {
        System.out.println(N);
        if (N % 2 == 0) return new ArrayList();
        List<TreeNode> result = new ArrayList();
        recurse(result, N);
        return result;
    }

    public static void recurse(List<TreeNode> result, int N) {

        if (N == 1) {
            TreeNode node = new TreeNode(0);
            result.add(node);
            return;
        }

        for (int i = 1; i < N; i += 2) {

            List<TreeNode> leftTrees = allPossibleFBT(i);
            List<TreeNode> rightTrees = allPossibleFBT(N - i - 1);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }

    }
        public static void main (String[]args){
            allPossibleFBT(7);
        }
    }
