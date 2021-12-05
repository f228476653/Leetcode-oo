import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        int size =0;
        if(root == null){
            return rs;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            size=q.size();
            for(int i =0;i<size;i++){
                TreeNode target = q.poll();
                if(i==0) rs.add(target.val);
                if(target.right != null){
                    q.offer(target.right);
                }
                if(target.left != null){
                    q.offer(target.left);
                }
            }
        }
        return rs;
    }
}
