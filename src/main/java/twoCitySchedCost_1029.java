import java.util.*;

public class twoCitySchedCost_1029 {
    public static int twoCitySchedCost(int[][] costs) {
//        int min= 0;
//        for(int[]item : costs){
//            min += Math.min(item[0],item[1]);
//        }
//        return min;
        Arrays.sort(costs , (a,b)-> (a[0]-a[1]) -(b[0]-b[1]));
        printArray(costs);
        int sum =0;
        for(int i =0; i< costs.length; i++){
            if(i < costs.length/2 ){
                sum += costs[i][0];
                System.out.println(costs[i][0]);
            }else {
             sum+= costs[i][1];
                System.out.println(costs[i][1]);
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int a[][]={{10,20}, {30,200}, {400,50}, {30,20}};
        //[[10,20],[30,200],[400,50],[30,20]]
        int b = twoCitySchedCost(a);
        System.out.print(b);
    }
    public static void printArray(int[][] cost){
        for(int[] a :cost){
            System.out.print(Arrays.toString(a) + " ");
        }
    }
}
