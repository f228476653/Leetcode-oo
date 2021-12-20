import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompleteBinaryTreeInserter_919 {
    List<TreeNode> rs = new ArrayList<TreeNode>();
    public CompleteBinaryTreeInserter_919(TreeNode root) {
        TreeNode temp;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            temp =q.poll();
            if(temp.left != null){
                q.offer(temp.left);
            }
            if(temp.right != null){
                q.offer(temp.right);
            }
            rs.add(temp);
        }
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val,null,null);
        int parentVal =0;
        for(TreeNode t:rs){
            if(t.left == null){
                t.left=newNode;
                parentVal =t.val;
                break;
            }else if(t.right == null){
                t.right=newNode;
                parentVal =t.val;
                break;
            }
        }
        return parentVal;
    }

    public TreeNode get_root() {
        return rs.get(0);
    }
}
