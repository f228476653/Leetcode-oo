import java.util.Arrays;
public class InsertionSort {
    public int[] sort(int[] input){
        for(int i=1;i<input.length;i++){
            int key =input[i];
            int j = i-1;
            while (j>=0 && input[j]>key){
                input[j+1]=input[j];
                j--;
            }
            input[j+1] = key;
        }
        return input;
    }
    public static void main(final String[] args) {
        InsertionSort ns = new InsertionSort();
        int[] input ={5,3,6,84,28,4,8};
        int[] b= ns.sort(input);
        System.out.println(Arrays.toString(b));
    }
}