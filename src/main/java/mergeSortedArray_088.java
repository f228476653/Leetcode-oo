

public class mergeSortedArray_088 {
    public static void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
        int p = m+n;
        int p1= m-1;
        int p2= n-1;
        while (p<=0){
            if (nums1[p1]>nums2[p2]){
                
            }
        }
    }

    public static void main(final String[] args) {
        final int[] nums1 = { 1, 3, 4, 0, 0, 0 };
        final int[] nums2 = { 2, 3, 4 };
        merge(nums1, 3, nums2, 3);
        
   }

}

