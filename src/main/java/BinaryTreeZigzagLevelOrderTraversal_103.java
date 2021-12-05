import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        int count =1;
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return rs;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode target = q.poll();
                temp.add(target.val);
                if(target.right!=null){
                    q.offer(target.right);
                }
                if(target.left!=null){
                    q.offer(target.left);
                }
            }

            if(count%2 == 1){
                Collections.reverse(temp);
            }
            rs.add(temp);
            count++;
        }
        return rs;
    }
}
