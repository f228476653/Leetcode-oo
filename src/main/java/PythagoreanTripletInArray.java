public class PythagoreanTripletInArray {
    static int pair = 0;
    public static int pythagoreanTriplet(int[] exmaple) {
        int low =0;
        int high = exmaple.length-1;
        int sq[]= new int[exmaple.length];
        for(int i = 0; i< exmaple.length; i++){
            sq[i] = exmaple[i] * exmaple[i];
        }
        for(int j = sq.length -1; j>= 0; j--){
            low =0;
            high = j-1;
            getData(low, high, sq, sq[j]);
        }

        return pair;
    }
    public static void getData(int low, int high, int[] sq , int target) {
        if(low< high) {
            if (sq[low] + sq[high] < target) {
                low++;
                getData(low, high, sq, target);
            }else if(sq[low] + sq[high] > target){
                high--;
                getData(low, high, sq, target);
            }else{
                pair++;
            }
        }
    }

    public static void main(String[] args){
        int a[]={3,4,5,6,7,8,9,10,12,13};
        int b = pythagoreanTriplet(a);
        System.out.print(b);
    }

}
