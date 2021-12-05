public class min_cost_climbing_stairs_746 {
    int length =0;
    int[] cost;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(helper(cost, n-1), helper(cost, n-2));
    }
    public int helper(int[] cost,int n){
        if (n < 0) return 0;
        if (n==0 || n==1) return cost[n];
        if (dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(helper(cost, n-1), helper(cost, n-2));
        return dp[n];
    }

    public static void main(String[] args) {
        //int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int[] cost = {10,15,20};
        min_cost_climbing_stairs_746 s = new min_cost_climbing_stairs_746();
        int rs = s.minCostClimbingStairs(cost);
    }
}
