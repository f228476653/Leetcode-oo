public class Perfect_Squares_279 {
    public int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        // edge cases
        if(n<=3){
            return n;
        }
        int[] dp = new int[n+1];
        for(int i = 0;i< n+1; i++){
            dp[i] = i;
            for(int j = 1;j*j<= i; j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
            //System.out.print(dp[i]);
        }
        //System.out.print(Arrays.toString(dp));
        return dp[n];
    }
}
