import java.util.HashMap;
import java.util.Map;

public class Two_Sum_001 {
    public static int[] twoSum( int[] nums,  int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[] { map.get(j) ,i };
            }
            map.put(nums[i], i);
        }
        return null;

    }

    
    public static void main(String[] args) {
        int[] a = {3,6,9};
        int[] sum = twoSum(a, 12);
        System.out.println(sum);
   }

}

