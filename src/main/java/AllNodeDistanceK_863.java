import java.util.*;


public class AllNodeDistanceK_863 {
    private static Map<TreeNode, List<TreeNode>> map = new HashMap();
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer> ();
        if (root == null || K < 0) return res;
        buildMap(root, null);
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size ; i++) res.add(q.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }
        return res;
    }

    private static void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null)  { map.get(node).add(parent); map.get(parent).add(node) ; }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
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
        //SwapNodesInPairs_24.swapPairs(one);
        AllNodeDistanceK_863.distanceK(balance1,balance3,2);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//class Solution {
//    Map<TreeNode, List<TreeNode>> map = new HashMap();
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new List<>();
//        if(K==0 || root==null){
//            return res;
//        }
//        buildMap();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        Set<TreeNode> visited = new Set<>();
//        queue.add(target);
//        visited.add(target);
//        while(!queue.empty()){
//            int size = queue.size();
//            if(K == 0){
//                for(int i=0;i<size;i++){
//
//                }
//                res.add();
//            }
//        }
//    }
//
//    private void buildMap(TreeNode node, TreeNode parent) {
//        if (node == null ) return;
//        if (!map.containsKey(node)){
//            List<TreeNode> nodes = new List<>();
//            if(parent != null){
//                map.get(node).add(parent);
//                map.get(parent).add(node);
//            }
//        }
//
//    }
//}