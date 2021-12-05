import java.util.HashMap;
import java.util.Map;

public class houseRobber_198 {
//    public static int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }
//        int dp[] = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
//        }
//        return dp[nums.length - 1];
//    }
    static Map<Integer,Integer> memo;
    static int[] numsArray;
    static int len;
    public static int rob(int[] nums) {
        memo = new HashMap<>();
        numsArray = nums;
        len = nums.length;
        if(nums.length<2){
            return nums[0];
        }
        return Math.max(helper(len-1),helper(len-2));
    }
    private static int helper(int n){
        if(n < 0){
            return 0;
        }
        if(memo.containsKey(n)){
            return memo.get(n) ;
        }else {
            memo.put(n, numsArray[n] + Math.max(helper(n-2),helper(n-3)));
        }
        return memo.get(n);
    }
    public static void main(String[] args) {
        int[] a = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int sum = new houseRobber_198().rob(a);
        System.out.println(sum);
   }
}

