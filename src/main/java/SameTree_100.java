import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(bfs(p) == bfs(q)){
//            return true;
//        }
//        return false;
//    }
//    public List<Integer> bfs(TreeNode target){
//        List<Integer> compare = new ArrayList<>();
//        Queue<TreeNode> pq = new PriorityQueue<>();
//        compare.add(target.val);
//        if (target != null){
//            pq.add(target);
//        }
//        while(pq.size()>0){
//            TreeNode temp = pq.poll();
//            pq.add(temp.left);
//            compare.add(target.left.val);
//            pq.add(temp.right);
//            compare.add(target.right.val);
//        }
//        return compare;
//    }
//
}
