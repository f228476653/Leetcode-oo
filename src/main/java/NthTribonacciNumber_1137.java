public class NthTribonacciNumber_1137 {
    public int tribonacci(int n) {
        int [] memo = new int[n+1];
        if (n<2){
            return n;
        }
        memo[0]=0;
        memo[1]=1;
        memo[2]=1;
        return helper(n, memo);
    }
    private int helper (int n,int[] memo){
        if(memo[n] != 0 || n<3){
            return memo[n];
        }
        memo[n] = helper(n-3,memo)+helper(n-2,memo)+helper(n-1,memo);
        return memo[n];
    }
}
