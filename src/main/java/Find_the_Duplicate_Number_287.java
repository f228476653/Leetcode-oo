import java.util.*;

public class Find_the_Duplicate_Number_287 {
    public static int findDuplicate(int[] nums) {
        // sort
        //and find duplicate

//        Arrays.sort(nums);
//        Map<Integer,Integer> a = new HashMap<>();
//        for(int i =0; i<nums.length; i++){
//            if(a.containsKey(nums[i])){
//                return nums[i];
//            }
//            a.put(nums[i],1);
//        }
//        return 0;
        int n = nums.length;
        int[] count = new int[n+1];

        count[0] = 0;

        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;

        }

        for(int i = 1; i<count.length; i++){
            if(count[i] >= 2)
                return i;
        }
        return 0;
    }
    public static void main(String[] args){
        int b =findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(b);
    }
}
