import java.util.*;

public class FindLargestValueInEachTreeRow_515 {

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

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> re = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int max=Integer.MIN_VALUE;
            int s = qu.size();
            for(int i = 0; i<s;i++){
                TreeNode top = qu.remove();
                if(top.val > max){
                    max = top.val;
                }
                if(top.left != null){
                    qu.add(top.left);
                }
                if(top.right != null){
                    qu.add(top.right);
                }
            }
            re.add(max);
        }
        return re;
    }


}
