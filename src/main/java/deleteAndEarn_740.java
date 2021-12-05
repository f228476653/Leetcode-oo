import java.util.HashMap;
import java.util.Map;

public class deleteAndEarn_740 {
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[11];
        for(int n:nums){
            bucket[n] += n ;
        }
        return helper(bucket);
    }
    private int helper(int[] bucket ){
        int first =bucket[1];
        //System.out.println(first);
        int second = Math.max(bucket[1], bucket[2]);
        //System.out.println(second);
        int max = second;
        //System.out.println(max);
        for(int i =3; i< bucket.length; i++ ){
            max = Math.max(second,first+bucket[i]);
            first = second;
            second = max;
            //System.out.println(max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = { 2,2,3,3,3,4};
        int sum = new deleteAndEarn_740().deleteAndEarn(a);
        System.out.println(sum);
   }
}

