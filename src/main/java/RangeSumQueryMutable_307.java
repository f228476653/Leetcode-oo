// use when array is not static, ans constantly use
// this is where Fenwick tree comes in

public class RangeSumQueryMutable_307 {
    int[] fenwick, nums;

    public void NumArray(int[] nums) {
        fenwick = nums.clone();
        for (int i = 1; i <= nums.length; i++) {
            int p = (i + (i & -i)) - 1;
            //Binary AND Operator copies a bit to the result if it exists in both operands.
            //a = 0011 1100
            //b = 0000 1101
            //(A & B) will give 12 which is 0000 1100
            System.out.println("p="+p);
            if (p < fenwick.length){
                System.out.println("fw_p="+fenwick[p]);
                fenwick[p] += fenwick[i - 1];
                System.out.println(fenwick[i - 1]);
            }
        }
        this.nums = nums;
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        int i = index + 1;
        while (i <= fenwick.length) {
            fenwick[i - 1] += diff;
            i += i & -i;
        }
    }

    public int sumRange(int left, int right) {
        int leftSum = 0, rightSum = 0;
        int i = left;
        while (i > 0) {
            leftSum += fenwick[i - 1];
            i -= i & -i;
        }
        i = right + 1;
        while (i > 0) {
            rightSum += fenwick[i - 1];
            i -= i & -i;
        }
        return rightSum - leftSum;
    }

    public static void main(String[] args) {
        RangeSumQueryMutable_307 a = new RangeSumQueryMutable_307();
        int intput[] = {1, 3, 5,8,9,0};
        a.NumArray(intput);

    }
}
