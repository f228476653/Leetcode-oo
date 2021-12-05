//solution1 :
//get lowest common ancestor(LCA)
//node A and node B LCA is C
//so distance between A&B is distance(A,C)+(B,C)
//
//solution2
//get how many node and distance

import java.util.*;

public class NumberOfGoodLeafNodesPairs_1530 {
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }

    int[] dfs(TreeNode root,int distance){
        if(root == null)
            return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1]++;
            //System.out.println(Arrays.toString(res));
            return res;
        }
        int[] left = dfs(root.left,distance);
        System.out.println(Arrays.toString(left));
        int[] right = dfs(root.right,distance);
        System.out.println(Arrays.toString(right));
        for(int l=1;l<left.length;l++){
            for(int r = distance-1;r>=0;r--){
                if(l+r <=distance)
                    result += left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i=res.length-2;i>=1;i--){
            res[i+1] = left[i]+right[i];
        }

        return res;
    }
    public static void main(String[] args){
        TreeNode test1 = new TreeNode(1);
        TreeNode test2 = new TreeNode(2);
        TreeNode test3 = new TreeNode(3);
        TreeNode test4 = new TreeNode(4);
        TreeNode test5 = new TreeNode(5);
        test1.left=test2;
        test1.right=test3;
        test2.right=test4;
        test4.right=test5;
        new NumberOfGoodLeafNodesPairs_1530().countPairs(test1,3);
    }
}
