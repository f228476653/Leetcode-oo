import java.util.Arrays;

public class jumpGame_55 {
    boolean[] canReach;
    int[] _nums;
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        canReach= new boolean[nums.length];
        for(int j =0;j<=nums.length-2;j++){
            for(int i =0;i<nums[j];i++){
                if(j+i<=nums.length-1)canReach[j+i]= true;
            }
        }
        System.out.println(Arrays.toString(canReach));
        return canReach[nums.length-1];
    }
//    private boolean helper(int index){
//        if(canReach[index]) return true;
//        for(int j =0;j<=_nums.length;j++){
//            for(int i =1;i<=_nums[j];i++){
//                canReach[j+i]= true;
//            }
//        }
//        return true;
//    }
    public static void main(final String[] args) {
        final int[] nums1 = { 3,2,1,0,4 };
        new jumpGame_55().canJump(nums1);
    }
}
