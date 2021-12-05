class Max_array_53{
    public int maxSubArray2(int[] nums) {
        int max =-22222222;
        int temp =-22222222;
        if (nums.length == 1){
            return nums[0]; 
        }
        for (int i =0; i<nums.length ; i++){
            temp=nums[i];
            max =Math.max(temp,max);
            for (int j =i+1; j<nums.length ; j++){
                max =Math.max(nums[j],max);
                temp += nums[j];
                max =Math.max(temp,max);
                
            }
        }
        return max;
    }

    public int maxSubArray(int[] A) {
        int dp[] = new int[A.length]; int max = A[0]; dp[0] = A[0]; 
        for (int i = 1; i < A.length; i++) {			
            dp[i] = Math.max(dp[i-1] + A[i] ,A[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

