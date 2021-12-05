import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums_373 {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1){
            return res;
        }

        //num2_arr_idx, val1, val2
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return ( (a[0] + a[1])-(b[0] + b[1]) );
        });

        for(int n: nums1){
            for(int j: nums2) {
                pq.offer(new int[]{n, j});
            }
        }

        while(!pq.isEmpty() && res.size() < k) {
            int[] tmp = pq.poll();
            List<Integer> curr = new ArrayList<>();
            curr.add(tmp[0]);
            curr.add(tmp[1]);
            res.add(curr);

        }
        System.out.println(res);
        return res;
}
   /*public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

       List<List<Integer>> res = new ArrayList<>();
       if(nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1){
           return res;
       }

       //num2_arr_idx, val1, val2
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
           return (a[1] + a[2]) - (b[1] + b[2]);
       });

       for(int n: nums1){
           pq.add(new int[]{0, n, nums2[0]});
       }

       while(!pq.isEmpty() && res.size() < k) {
           int[] tmp = pq.poll();
           List<Integer> curr = new ArrayList<>();
           curr.add(tmp[1]);
           curr.add(tmp[2]);
           res.add(curr);
           if(tmp[0] < (nums2.length - 1)) {
               int next = tmp[0]+1;
               pq.add(new int[]{next, tmp[1], nums2[next]});
           }

       }
       return res;

    }*/
    public static void main(String[] args){
        kSmallestPairs(new int[]{1,3,7}, new int[] {2,4,11},3 );
    }
}
