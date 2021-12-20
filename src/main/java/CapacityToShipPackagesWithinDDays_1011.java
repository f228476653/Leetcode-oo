public class CapacityToShipPackagesWithinDDays_1011 {

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int wi: weights) {
            left = Math.max(left, wi);
            right += wi;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9,10};
        int retrun = new CapacityToShipPackagesWithinDDays_1011().shipWithinDays(test,5);
    }
}


//    The key is left = max(weights), right = sum(weights),
//    which are the minimum and maximum possible weight capacity of the ship.
//
//        Therefore the question becomes Binary Search to find the minimum weight capacity of the ship between left and right.
//        We start from
//        mid = (left + right) / 2 as our current weight capacity of the ship.
//        need = days needed == 1
//        cur = current cargo in the ship == 0
//
//        Start put cargo into ship in order.
//        when need > D, it means the current ship is too small, we modify left = mid + 1 and continue
//        If all the cargo is successfully put into ships, we might have a chance to find a smaller ship, so let right = mid and continue.
//        Finally, when our left == right, we reach our answer


//    Think of this problem in this way. Forget about binary search to begin with.
//
//        What is the min that the ship should carry in a day? = It should carry atleast the max in the array. Meaning, if the max weight is 10, and the ship can carry only 9, that doesnt make sense.
//        Now what is the max the ship can carry? = The sum of all the weights. You can think of this as, if you get an array but the no of days is D =1 , ie, the ship has to carry all the weight in one day, then you dont have an option except to carry all the weight. So the max = sum of items in the array.
//        No logically speaking the min weight the ship can distribute is somewhere in between this min and max. right?
//        Therefore you have a lower bound and an upper bound, and you have to find the ideal weight the ship can carry. This is quite a good clue to lean towards binary search because you can get to the answer in log(n) time.