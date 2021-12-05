import java.util.*;
public class numberof1Bits_191 {
    public static int hammingWeight(int n) {
        System.out.println(n);
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if(((1 << i) & n) != 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int a =hammingWeight(11);
        System.out.println(a);
    }
}
