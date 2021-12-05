import java.util.Arrays;

public class sortColor {
    class Solution {
        public void sortColors(int[] nums) {
            int[] count = new int[3];
            for (int num : nums) count[num]++;

            int index = 0;
            for (int i = 0; i < count.length; i++) {
                for (int j = 0; j < count[i]; j++) {
                    nums[index++] = i;
                }
            }
        }
    }
}