import java.lang.reflect.Array;
import java.util.Arrays;
// would be compare (0,length-2) & (1,length-1)
public class House_Robber_II_213 {
    int len;
    public int rob(int[] nums) {
        len =nums.length;
        if(len<2){
            return nums[0];
        }
        if(len==3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        return Math.max(helper(nums, new int[len],0,len-2),helper(nums, new int[len],1,len-1));
    }

    private int helper(int[] nums,int[] memo,int start, int end){
        memo[start]=nums[start];
        memo[start+1]=nums[start+1];
        memo[2]=nums[start+2]+memo[0];
        for(int i=3; i<=end; i++){
            memo[i] = Math.max(Math.max(memo[i-2], memo[i-3]) + nums[i],memo[i-1]);
        }
        System.out.println(Arrays.toString(memo));
        return memo[end];
    }
//    int[] memo;
//    int len;
//    public int rob(int[] nums) {
//        len =nums.length;
//        if(len<2){
//            return nums[0];
//        }
//        memo = new int[len];
//        memo[0]=nums[0];
//        memo[1]=nums[1];
//        if(len==2) {
//            return Math.max(nums[0], nums[1]);
//        }
//        for(int i=2;i<len; i++){
//            helper(i,nums[i]);
//        }
//        if((nums[0]>nums[1]) &&(nums[len -1]>nums[len -2])){
//            return Math.max(memo[len -2],Math.max(memo[len -1]-nums[0],memo[len -1]-nums[len-1]));
//        }else{
//            return Math.max(memo[len -2],memo[len -1]);
//        }
//    }
//    private void helper(int n,int cur){
//        if(n<3){
//            memo[n]=memo[n-2]+cur;
//        }else {
//            memo[n]=Math.max(memo[n-2],memo[n-3])+cur;
//        }
//   }
    public static void main(String[] args) {
        //int[] a = {12,33,30,3,4,9,10};
        //int[] a = {200,3,140,20,10};
        int[] a = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
        int sum = new House_Robber_II_213().rob(a);
        System.out.println(sum);
    }
}
