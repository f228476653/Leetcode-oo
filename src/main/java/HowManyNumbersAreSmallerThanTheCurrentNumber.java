import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

        public static int[] smallerNumbersThanCurrent(int[] nums) {
            int[] smaller =new int[101];
            for(int i=0;i< nums.length;i++){
                smaller[nums[i]]++;
            }
            //1 2 3 4 5 6 7 8 9...101
            //1 2 1 0 0 0 0 1
            for(int i=1; i<smaller.length;i++){
                smaller[i]+=smaller[i-1];
            }
            int rs[]= new int[nums.length];
            for(int i=0;i< nums.length;i++){
                if(nums[i]==0){
                    rs[i]=0;
                }else{
                    rs[i] =smaller[nums[i]-1];
                }
            }
            return rs;
        }

    public static void main(final String[] args) {

        int[] input ={5,3,6,84,28,4,8};
        smallerNumbersThanCurrent(input);
    }
}
